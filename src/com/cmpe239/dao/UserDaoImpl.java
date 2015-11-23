package com.cmpe239.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.User;
import com.cmpe239.util.HibernateUtil;


public class UserDaoImpl implements UserDao {
	
	private static final String filePath = 
			"/Users/akankshanagpal/Downloads/user.json";
  
	@Override
	public void insert() throws Exception {
		
		FileReader reader = new FileReader(filePath);
		JSONParser  jsonParser = new JSONParser();
		JSONArray level1Obj = (JSONArray) jsonParser.parse(reader);
		
		
		ArrayList<UserEntity> users = new ArrayList();
		int count = 0;
		System.out.println(count);
		
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
			userEn.setUserID(count);
			userEn.setPassword("123456");
			userEn.setUseremail(emailID.toLowerCase());
			userEn.setYelpID(yelpID);
			userEn.setFans(String.valueOf(fans));
			userEn.setYelpingSince(yelpingSince);
			userEn.setUsertype(type);
			
			users.add(userEn);
			
		}
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
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
	public UserEntity insertNewUser() {
		// TODO Auto-generated method stub
		UserEntity ue = new UserEntity();
		ue.setUseremail("akanksha.nagpal@sjsu.edu");
		ue.setPassword("123456");
		ue.setUsertype("user");
		
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		UserDaoImpl userDao = new UserDaoImpl();
		
		int userid = userDao.getLastUserID() + 1;
		ue.setUserID(userid);
		
		session.beginTransaction();
		session.save(ue);
		session.getTransaction().commit();
		session.close();
		
		return ue;
		
	}


}
