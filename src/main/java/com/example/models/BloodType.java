package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
// Hibernate annotation to assign the table name in the database
@Table(name="bloodtypes")	
/* 
 * These properties are ignored when a json file is generated. 
 * Without this annotation we would create a circular reference to the user.
 */		
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "users"})
public class BloodType {
	/*
	 * This is the unique identifier for this model.
	 * Hibernate uses the following annotations to create this 
	 * column as the primary key for the table and 
	 * auto generate a key for each new record.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bloodtypeid", unique=true, nullable=false)
	private int bloodTypeId;
	
	@Column(name="bloodtype", unique=true, nullable=false, length=10)
	private String type;
	
	// Hibernate uses this annotation to determine the relationship between two tables
	@OneToMany(mappedBy="bloodTypeHolder")
	private List<User> users = new ArrayList<>();

	// Empty Constructor
	public BloodType() {}

	// Constructor with all fields except the id
	public BloodType(String type, List<User> users) {
		super();
		this.type = type;
		this.users = users;
	}

	// Constructor with all fields
	public BloodType(int bloodTypeId, String type, List<User> users) {
		super();
		this.bloodTypeId = bloodTypeId;
		this.type = type;
		this.users = users;
	}
	
	/*
	 * All fields of this class are private
	 * we need to have Setters and Getters
	 * for each field
	 */
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getBloodTypeId() {
		return bloodTypeId;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}