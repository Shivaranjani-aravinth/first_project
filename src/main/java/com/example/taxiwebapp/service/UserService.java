package com.example.taxiwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.User;
import com.example.taxiwebapp.repository.UserDAO;

@Service
public class UserService implements UserDTO{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.addUser(user);
	}

	@Override
	public User getUserById(String username) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(username);
	}

	@Override
	public void bookRide(BookRide ride) {
		// TODO Auto-generated method stub
		userDAO.bookRide(ride);
	}

	@Override
	public List<BookRide> getRidesBookedByUser(String user_username) {
		// TODO Auto-generated method stub
		return userDAO.getRidesBookedByUser(user_username);
	}

	@Override
	public void confirmRide(int booking_id) {
		// TODO Auto-generated method stub
		userDAO.confirmRide(booking_id);
	}

	

}
