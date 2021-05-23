package com.example.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
// Hibernate annotation to assign the table name in the database
@Table(name="users")			
/* 
 * These properties are ignored when a json file is generated. 
 * Without this annotation we would create a circular reference to the user.
 */
@JsonIgnoreProperties({"bloodPressureReadings", "glucoseReadings"})		
public class User {
	/*
	 * This is the unique identifier for this model.
	 * Hibernate uses the following annotations to create this 
	 * column as the primary key for the table and 
	 * auto generate a key for each new record.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int userId;
	
	@Column(name="firstname", length=50)
	private String firstName;
	
	@Column(name="lastname", length=50)
	private String lastName;
	
	@Column(name="email", unique=true, nullable=false, length=150)
	private String email;
	
	// This annotation prevents the output of this field to protect the password
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name="userpassword", nullable=false, length=256)
	private String userPassword;
	
	@Column(name="dob")
	private Date dateOfBirth;
	
	// Hibernate uses this annotation to determine the relationship between two tables
	@ManyToOne(fetch=FetchType.LAZY)
	// Hibernate useses this annotation to create the foreign key column
	@JoinColumn(name="fk_bloodtypeid")
	private BloodType bloodTypeHolder;
	
	/* 
	 * This field is ignored when a json file is generated. 
	 * Without this annotation we would create a circular reference to the user.
	 */
	@JsonManagedReference
	// Hibernate uses this annotation to determine the relationship between two tables
	@OneToMany(mappedBy="userHolder")
	private List<GlucoseReading> glucoseReadings = new ArrayList<>();
	
	/* 
	 * This field is ignored when a json file is generated. 
	 * Without this annotation we would create a circular reference to the user.
	 */
	@JsonManagedReference
	// Hibernate uses this annotation to determine the relationship between two tables
	@OneToMany(mappedBy="userHolder")
	private List<BloodPressureReading> bloodPressureReadings = new ArrayList<>();

	// Empty Constructor
	public User() {}

	// Constructor with all fields except the id
	public User(String firstName, String lastName, String email, String userPassword, Date dateOfBirth,
			BloodType bloodTypeHolder, List<GlucoseReading> glucoseReadings, List<BloodPressureReading> bloodPressureReadings) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userPassword = userPassword;
		this.dateOfBirth = dateOfBirth;
		this.bloodTypeHolder = bloodTypeHolder;
		this.glucoseReadings = glucoseReadings;
	}

	// Constructor with all fields
	public User(int userId, String firstName, String lastName, String email, String userPassword, Date dateOfBirth,
			BloodType bloodTypeHolder, List<GlucoseReading> glucoseReadings, List<BloodPressureReading> bloodPressureReadings) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userPassword = userPassword;
		this.dateOfBirth = dateOfBirth;
		this.bloodTypeHolder = bloodTypeHolder;
		this.glucoseReadings = glucoseReadings;
		this.bloodPressureReadings = bloodPressureReadings;
	}
	
	/*
	 * All fields of this class are private
	 * we need to have Setters and Getters
	 * for each field
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public BloodType getBloodTypeHolder() {
		return bloodTypeHolder;
	}

	public void setBloodTypeHolder(BloodType bloodTypeHolder) {
		this.bloodTypeHolder = bloodTypeHolder;
	}

	public List<GlucoseReading> getGlucoseReadings() {
		return glucoseReadings;
	}

	public void setGlucoseReadings(List<GlucoseReading> glucoseReadings) {
		this.glucoseReadings = glucoseReadings;
	}

	public List<BloodPressureReading> getBloodPressureReadings() {
		return bloodPressureReadings;
	}

	public void setBloodPressureReadings(List<BloodPressureReading> bloodPressureReadings) {
		this.bloodPressureReadings = bloodPressureReadings;
	}

	/*
	 * All objects in java have a toString method that can be
	 * overwritten to return a custom string.
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userPassword=" + userPassword + ", dateOfBirth=" + dateOfBirth + ", bloodTypeHolder="
				+ bloodTypeHolder + ", glucoseReadings=" + glucoseReadings + ", bloodPressureReadings="
				+ bloodPressureReadings + "]";
	}
	
}