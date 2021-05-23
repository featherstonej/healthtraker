package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.GlucoseReading;
import com.example.models.User;
import com.example.services.GlucoseReadingService;

@RestController("GlucoseReadingController")	// Defines this class as REST controller named GlucoseReadingController

/*
 * This allows connections from sites other than the one this server is running on.
 * We do not need this annotation because we have setup a global filter that 
 * fixes the CORS issues. See the ConfigCtrl.java file.
 *
 * @CrossOrigin(origins="*")
 */
@RequestMapping("/api")			// This sets the parent part of the url for the api calls
public class GlucoseReadingController {
	
	@Autowired
	private GlucoseReadingService gServ;
	
	/*
	 *	The following methods define the REST API endpoints into 
	 *	the application. The full url will be https://your-url/api/mapping-from-below
	 *	
	 *	In the case of a localhost application the url would be
	 *	https://localhost:9002/api/mapping-from-below
	 * 
	 * We use a GetMapping here to because we do not need to protect any of the data
	 * https://localhost:9002/api/getGlucoseReading
	 * The @ResponseBody will return a json object List of GlucoseReading
	 */
	@GetMapping("/getGlucoseReading")
	public @ResponseBody  List<GlucoseReading> getGlucoseReadings() {
		return gServ.getAllReadings();
	}
	/* 
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/getAvgSugar
	 * The @ResponseBody will return a json object List of average glucose readings
	 */
	@PostMapping("/getAvgSugar")
	public @ResponseBody List<Integer> getAverageReadings(@RequestBody User user) {
		// Connect to the GlucoseReadingService to get the List
		return gServ.getAverageReadings(user);
	}
	/* 
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/getGlucoseByUser
	 * The @ResponseBody will return a json object List of GlucoseReading
	 */
	@PostMapping("/getGlucoseByUser")
	public @ResponseBody List<GlucoseReading> getGlucoseReadingsByUser(@RequestBody User user) {
		// Connect to the GlucoseReadingService to get the List
		return gServ.getAllReadingsByUser(user);
	}
	/* 
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/createGlucose
	 * The @ResponseBody will return a json object representing the new reading
	 */
	@PostMapping("/createGlucose")
	public @ResponseBody GlucoseReading createReading(@RequestBody GlucoseReading reading) {
		// Connect to the GlucoseReadingService to create a new reading
		return gServ.insertGlucoseReading(reading);
	}
}