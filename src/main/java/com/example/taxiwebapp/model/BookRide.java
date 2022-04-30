package com.example.taxiwebapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookride")
public class BookRide implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "booking_id")
    private int booking_id;
	
	
	@Column(name = "source")
    private String source;
	
	@Column(name = "destination")
    private String destination;
	
	@Column(name = "pick_up_time")
    private String pick_up_time;
	
	@Column(name = "user_username")
    private String user_username;
	
	@Column(name = "driver_username")
    private String driver_username;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "rate")
    private float rate; 
	
	//foreign key reference of user table in bookride table
	User user;
	
	//foreign key reference of driver table in bookride table
	Driver driver;
	
	public BookRide() {
		
	}
	
	public BookRide(int booking_id, String source, String destination, String pick_up_time, String user_username,
			String driver_username, String status, float rate) {
		super();
		this.booking_id = booking_id;
		this.source = source;
		this.destination = destination;
		this.pick_up_time = pick_up_time;
		this.user_username = user_username;
		this.driver_username = driver_username;
		this.status = status;
		this.rate = rate;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPick_up_time() {
		return pick_up_time;
	}

	public void setPick_up_time(String pick_up_time) {
		this.pick_up_time = pick_up_time;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getDriver_username() {
		return driver_username;
	}

	public void setDriver_username(String driver_username) {
		this.driver_username = driver_username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
}
