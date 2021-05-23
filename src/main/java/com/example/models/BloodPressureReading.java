package com.example.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
// Hibernate annotation to assign the table name in the database
@Table(name="bloodpressurereadings", schema="")		
public class BloodPressureReading {
	/*
	 * This is the unique identifier for this model.
	 * Hibernate uses the following annotations to create this 
	 * column as the primary key for the table and 
	 * auto generate a key for each new record.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bloodpressurereadingid", unique=true, nullable=false)
	private int bloodPressureReadingId;
	
	@Column(name="readingdate", nullable=false)
	private Date readingDate;
	
	@Column(name="systolic", nullable=false)
	private int systolic;
	
	@Column(name="diastolic", nullable=false)
	private int diastolic;
	
	@Column(name="heartrate", nullable=false)
	private int heartRate;
	
	/* 
	 * This field is ignored when a json file is generated. 
	 * Without this annotation we would create a circular reference to the user.
	 */
	@JsonBackReference
	// Hibernate uses this annotation to determine the relationship between two tables
	@ManyToOne(fetch=FetchType.LAZY)
	// Hibernate useses this annotation to create the foreign key column
	@JoinColumn(name="fk_userid")
	private User userHolder;

	// Empty Constructor
	public BloodPressureReading() {}

	// Constructor with all fields except the id
	public BloodPressureReading(Date readingDate, int systolic, int diastolic, int heartRate, User userHolder) {
		super();
		this.readingDate = readingDate;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.heartRate = heartRate;
		this.userHolder = userHolder;
	}

	// Constructor with all fields
	public BloodPressureReading(int bloodPressureReadingId, Date readingDate, int systolic, int diastolic,
			int heartRate, User userHolder) {
		super();
		this.bloodPressureReadingId = bloodPressureReadingId;
		this.readingDate = readingDate;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.heartRate = heartRate;
		this.userHolder = userHolder;
	}

	/*
	 * All fields of this class are private
	 * we need to have Setters and Getters
	 * for each field
	 */
	public int getBloodPressureReadingId() {
		return bloodPressureReadingId;
	}

	public void setBloodPressureReadingId(int bloodPressureReadingId) {
		this.bloodPressureReadingId = bloodPressureReadingId;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public User getUserHolder() {
		return userHolder;
	}

	public void setUserHolder(User userHolder) {
		this.userHolder = userHolder;
	}
	
}