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
import com.example.taxiwebapp.service.LoginDTO;
import com.example.taxiwebapp.service.UserDTO;

@Controller
//@SessionAttributes("user")
public class UserRegisterationController {
	
	@Autowired
    UserDTO userDTO;
	 @RequestMapping(value="/userregister", method = RequestMethod.GET)
	    public String showUserRegisterPage(ModelMap model){
	        return "userregister";
	    }
	 @ModelAttribute("user")
	    public User setUpUserForm() {
	       return new User();
	    }
	 
	 @RequestMapping(value="/userregister", method = RequestMethod.POST)
	    public String registerUser(@ModelAttribute("user")User user,ModelMap model ){
	       
		  boolean regSuccess=false;
	    	//User user=new User(first_name,last_name,username,password,mailid,phone);
	        regSuccess=userDTO.addUser(user);
	        if(regSuccess==true)
	        	return "regsuccess";
	        if(regSuccess==false)
	        {
	        	 model.put("errorMessage", "User Name Already Exists ");
	             return "userregister";
	        }
	       
	        return "regsuccess";
	   
	    }
	 
     
}
