package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.GlucoseReading;
import com.example.models.User;
import com.example.repo.GlucoseReadingDao;

// This annotation tells Spring this class is a service class and names the service
@Service
public class GlucoseReadingService {
	
	// Tells Spring to auto inject this bean into our class
	@Autowired
	private GlucoseReadingDao gDao;
	
	// Empty constructor
	public GlucoseReadingService() {}
	
	// Use the following methods to implement any business requirements or validation rules
	public GlucoseReading insertGlucoseReading(GlucoseReading reading) {
		return gDao.save(reading);
	}
	
	public List<GlucoseReading> getAllReadings() {
		return gDao.findAll();
	}
	
	public List<GlucoseReading> getAllReadingsByUser(User user) {
		return gDao.findByUserHolder(user);
	}
	
	public List<Integer> getAverageReadings(User user) {
		int userid = user.getUserId();
		return gDao.monSugarAverage(userid);
	}
}