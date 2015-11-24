package com.cmpe239.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cmpe239.entities.BusinessEntity;
import com.cmpe239.entities.UserEntity;
import com.cmpe239.model.Business;
import com.cmpe239.util.HibernateUtil;

public class TestClass {
	
	public static void main(String args[])
	{
		BusinessEntity b = new BusinessEntity();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createSQLQuery(
				"select Name from businessdetails where BusinessID = :YelpBID")
				.setParameter("YelpBID", "7EvTeABfqSt0z75huEOqNA");
		
		String name = new String();
		 if(query.list() != null)
	       {
			List result = query.list();
			if(result !=null && result.size() > 0)
			{
	          name = (String) result.get(0);
			}
	       }
		
		System.out.println(name);
				
	}

}
