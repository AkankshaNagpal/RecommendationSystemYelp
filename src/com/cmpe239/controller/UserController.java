package com.cmpe239.controller;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import business_recommender.Recommender;

import com.cmpe239.dao.UserDaoImpl;
import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.*;
import com.fasterxml.jackson.core.JsonParser;


@Controller
public class UserController {
 
	@RequestMapping("*")
	public ModelAndView index()
	{
		ModelAndView model = new ModelAndView("index");
		
		return model;
		
	}
	
	@RequestMapping("/businessDashboard")
	public ModelAndView businessDashboard()
	{
		ModelAndView model = new ModelAndView("PridictionResuil");
		
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
	@RequestMapping("/UserDashboard")
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
	
	
	@RequestMapping(value="/siginUP",method = RequestMethod.POST )
	public @ResponseBody UserLoginSucess  signUP(@RequestBody final UserLogin ul){
		System.out.println("called Login "+ul.getUserName()+" "+ul.getUserType()+" pass-"+ul.getPassword());
		UserLoginSucess uls=new UserLoginSucess();
		UserDaoImpl userDao = new UserDaoImpl();
		UserEntity newUser = new UserEntity();
		newUser.setUseremail(ul.getUserName());
		newUser.setPassword(ul.getPassword());
		newUser.setUsertype(ul.getUserType());
		newUser.setYelpingSince("2015");
		newUser.setFans("0");
		UserEntity userEn = userDao.insertNewUser(newUser);
		
		if(userEn != null)
		{
		uls.setMessage("success");
		uls.setUserID(ul.getUserName());
		uls.setUserType(ul.getUserType());
		}
		else
		{
		uls.setMessage("error");
		}
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
	@RequestMapping("/userProfile/{userName:.*}")
	public ModelAndView getUserProfileJSON(@PathVariable("userName") String name)
	{
		System.out.println("nme "+name);
		
		ModelAndView model = new ModelAndView("jsonTemplate");
		UserDaoImpl userDao = new UserDaoImpl();
		UserEntity userProfile = userDao.validateUser(name);
		model.addObject("userProfile",userProfile);
		
		return model;
	}
	
	
	/*@RequestMapping("/SignupSuccess")
	public String getUserJSON(Model model)
	{
		UserDaoImpl userDao = new UserDaoImpl();
		UserEntity userEn = userDao.insertNewUser();
		
		if(userEn != null)
		{
		model.addAttribute("newuserProfile",userEn);
		}
		else
		{
		model.addAttribute("errorMessage", "Please enter valid username and password");
		}
		
		return "jsonTemplate";
	}*/
	
	

	@RequestMapping(value="/businessRecommendationResult",method = RequestMethod.POST )
	public @ResponseBody JSONObject  posttest(@RequestBody final BusinessForm ul){
		System.out.println("called Login "+ul.getBusinessName()+" "+ul.getBusinessType()+" "+ul.getZipcode() + " "+ul.getServices().get(0));
		
		String businessname = ul.getBusinessName();
		String businesstype=ul.getBusinessType();
		String zipcode = ul.getZipcode();
		List<String> services = ul.getServices();
		List<String> zipcodes = new ArrayList<String>();
		
		try{

			StringBuilder result = new StringBuilder();
		    URL url = new URL("https://www.zipcodeapi.com/rest/LapKZOoH0rcwVyfgQqrp0qvSBrlBbueXFEHEt6mtxz0t8fJYFboGBTydlUPxp3u4/radius.json/"+zipcode+"/5/mile");
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("GET");
		    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    
		    String line;
		    while ((line = rd.readLine()) != null) {
		       result.append(line);
		    }
		    String result2 = result.substring(13, result.length()-1);
		    
		    JSONParser obj = new JSONParser();
		    JSONArray array = (JSONArray)obj.parse(result2); 

		    for(int i=0; i<array.size(); i++){
		        JSONObject jsonObj  = (JSONObject)array.get(i);
		        System.out.println(jsonObj.get("zip_code"));
		        zipcodes.add(jsonObj.get("zip_code").toString());
		    }
		    
		    rd.close();
		} catch(Exception e) {
			System.out.println();
		}
		
		Recommender rc = new Recommender();
		JSONObject prediction = rc.find_success("Restaurant", services, zipcode);
		Double success_rate = (Double)prediction.get("PredictedSuccessRate");
		Map<String, Double> other_success_rate = new TreeMap<String, Double>();
		
		for(int i = 0; i < zipcodes.size(); i++) {
			
			Recommender rc2 = new Recommender();
			JSONObject temp = rc2.find_success("Restaurant", services, zipcodes.get(i));
			Double temp_result = (Double)temp.get("PredictedSuccessRate");
			if(temp_result > success_rate) {
				
				other_success_rate.put(zipcodes.get(i), temp_result);
			}
		}
		
		System.out.println("Suggestions : " + other_success_rate);
		prediction.put("SuggestedZipcodes", other_success_rate);
		return prediction;
		
	}
	
}
