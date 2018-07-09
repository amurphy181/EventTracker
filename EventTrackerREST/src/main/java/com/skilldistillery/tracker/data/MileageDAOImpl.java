package com.skilldistillery.tracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skilldistillery.tracker.entities.Mileage;

@Transactional
@Service
public class MileageDAOImpl implements MileageDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Mileage> getMileageRecords() {
		String query = "SELECT m FROM Mileage m";
		return em.createQuery(query, Mileage.class).getResultList();
	}

	@Override
	public Mileage getMileageById(int id) {

		return em.find(Mileage.class, id);
	}

	@Override
	public Mileage createMileageRecord(Mileage mileage) {
		em.persist(mileage);
		em.flush();
		return mileage;
	}

	@Override
	public Mileage replaceMileageRecord(String mileageJson, int id) {
		Mileage oldMileage = em.find(Mileage.class, id);
		Mileage newMileage = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			newMileage = mapper.readValue(mileageJson, Mileage.class);
			oldMileage.setDistance(newMileage.getDistance());
			oldMileage.setGallonsUsed(newMileage.getGallonsUsed());
			oldMileage.setMpg((newMileage.getDistance()) / newMileage.getGallonsUsed());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return oldMileage;

	}

	@Override
	public Mileage updateMileageRecord(String mileageJson, int id) {
		Mileage oldMileage = em.find(Mileage.class, id);
		Mileage updatedMileage = null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			updatedMileage = mapper.readValue(mileageJson, Mileage.class);
			if (updatedMileage.getDistance() != oldMileage.getDistance()) {
				oldMileage.setDistance(updatedMileage.getDistance());
			}
			if (updatedMileage.getGallonsUsed() != oldMileage.getGallonsUsed()) {
				oldMileage.setGallonsUsed(updatedMileage.getGallonsUsed());
			}
			if (updatedMileage.getMpg() != oldMileage.getMpg()) {
				oldMileage.setMpg((updatedMileage.getDistance() / updatedMileage.getGallonsUsed()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return oldMileage;

	}

	@Override
	public boolean deleteMileage(int id) {
		Mileage deleteMileage = em.find(Mileage.class, id);

		try {
			em.remove(deleteMileage);
			em.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
