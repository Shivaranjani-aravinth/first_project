package com.example.taxiwebapp.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.taxiwebapp.model.Login;

@Repository
public class LoginDAOImpl implements LoginDAO{
	 @Autowired
     private SessionFactory sessionFactory;

	 //@SuppressWarnings("unchecked")
	@Override
	public boolean validateUser(Login log) {
		boolean flag=false;
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Login> criteria = builder.createQuery(Login.class);
		criteria.from(Login.class);
		List<Login> uc = session.createQuery(criteria).getResultList();
		
        for(int i=0;i<uc.size();i++)
        {
        	if(uc.get(i).getUsername().equals(log.getUsername())&&uc.get(i).getPassword().equals(log.getPassword())&&uc.get(i).getUsertype().equals(log.getUsertype()))
        	{
        		flag=true;
        	}
        			//" Password"+uc.get(i).getPassword());
        }
	 return flag;
	}
	

}
