package com.example.taxiwebapp.service;

import com.example.taxiwebapp.model.Driver;

import java.util.List;

import com.example.taxiwebapp.model.BookRide;

public interface DriverDTO {
	
	public boolean addDriver(Driver diver);

	public Driver getDriverById(String username);

	public List<BookRide> getRideDetailsBySource(String source);
	
	public BookRide getRideDetailsById(int booking_id);

	public void confirmRideByDriver(int booking_id, float rate, String driver_username);
}
