package com.example.taxiwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.service.LoginDTO;
import com.example.taxiwebapp.service.LoginService;



@Controller
@SessionAttributes("loging")
public class LoginController {

    @Autowired
    LoginDTO loginDTO;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }
    @ModelAttribute("loging")
    public Login setUpLoginForm() {
       return new Login();
    }
 
    @RequestMapping(value="/login", method = RequestMethod.POST)
   // public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password,@RequestParam String usertype ){
    public String showWelcomePage(@ModelAttribute("loging")Login loggin, ModelMap model) {
    	
    	Login log=new Login(loggin.getUsername(),loggin.getPassword(),loggin.getUsertype());
        boolean isValidUser = loginDTO.validateUser(log);
        if (isValidUser==false) {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }

        model.put("username",loggin.getUsername());
        if(loggin.getUsertype().equals("user"))
        	return "/login/userpage";
        else if(loggin.getUsertype().equals("driver"))
            return "/login/driverpage";
        
        return "login";
    }

}
