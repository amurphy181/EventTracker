package com.skilldistillery.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tracker.data.MileageDAO;
import com.skilldistillery.tracker.entities.Mileage;

@RestController
@RequestMapping("api")
public class MileageController {
	
	@Autowired
	private MileageDAO mileageDAO;
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "allMileage", method = RequestMethod.GET)
	public List<Mileage> getMileageRecords(){
		return mileageDAO.getMileageRecords();
	}
	
	@RequestMapping(path = "mileage/{id}", method = RequestMethod.GET)
	public Mileage getMileageById(@PathVariable int id) {
		return mileageDAO.getMileageById(id);
	}
	
	@RequestMapping(path ="mileage", method = RequestMethod.POST)
	public Mileage create(@RequestBody Mileage mileage, HttpServletRequest request, HttpServletResponse response) {
		
		if(mileageDAO.createMileageRecord(mileage).equals(mileageDAO.getMileageById(mileage.getId()))) {
			response.setStatus(201);
			return mileageDAO.createMileageRecord(mileage);
		}
		response.setStatus(500);
		return null;
	}
	
	@RequestMapping(path = "mileage/{id}", method = RequestMethod.PUT)
	public Mileage replaceOldMileage(@RequestBody String mileageJson, @PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		return mileageDAO.replaceMileageRecord(mileageJson, id);
	}
	
	@RequestMapping(path = "mileage/{id}", method = RequestMethod.PATCH)
	public Mileage updateOldMileage(@RequestBody String mileageJson, @PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		return mileageDAO.updateMileageRecord(mileageJson, id);
	}
	
	@RequestMapping(path = "mileage/{id}", method = RequestMethod.DELETE)
	public String deleteMileageRecord(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
		
		if(mileageDAO.deleteMileage(id)) {
			return "Mileage record was deleted";
		}
		else {
			return "Mileage record delete failed";
		}
	}

}
