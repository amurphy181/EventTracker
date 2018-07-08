package com.skilldistillery.tracker.data;

import java.util.List;

import com.skilldistillery.tracker.entities.Mileage;

public class MileageDAOImpl implements MileageDAO {

	@Override
	public List<Mileage> getMileageRecords() {
		
		return null;
	}

	@Override
	public Mileage getMileageById(int id) {
		String query = "SELECT m FROM Mileage m";
		
//		return em.createQuery(query, Mileage.class).getResultList();
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
