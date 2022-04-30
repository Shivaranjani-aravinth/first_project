package com.example.taxiwebapp.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	@Autowired
    private SessionFactory sessionFactory;
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
		Session session=sessionFactory.getCurrentSession();
		session.close();
        return "logout";
    }
	       
	    }


