package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.BloodType;
import com.example.repo.BloodTypeDao;

@RestController("BloodTypeController")	// Defines this class as REST controller named BloodTypeController

/*
 * This allows connections from sites other than the one this server is running on.
 * We do not need this annotation because we have setup a global filter that 
 * fixes the CORS issues. See the ConfigCtrl.java file.
 *
 * @CrossOrigin(origins="*")
 */		
@RequestMapping("/api")			// This sets the parent part of the url for the api calls
public class BloodTypeController {
	
	@Autowired
	private BloodTypeDao bDao;
	
	/*
	 *	The following methods define the REST API endpoints into 
	 *	the application. The full url will be https://your-url/api/mapping-from-below
	 *	
	 *	In the case of a localhost application the url would be
	 *	https://localhost:9002/api/mapping-from-below
	 *	
	 * We use a GetMapping here to because we do not need to protect any of the data
	 * https://localhost:9002/api/getBloodType
	 * The @ResponseBody will return a json object List of BloodPressureReading
	 */
	@GetMapping("/getBloodType")
	public @ResponseBody List<BloodType> getBloodTypes() {
		// Connect directly to the BloodTypeDao to connect to the database
		return bDao.findAll();
	}

}
