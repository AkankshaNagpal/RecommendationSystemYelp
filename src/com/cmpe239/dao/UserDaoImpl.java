package com.cmpe239.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.Business;
import com.cmpe239.model.User;
import com.cmpe239.util.HibernateUtil;


public class UserDaoImpl implements UserDao {
	
	private static final String filePath = 
			"/Users/akankshanagpal/Downloads/try.json";
	
	static final String businessPath = "/Users/akankshanagpal/Downloads/business.json";
	static final String checkInPath = "/Users/akankshanagpal/Downloads/checkin.json";
	private static final String CREDENTIALS_DIRECTORY = ".oauth-credentials";

  
	@Override
	public void insert() throws Exception {
		
		FileReader reader = new FileReader(filePath);
		JSONParser  jsonParser = new JSONParser();
		JSONArray level1Obj = (JSONArray) jsonParser.parse(reader);
		
		
		ArrayList<UserEntity> users = new ArrayList();
		int count = 0;
		System.out.println(count);
		UserDaoImpl userDao = new UserDaoImpl();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		for(int i=0; i<level1Obj.size();i++)
		{
			JSONObject obj = (JSONObject) level1Obj.get(i);
			String yelpID = (String) obj.get("user_id");
			String name = (String) obj.get("name");
			String emailID = name + "123" + "@gmail.com";
			long fans = (long) obj.get("fans");
			String yelpingSince = (String) obj.get("yelping_since");
			String type = (String) obj.get("type");
			count = count + 1;
			
			UserEntity userEn = new UserEntity();
			//Get UserID from users table
			Integer serialNumber = userDao.getUserID(yelpID,session);
			
		
			userEn.setUserID(serialNumber);
			
			if(serialNumber != 0)
			{
			userEn.setPassword("123456");
			userEn.setUseremail(emailID.toLowerCase());
			userEn.setYelpID(yelpID);
			userEn.setFans(String.valueOf(fans));
			userEn.setYelpingSince(yelpingSince);
			userEn.setUsertype(type);
			
			users.add(userEn);
			}
			
		}
		
		for(UserEntity ue : users)
        {
		session.beginTransaction();
		session.save(ue);
		session.getTransaction().commit();
		}
		
		session.close();
	}
	
	@Override
	public User findByCustomerId(int userID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getUserID(String YelpUID,Session session)
	{
		Query query = session.createSQLQuery(
				"select UserID from user where YelpUserID = :YelpUsID")
				.setParameter("YelpUsID", YelpUID);
		int id = 0;
		       if(query.list() != null)
		       {
				List result = query.list();
				if(result !=null && result.size() > 0)
				{
		          id = (int) result.get(0);
				}
		       }
		
		        return id;		
	}

	@Override
	public UserEntity validateUser(String userEmail) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery(
				"select * from USER_INFORMATION where useremail = :emailID")
				.addEntity(UserEntity.class).setParameter("emailID", userEmail);
			
				List result = query.list();
		        UserEntity user = (UserEntity) result.get(0);
		        System.out.println(user.getPassword());
		        System.out.println(user.getYelpingSince());
		
		        return user;
			
	}
	
	public int getLastUserID()
	{
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createSQLQuery(
				"select MAX(userID) from USER_INFORMATION");
		
		List result = query.list();
		int userid = (int) result.get(0);
		System.out.println(userid);
		
		return userid;
	}

	@Override
	public UserEntity insertNewUser(UserEntity user) {
		// TODO Auto-generated method stub
		
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		UserDaoImpl userDao = new UserDaoImpl();
		int userid = userDao.getLastUserID() + 1;
		user.setUserID(userid);
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		return user;
		
	}

	@Override
	public List<RecommendedItem> recommendedBusiness(int userID) throws Exception {
		
      DataModel model = new FileDataModel(new File("/Users/akankshanagpal/Downloads/review.csv"));
    	
    	UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
    	
    	UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
    	
    	UserBasedRecommender recommender 
    	                   = new GenericUserBasedRecommender(model, neighborhood, similarity);
    	
    	
    
    	List<RecommendedItem> recommendations = recommender.recommend(userID,5);
    	for (RecommendedItem recommendation : recommendations) {
    	 System.out.println(recommendation);
    	}
    	
		return recommendations;
	
	}
	
	//get the list of businesses for a particular location and category
		//get the top 5 business having maximum rating --> output hashmap
		//compare for similar keys in both the hashmaps.
			
		public List<String> getBusinessList(String location, String category) throws IOException, ParseException{
			List<String> topRatedBusinessList = new ArrayList<String>();
			List<String> topCheckInBusinessList = new ArrayList<String>();
			//Collection<String> similar = null;
			List<String> resultList = new ArrayList<String>();
			HashMap<String, Double> topRatedBusinessMap = new HashMap<String, Double>();
			HashMap<String, Integer> topCheckInBusinessMap = new HashMap<String, Integer>();
			String businessId;
			double stars;
			System.out.println("Location "+ location + "Category "+category);
			try{
			File f = new File(System.getProperty("user.home") + "/" + CREDENTIALS_DIRECTORY);
			if (!f.getParentFile().exists())
			    f.getParentFile().mkdirs();
			if (!f.exists())
			    f.createNewFile();
			
			FileReader reader = new FileReader(businessPath);
			JSONParser  jsonParser = new JSONParser();
			JSONArray businessObj = (JSONArray) jsonParser.parse(reader);
			//System.out.println("Business Object : "+businessObj);
			
			
			
			FileReader checkInReader = new FileReader(checkInPath);
			JSONParser  checkinParser = new JSONParser();
			JSONArray checkInObj = (JSONArray) checkinParser.parse(checkInReader);
			
			//for Rating
			for( int i= 0; i<businessObj.size();i++){
				JSONObject obj = (JSONObject) businessObj.get(i);
				
				String city = (String) obj.get("city");
				ArrayList<String> categoryList = new ArrayList<String>();
				categoryList = (ArrayList<String>) obj.get("categories");
				
				System.out.println("City : "+city);
				System.out.println("Category List : "+categoryList);
				if(city.equals(location) && categoryList.contains(category)){
					businessId = (String) obj.get("business_id");
					stars = (Double) obj.get("stars");
					topRatedBusinessMap.put(businessId, stars);
					System.out.println("BusinessId : "+businessId);
					//list.add(businessId);
				}	
			}
			double max = Collections.max(topRatedBusinessMap.values());
			System.out.println( "Max Rated value : "+max);
			for(java.util.Map.Entry<String, Double> mpEntry : topRatedBusinessMap.entrySet())
			{
				if (mpEntry.getValue() == max)
				{
					topRatedBusinessList.add(mpEntry.getKey());
				}
			}
			System.out.println("Business List with max rating :"+topRatedBusinessList);
			System.out.println("The size of the list is " +topRatedBusinessList.size());
			
			//For CheckIn
			for( int i= 0; i<checkInObj.size();i++){
				JSONObject obj = (JSONObject) checkInObj.get(i);
				String bid = (String) obj.get("business_id");
				JSONObject checkin = (JSONObject) obj.get("checkin_info");
				int count = checkin.size();
				topCheckInBusinessMap.put(bid, count);
			}
			int maxCheckIn = Collections.max(topCheckInBusinessMap.values());
			for(java.util.Map.Entry<String, Integer> mpEntry : topCheckInBusinessMap.entrySet())
			{
				System.out.println("bid :"+mpEntry.getKey());
				System.out.println("checkin info :"+mpEntry.getValue());
				if (mpEntry.getValue() > 100)
				{
					
					topCheckInBusinessList.add(mpEntry.getKey());
				}
			}
			System.out.println("  max checkin : "+maxCheckIn);
			System.out.println(" Top Business for with max checkin : "+topCheckInBusinessList);
			System.out.println("The size of the list is " +topCheckInBusinessList.size());
			
			
			// compare the two Lists and add the common business id's into the resultList
			for(String temp :topRatedBusinessList){
				System.out.println("Comparing two lists for the string:"+temp);
				
				if(topCheckInBusinessList.contains(temp)){
					System.out.println("The similar strings : "+temp);
					resultList.add(temp);
				}
				
			}
			if(resultList.size() == 0){
				for(String temp : topRatedBusinessList){
					resultList.add(temp);
					if(resultList.size() == 5){
						break;
					}
				}
			}
	  
			
			
			}catch(Exception e){
				System.out.println("Exception : "+e);
			}
			//System.out.println(" Top Business for with max checkin : "+similar);
			return resultList;
			
			
		}



}
