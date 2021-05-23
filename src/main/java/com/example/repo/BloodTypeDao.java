package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.BloodType;

/*
 * This annotation tells Spring that this class contains
 * methods that need to be setup as database transactions.
 */
@Transactional
@Repository("bloodTypeDao")
/*
 * Extending the CrudRepository gives us access to some
 * basic generic methods for retrieving data from the 
 * database
 */
public interface BloodTypeDao extends CrudRepository<BloodType, Integer> {
	// Generic method for data retrieval
	public List<BloodType> findAll();
}