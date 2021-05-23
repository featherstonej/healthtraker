package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.User;

/*
 * This annotation tells Spring that this class contains
 * methods that need to be setup as database transactions.
 */
@Transactional
@Repository("userDao")
/*
 * Extending the CrudRepository gives us access to some
 * basic generic methods for retrieving data from the 
 * database
 */
public interface UserDao extends CrudRepository<User, Integer> {
	// Generic methods for data retrieval
	public List<User> findAll();
	/*
	 * These methods allow you to set the column to find a record.
	 * The syntax is findBy[field from model]
	 */
	public User findByUserId(int userId);
	public User findByEmail(String email);
}