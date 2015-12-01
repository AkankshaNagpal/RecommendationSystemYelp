package com.cmpe239.controller;


import java.io.*;
import java.net.*;
import java.util.Collection;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.cmpe239.dao.BusinessdaoImpl;
import com.cmpe239.dao.UserDaoImpl;
import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.Business;
import com.cmpe239.model.User;
import com.cmpe239.model.UserLogin;
import com.cmpe239.model.UserLoginSucess;

import business_recommender.Recommender;

import com.cmpe239.dao.UserDaoImpl;
import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.*;
import com.fasterxml.jackson.core.JsonParser;


@Controller
public class BusinessController {
 
	@RequestMapping(value="/showInfoGraphs",method = RequestMethod.GET )
	public @ResponseBody ModelAndView  showInfoGraphs(){
		
		ModelAndView model = new ModelAndView("info-graphs");		
		return model;
	}
	
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
		    URL url = new URL("https://www.zipcodeapi.com/rest/BurO3JJtkJq7fikHvdkk7T8EJvICXsNzWenZX7tiQUp6cKOIY9252bJMGroEUcdR/radius.json/"+zipcode+"/5/mile");
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
