package com.example.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.BloodPressureReading;
import com.example.models.User;
import com.example.repo.BloodPressureReadingDao;

// This annotation tells Spring this class is a service class and names the service
@Service
public class BloodPressureReadingService {
	
	// Tells Spring to auto inject this bean into our class
	@Autowired
	private BloodPressureReadingDao bDao;
	
	// Empty constructor
	public BloodPressureReadingService() {}
	
	// Use the following methods to implement any business requirements or validation rules
	public boolean validateReading(BloodPressureReading reading) {
		if(reading.getDiastolic() > 0 && reading.getSystolic() > 0 && reading.getHeartRate() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public BloodPressureReading insertBloodPressureReading(BloodPressureReading reading) {
		if(validateReading(reading)) {
			return bDao.save(reading);			
		} else {
			return null;
		}
	}
	
	public List<BloodPressureReading> getAllBloodPressureReadings() {
		return bDao.findAll();
	}
	
	public List<BloodPressureReading> getBloodPressureReadingsByUser(User user) {
		return bDao.findByUserHolder(user);
	}
	
	public Map<String,List<Integer>> getAverageReadings(User user) {
		int userid = user.getUserId();
		Map<String, List<Integer>> myMap = new HashMap<>();
		List<Integer> sys = bDao.monSysAverage(userid);
		List<Integer> dia = bDao.monDiaAverage(userid);
		List<Integer> heart = bDao.monHearRateAverage(userid);
		myMap.put("sys", sys);
		myMap.put("dia", dia);
		myMap.put("heart",  heart);
		return myMap;
	}
}