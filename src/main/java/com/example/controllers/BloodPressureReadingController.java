package com.example.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.BloodPressureReading;
import com.example.models.User;
import com.example.services.BloodPressureReadingService;

@RestController("BloodPressureReadingController")	// Defines this class as REST controller named BloodPressureReadingController

/*
 * This allows connections from sites other than the one this server is running on.
 * We do not need this annotation because we have setup a global filter that 
 * fixes the CORS issues. See the ConfigCtrl.java file.
 *
 * @CrossOrigin(origins="*")
 */
@RequestMapping("/api")			// This sets the parent part of the url for the api calls
public class BloodPressureReadingController {

	@Autowired
	private BloodPressureReadingService bServ;
	
	/*
	 *	The following methods define the REST API endpoints into 
	 *	the application. The full url will be https://your-url/api/mapping-from-below
	 *	
	 *	In the case of a localhost application the url would be
	 *	https://localhost:9002/api/mapping-from-below
	 *	 
	 * We use a GetMapping here to because we do not need to protect any of the data
	 * https://localhost:9002/api/getBP
	 * The @ResponseBody will return a json object List of BloodPressureReading
	 */
	@GetMapping("/getBP")
	public @ResponseBody List<BloodPressureReading> getBloodPressureReadings() { 
		// Connect to the BloodPressureReadingService to get the List
		return bServ.getAllBloodPressureReadings();
	}
	/*
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/getAvgBP
	 * The @ResponseBody will return a json object List of integers of average blood pressure reading
	 */	
	@PostMapping("/getAvgBP")
	public @ResponseBody Map<String, List<Integer>> getAverageReadings(@RequestBody User user) {
		// Connect to the BloodPressureReadingService to get the List
		return bServ.getAverageReadings(user);
	}
	
	/* 
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/getBPByUser
	 * The @ResponseBody will return a json object List of BloodPressureReading
	 */
	@PostMapping("/getBPByUser")
	public @ResponseBody List<BloodPressureReading> getReadingsByUser(@RequestBody User user) {
		// Connect to the BloodPressureReadingService to get the List
		return bServ.getBloodPressureReadingsByUser(user);
	}
	
	/* 
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/createBP
	 * The @ResponseBody will return a json object List of BloodPressureReading
	 */
	@PostMapping("/createBP")
	public @ResponseBody BloodPressureReading createReading(@RequestBody BloodPressureReading reading) {
		// Connect to the BloodPressureReadingService to create the new record
		return bServ.insertBloodPressureReading(reading);
	}
}