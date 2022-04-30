package com.example.taxiwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.taxiwebapp.model.Driver;
import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.model.User;
import com.example.taxiwebapp.service.DriverDTO;
import com.example.taxiwebapp.service.UserDTO;

@Controller
@SessionAttributes("driver")
public class DriverRegisterationController {
	
	@Autowired
    DriverDTO driverDTO;
	
	 @RequestMapping(value="/driverregister", method = RequestMethod.GET)
	    public String showUserRegisterPage(ModelMap model){
	        return "driverregister";
	    }
	 @ModelAttribute("driver")
	    public Driver setUpDriverForm() {
	       return new Driver();
	    }

	 @RequestMapping(value="/driverregister", method = RequestMethod.POST)
	    public String registerUser(@ModelAttribute("driver")Driver driver, ModelMap model ){
	       
		  boolean regSuccess=false;
	        regSuccess=driverDTO.addDriver(driver);
	        if(regSuccess==true)
	        	return "regsuccess";
	        if(regSuccess==false)
	        {
	        	 model.put("errorMessage", "User Name Already Exists ");
	             return "driverregister";
	        }
	       
	        return "regsuccess";
	   
	    }
	 
	 
	 

}
