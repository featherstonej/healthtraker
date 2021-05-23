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
@Table(name="glucosereadings")		
public class GlucoseReading {

	/*
	 * This is the unique identifier for this model.
	 * Hibernate uses the following annotations to create this 
	 * column as the primary key for the table and 
	 * auto generate a key for each new record.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="glucosereadingid", unique=true, nullable=false)
	private int glucoseReadingId;
	
	/* 
	 * This is the date the reading was taken the nullable 
	 * attribute is set to false so there has to be a date
	 */
	@Column(name="readingdate", nullable=false)
	private Date readingDate;
	
	// This is the glucose reading value
	@Column(name="glucosereading")
	private int glucoseReading;
	
	// Was the reading before a meal
	@Column(name="beforemeal")
	private boolean beforeMeal;
	
	// Was too much food consumed
	@Column(name="toomuchfood")
	private boolean tooMuchFood;
	
	// Did you not eat enough
	@Column(name="notenoughfood")
	private boolean notEnoughFood;
	
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
	public GlucoseReading() {
	}
	
	// Constructor with all fields except the id
	public GlucoseReading(Date readingDate, int glucoseReading, boolean beforeMeal, boolean tooMuchFood,
			boolean notEnoughFood, User userHolder) {
		super();
		this.readingDate = readingDate;
		this.glucoseReading = glucoseReading;
		this.beforeMeal = beforeMeal;
		this.tooMuchFood = tooMuchFood;
		this.notEnoughFood = notEnoughFood;
		this.userHolder = userHolder;
	}
	
	// Constructor with all fields
	public GlucoseReading(int glucoseReadingId, Date readingDate, int glucoseReading, boolean beforeMeal,
			boolean tooMuchFood, boolean notEnoughFood, User userHolder) {
		super();
		this.glucoseReadingId = glucoseReadingId;
		this.readingDate = readingDate;
		this.glucoseReading = glucoseReading;
		this.beforeMeal = beforeMeal;
		this.tooMuchFood = tooMuchFood;
		this.notEnoughFood = notEnoughFood;
		this.userHolder = userHolder;
	}

	/*
	 * All fields of this class are private
	 * we need to have Setters and Getters
	 * for each field
	 */
	public int getGlucoseReadingId() {
		return glucoseReadingId;
	}

	public void setGlucoseReadingId(int glucoseReadingId) {
		this.glucoseReadingId = glucoseReadingId;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public int getGlucoseReading() {
		return glucoseReading;
	}

	public void setGlucoseReading(int glucoseReading) {
		this.glucoseReading = glucoseReading;
	}

	public boolean isBeforeMeal() {
		return beforeMeal;
	}

	public void setBeforeMeal(boolean beforeMeal) {
		this.beforeMeal = beforeMeal;
	}

	public boolean isTooMuchFood() {
		return tooMuchFood;
	}

	public void setTooMuchFood(boolean tooMuchFood) {
		this.tooMuchFood = tooMuchFood;
	}

	public boolean isNotEnoughFood() {
		return notEnoughFood;
	}

	public void setNotEnoughFood(boolean notEnoughFood) {
		this.notEnoughFood = notEnoughFood;
	}

	public User getUserHolder() {
		return userHolder;
	}

	public void setUserHolder(User userHolder) {
		this.userHolder = userHolder;
	}

	/*
	 * All objects in java have a toString method that can be
	 * overwritten to return a custom string.
	 */
	@Override
	public String toString() {
		return "GlucoseReading [glucoseReadingId=" + glucoseReadingId + ", readingDate=" + readingDate
				+ ", glucoseReading=" + glucoseReading + ", beforeMeal=" + beforeMeal + ", tooMuchFood=" + tooMuchFood
				+ ", notEnoughFood=" + notEnoughFood + ", userHolder=" + userHolder + "]";
	}
}
	
		