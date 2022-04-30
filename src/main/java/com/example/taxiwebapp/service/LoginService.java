package com.example.taxiwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.repository.LoginDAO;

@Service
public class LoginService implements LoginDTO {
    @Autowired(required=true)
    private LoginDAO loginDAO;
    public boolean validateUser(Login log) {
       
    	//System.out.println("\n\nUserrrrrrrrrrrTypeeeeeeeeeeeee"+userType);
        return loginDAO.validateUser(log);
    }

}
