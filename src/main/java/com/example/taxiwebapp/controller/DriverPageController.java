package com.example.taxiwebapp.controller;
import com.example.taxiwebapp.model.BookRide;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.taxiwebapp.model.Driver;
import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.service.DriverDTO;

@Controller
public class DriverPageController {
	@Autowired
	DriverDTO driverDTO;
	
	@RequestMapping(value="/login/driverpage", method = RequestMethod.GET)
    public String showDriverLoginPage(ModelMap model,@SessionAttribute("loging") Login login){
        model.put("username", login.getUsername());
		return "/login/driverpage";
    }	
	
	
	@RequestMapping(value="/login/driverpage/driverprofile", method = RequestMethod.GET)
    public String showDriverProfilePage(@SessionAttribute("loging") Login login,ModelMap model){
		Driver driver=driverDTO.getDriverById(login.getUsername());
		model.addAttribute(driver);
        return "/login/driverpage/driverprofile";
    }	
	@RequestMapping(value="/login/driverpage/driverride", method = RequestMethod.GET)
    public String showDriverRidePage(@SessionAttribute("loging") Login login,ModelMap model){
		model.put("username", login.getUsername());
		
        return "/login/driverpage/driverride";
    }
	
	@RequestMapping(value="/login/driverpage/driverride", method = RequestMethod.POST)
    public String getRideDetailsBySource(@SessionAttribute("loging") Login login,ModelMap model,@RequestParam String source){
		model.put("username", login.getUsername());
		List<BookRide> rides_by_source=driverDTO.getRideDetailsBySource(source);
		//Code to check whether the source lists are retrieved properly
		/* for(int i=0;i<rides_by_source.size();i++)
	        {   System.out.println("Booking ID: "+rides_by_source.get(i).getBooking_id());
	        	System.out.println("Source: "+rides_by_source.get(i).getSource());
	        	System.out.println("Destination: "+rides_by_source.get(i).getDestination());
	        	System.out.println("Username: "+rides_by_source.get(i).getUser_username());
	        	System.out.println("Source: "+rides_by_source.get(i).getPick_up_time());
	        	
	        }*/
		if(rides_by_source.isEmpty())
		{  String str="No rides Booked at "+source;
			model.put("message", str);
		}
		model.addAttribute("source_ride",rides_by_source);
		//BookRide br=rides_by_source.get(0);
		//model.addAttribute(br);
		
        return "/login/driverpage/driverride";
    
	}
	@RequestMapping(value="/login/driverpage/confirmride", method = RequestMethod.GET)
    public String showConfirmRidePage(ModelMap model, @RequestParam int booking_id){
        model.put("booking_id", booking_id);
        BookRide ride=driverDTO.getRideDetailsById(booking_id);
        model.addAttribute("ride_details", ride);
		return "/login/driverpage/confirmride";
    }
	@RequestMapping(value="/login/driverpage/confirmride", method = RequestMethod.POST)
    public String confirmRideByDriver(@SessionAttribute("loging") Login login,ModelMap model, @RequestParam int booking_id, @RequestParam float rate){
        
        driverDTO.confirmRideByDriver(booking_id,rate,login.getUsername());
		return "/login/driverpage";
    }

}
