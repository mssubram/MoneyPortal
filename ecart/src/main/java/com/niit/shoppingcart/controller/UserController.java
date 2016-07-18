package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.UserDetails;


@Controller
@SessionAttributes("userID")
public class UserController {

   @Autowired
	UserDAO userDAO;
   
	@RequestMapping("/")
	public String getLanding() 
	{
	    //logger.info("Welcome home! The client locale is {}.");  
		System.out.println("Index page called....");
	    return "index";
	}
	
	@RequestMapping("/home")
	public String getHome()
	{
		return "home";
	}
	@RequestMapping("/index")
	public String getIndex()
	{
		return "index";
	}
	@RequestMapping("/contact")
	public String getContact()
	{
		return "contact";
	}
	@RequestMapping("/registration")
	public String getRegistration()
	{
		return "registration";
	}
	@RequestMapping("/products")
	public String getProducts()
	{
		return "products";
	}
	@RequestMapping("/services")
	public String getServices()
	{
		return "services";
	}
	@RequestMapping("/about")
	public String getAbout()
	{
		return "about";
	}
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "loginUser";
	}
    
    @RequestMapping("/isValidUser")
	public ModelAndView isValidUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {
		System.out.println("in controller");

		String message;
		ModelAndView mv ;
		if (userDAO.isValidUser(name, password,true)) 
		{
			message = "Valid credentials";
			 mv = new ModelAndView("adminHome");
		} else {
			message = "Invalid credentials";
			 mv = new ModelAndView("login");
		}

		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	
	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute UserDetails userDetails) {
		userDAO.saveOrUpdate(userDetails);
	  return new ModelAndView("/adminHome");
	 }


}
