package com.cmpe239.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cmpe239.dao.UserDaoImpl;
import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.User;
import com.cmpe239.model.UserLogin;
import com.cmpe239.model.UserLoginSucess;


@Controller
public class UserController {
 
	@RequestMapping("*")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView("index");
		
		return model;
		
	}
	
	@RequestMapping("/welcome/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name)
	{
		ModelAndView model = new ModelAndView("User");
		model.addObject("msg","Hello " + name);
		UserDaoImpl userDao = new UserDaoImpl();
		try {
			userDao.insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		
	}
	
	@RequestMapping("/hi")
	public ModelAndView hiWorld()
	{
		ModelAndView model = new ModelAndView("User");
		model.addObject("msg","Hi World");
		return model;
		
	}
	@RequestMapping("/hii")
	public ModelAndView hiTest()
	{
		ModelAndView model = new ModelAndView("UserPridiction");
		model.addObject("msg","Hi World");
		return model;
		
	}
	
	
	@RequestMapping(value="/userlogin", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody UserLogin  gettest(HttpServletRequest req, HttpServletResponse res){
		System.out.println("called");
		UserLogin ul=new UserLogin();
		ul.setUserName("Deep");
		ul.setUserType("User");
		return ul;
	}
	@RequestMapping(value="/login",method = RequestMethod.POST )
	public @ResponseBody UserLoginSucess  posttest(@RequestBody final UserLogin ul){
		System.out.println("called Login "+ul.getUserName()+" "+ul.getUserType()+" pass-"+ul.getPassword());
		
		//UserLogin uls=new UserLogin();
		String Username = ul.getUserName();
		String Usertype=ul.getUserType();
		String password = ul.getPassword();
		
		UserDaoImpl userDao = new UserDaoImpl();
		UserEntity user = userDao.validateUser(Username);
		String pass = user.getPassword();
		
		UserLoginSucess uls=new UserLoginSucess();
		
		if(pass.equals(password))
		{
			   
				System.out.println("Regular user");
				uls.setMessage("success");
				uls.setUserID(ul.getUserName());
				uls.setUserType(ul.getUserType());
		}
		else
		{
			uls.setMessage("error");
			System.out.println("did not went");
		}
		
		
		/*UserLoginSucess uls=new UserLoginSucess();
		System.out.println("user type- "+Usertype);
		if(Usertype.equals("user")){
			System.out.println("Regular user");
			uls.setMessage("success");
			uls.setUserID(ul.getUserName());
			uls.setUserType(ul.getUserType());
		}else if(Usertype.equals("business")){
			System.out.println("Business");
			uls.setMessage("success");
			uls.setUserID(ul.getUserName());
			uls.setUserType(ul.getUserType());
		}
		else{
			uls.setMessage("error");
			System.out.println("did not went");
		}*/
		/*if(ul.getUserType()=="business"){
			uls.setUserID(ul.getUserName());
			uls.setMessage("business");
		}else if(ul.getUserType()=="user"){
			uls.setUserID(ul.getUserName());
			uls.setMessage("user");
		}else{
			uls.setMessage("error");
		}*/
		return uls;
	}
	
	@RequestMapping("/validateLogin")
	public ModelAndView validateLogin()
	{
		ModelAndView model = new ModelAndView("ValidateLogin");
		UserDaoImpl userDao = new UserDaoImpl();
		UserEntity user = userDao.validateUser("jeremy123@gmail.com");
		String password = user.getPassword();
		if(password.equals("123456"))
		{
		model.addObject("msg","Hello " + user.getUseremail());
		}
		else
		{
			model.addObject("msg","Invalid username and password");
		}
	
		return model;	
	}
	
	//Code to return userprofile
	@RequestMapping("/userProfile")
	public String getUserProfileJSON(Model model)
	{
		UserDaoImpl userDao = new UserDaoImpl();
		UserEntity userProfile = userDao.validateUser("jeremy123@gmail.com");
		model.addAttribute("userProfile",userProfile);
		
		return "jsonTemplate";
	}
	
	

	
}
