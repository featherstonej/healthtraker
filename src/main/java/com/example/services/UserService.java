package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.repo.UserDao;

// This annotation tells Spring this class is a service class and names the service
@Service("userService")
public class UserService {
	
	// Tells Spring to auto inject this bean into our class
	@Autowired
	private UserDao uDao;
	
	// Empty constructor
	public UserService() {}

	// Use the following methods to implement any business requirements or validation rules
	public User insertUser(User user) {
		return uDao.save(user);
	}

	public User getUserById(User user) {
		return uDao.findByUserId(user.getUserId());
	}

	public List<User> getAllUsers() {
		return uDao.findAll();
	}

	public User getUserByEmail(User user) {
		User dbUser = uDao.findByEmail(user.getEmail());
		if(dbUser == null) {
			return null;
		} else {
			if(user.getUserPassword().equals(dbUser.getUserPassword())) {
				return dbUser;				
			} else {
				return null;
			}
		}
	}
}