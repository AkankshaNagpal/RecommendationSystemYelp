package com.cmpe239.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cmpe239.model.Business;
import com.cmpe239.util.HibernateUtil;

public class BusinessdaoImpl implements BusinessDao {

	@Override
	public String getYelpID(int bussID) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createSQLQuery(
				"select YelpBusinessID from business where BussID = :YelpBID")
				.setParameter("YelpBID", bussID);
		String id = new String();
		       if(query.list() != null)
		       {
				List result = query.list();
				if(result !=null && result.size() > 0)
				{
		          id = (String) result.get(0);
				}
		       }
		
		return id;
	}

	@Override
	public String getBusinessName(String yelpID) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String name = new String();
		
		Query query = session.createSQLQuery(
				"select Name from businessdetails where BusinessID = :YelpBID")
				.setParameter("YelpBID", yelpID);
		
		 if(query.list() != null)
	       {
			List result = query.list();
			if(result !=null && result.size() > 0)
			{
	          name = (String) result.get(0);
			}
	       }
		
		return name;
	}

	@Override
	public String getBusinessLocation(String yelpID) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		String address = new String();
		
		Query query = session.createSQLQuery(
				"select Address from businessdetails where BusinessID = :YelpBID")
				.setParameter("YelpBID", yelpID);
		
		 if(query.list() != null)
	       {
			List result = query.list();
			if(result !=null && result.size() > 0)
			{
	          address = (String) result.get(0);
			}
	       }
		
		return address;
	}

	@Override
	public String getBusinessStars(String yelpID) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		double stars = 0 ;
		
		Query query = session.createSQLQuery(
				"select Stars from businessdetails where BusinessID = :YelpBID")
				.setParameter("YelpBID", yelpID);
		
		 if(query.list() != null)
	       {
			List result = query.list();
			if(result !=null && result.size() > 0)
			{
	          stars = (double) result.get(0);
			}
	       }
		
		return String.valueOf(stars);
	}
	

}
