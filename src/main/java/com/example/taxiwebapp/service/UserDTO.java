package com.example.taxiwebapp.service;

import java.util.List;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.User;

public interface UserDTO {
	
	public boolean addUser(User user);
	public User getUserById(String username);
	public void bookRide(BookRide ride);
	public List<BookRide> getRidesBookedByUser(String user_username);
	public void confirmRide(int booking_id);
}
