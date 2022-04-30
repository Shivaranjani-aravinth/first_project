package com.example.taxiwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.Driver;
import com.example.taxiwebapp.repository.DriverDAO;


@Service
public class DriverService implements DriverDTO {
	
	@Autowired
	DriverDAO driverDAO;

	@Override
	public boolean addDriver(Driver driver) {
		// TODO Auto-generated method stub
		return driverDAO.addDriver(driver);
	}

	@Override
	public Driver getDriverById(String username) {
		// TODO Auto-generated method stub
		return driverDAO.getDriverById(username);
	}

	@Override
	public List<BookRide> getRideDetailsBySource(String source) {
		// TODO Auto-generated method stub
		return driverDAO.getRideDetailsBySource(source);
	}
	
	@Override
	public BookRide getRideDetailsById(int booking_id) {
		// TODO Auto-generated method stub
		return driverDAO.getRideDetailsById(booking_id);
	}

	@Override
	public void confirmRideByDriver(int booking_id, float rate, String driver_username) {
		// TODO Auto-generated method stub
		driverDAO.confirmRideByDriver(booking_id,rate,driver_username);
	}

}
