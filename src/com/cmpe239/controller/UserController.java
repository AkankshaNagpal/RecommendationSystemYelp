package com.cmpe239.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cmpe239.dao.UserDaoImpl;


@Controller
public class UserController {
 
	@RequestMapping("/welcome/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name)
	{
		ModelAndView model = new ModelAndView("User");
		model.addObject("msg","Hello " + name);
		UserDaoImpl userDao = new UserDaoImpl();
		userDao.insert();
		return model;
		
	}
	
	@RequestMapping("/hi")
	public ModelAndView hiWorld()
	{
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","Hi World");
		return model;
		
	}
	
}
