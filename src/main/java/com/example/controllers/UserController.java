package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.User;
import com.example.services.UserService;

@RestController("UserController")	// Defines this class as REST controller named UserController

/*
 * This allows connections from sites other than the one this server is running on.
 * We do not need this annotation because we have setup a global filter that 
 * fixes the CORS issues. See the ConfigCtrl.java file.
 *
 * @CrossOrigin(origins="*")
 */		
@RequestMapping("/api")			// This sets the parent part of the url for the api calls
public class UserController {
	
	@Autowired
	private UserService uServ;
	
	/*
	 *	The following methods define the REST API endpoints into 
	 *	the application. The full url will be https://your-url/api/mapping-from-below
	 *	
	 *	In the case of a localhost application the url would be
	 *	https://localhost:9002/api/mapping-from-below
	 * 
	 * We use a GetMapping here to because we do not need to protect any of the data
	 * https://localhost:9002/api/getUsers
	 * The @ResponseBody will return a json object List of Users
	 */
	 @GetMapping("/getUsers")
	 public @ResponseBody List<User> getUsers() {
		 return uServ.getAllUsers();
	 }
	 /*
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/createUser
	 * The @ResponseBody will return a json object representing a user
	 */	
	 @PostMapping("/createUser")
	 public @ResponseBody User createUser(@RequestBody User user) {
		 // Connect to the UserService to create a new user
		 return uServ.insertUser(user);
	 }
	 /*
	 * We use a PostMapping here to protect the user information from being posted in the url
	 * https://localhost:9002/api/getUserByEmail
	 * The @ResponseBody will return a json object representing a user
	 */	
	 @PostMapping("/getUserByEmail")
	 public @ResponseBody User getUserByEmail(@RequestBody User user) {
		 // Connect to the UserService to get a user using their email address
		 return uServ.getUserByEmail(user);
	 }

}