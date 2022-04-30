package com.example.taxiwebapp.repository;

import java.util.List;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.Driver;

public interface DriverDAO {
	public boolean addDriver(Driver driver);

	public Driver getDriverById(String username);
	public List<BookRide> getRideDetailsBySource(String source);
    public BookRide getRideDetailsById(int booking_id);
	public void confirmRideByDriver(int booking_id, float rate, String driver_username);
}
