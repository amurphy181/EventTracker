package com.skilldistillery.tracker.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mileage createMileageRecord(Mileage mileage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mileage replaceMileageRecord(String mileageJson, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mileage updateMileageRecord(String mileageJson, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePost(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
