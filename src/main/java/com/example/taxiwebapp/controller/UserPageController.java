package com.example.taxiwebapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.model.User;
import com.example.taxiwebapp.service.UserDTO;

@Controller
public class UserPageController {
	@Autowired
	UserDTO userDTO;
	
	@RequestMapping(value="/login/userpage", method = RequestMethod.GET)
    public String showUserLoginPage(ModelMap model,@SessionAttribute("loging") Login login){
        model.put("username", login.getUsername());
		return "/login/userpage";
    }	
	
	
	@RequestMapping(value="/login/userpage/profile", method = RequestMethod.GET)
    public String showUserProfilePage(@SessionAttribute("loging") Login login,ModelMap model){
		//model.put("username", login.getUsername());
		User user=userDTO.getUserById(login.getUsername());
		model.addAttribute(user);
        return "/login/userpage/profile";
    }	
	@RequestMapping(value="/login/userpage/ride", method = RequestMethod.GET)
    public String showUserRidePage(@SessionAttribute("loging") Login login,ModelMap model){
		model.put("username", login.getUsername());
		
        return "/login/userpage/ride";
    }
	
	@RequestMapping(value="/login/userpage/status", method = RequestMethod.GET)
    public String showUserStatusPage(ModelMap model,@SessionAttribute("loging") Login login){
		model.put("username", login.getUsername());
		List<BookRide> rides=userDTO.getRidesBookedByUser(login.getUsername());
		if(rides.isEmpty())
		{
			model.put("ride",null);
		}
		else
		{
		model.addAttribute("ride", rides.get(0));
		}
        return "/login/userpage/status";
    }
	@RequestMapping(value="/login/userpage/ride", method = RequestMethod.POST)
    public String bookRide(ModelMap model,@SessionAttribute("loging") Login login,@RequestParam String source, @RequestParam String destination, @RequestParam String pick_up_time){
		model.put("username", login.getUsername());
		BookRide ride=new BookRide();
		ride.setSource(source);
		ride.setDestination(destination);
		ride.setPick_up_time(pick_up_time);
		ride.setUser_username(login.getUsername());
		ride.setDriver_username(null);
		ride.setRate(0);
		ride.setStatus("booked");
		userDTO.bookRide(ride);
		model.put("message", "Booked Successfully! Waiting for Driver to get Assigned....");
        return "/login/userpage/status";
    }
	@RequestMapping(value="/login/userpage/status", method = RequestMethod.POST)
    public String confirmRide(ModelMap model,@SessionAttribute("loging") Login login,@RequestParam int booking_id){
		model.put("username", login.getUsername());
		List<BookRide> rides=userDTO.getRidesBookedByUser(login.getUsername());
		userDTO.confirmRide(booking_id);
		model.addAttribute("ride", rides.get(0));
		model.put("message", "Booking confirmed...please take a screenshot");
        return "/login/userpage/status";
    }
}
