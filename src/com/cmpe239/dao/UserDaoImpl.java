package com.cmpe239.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.User;
import com.cmpe239.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
  
	@Override
	public void insert() {
		
		UserEntity userEn = new UserEntity();
		userEn.setUserID(1);
		userEn.setUsername("Akanksha");
		userEn.setUseremail("akanksha.nagpal@sjsu.edu");	
		//SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userEn);

		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public User findByCustomerId(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
