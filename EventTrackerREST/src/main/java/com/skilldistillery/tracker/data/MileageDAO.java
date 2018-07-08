package com.skilldistillery.tracker.data;

import java.util.List;
import com.skilldistillery.tracker.entities.Mileage;

public interface MileageDAO {
	
	public List<Mileage> getMileageRecords();
	public Mileage getMileageById(int id);
	public Mileage createMileageRecord(Mileage mileage);
	public Mileage replaceMileageRecord(String mileageJson, int id);
	public Mileage updateMileageRecord(String mileageJson, int id);
	public boolean deletePost(int id);

}
