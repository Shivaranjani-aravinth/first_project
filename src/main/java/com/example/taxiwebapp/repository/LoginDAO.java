package com.example.taxiwebapp.repository;

import com.example.taxiwebapp.model.Login;

public interface LoginDAO {
	public boolean validateUser(Login log);

}
