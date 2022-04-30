package com.example.taxiwebapp.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.model.User;
import com.example.taxiwebapp.service.LoginService;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
    private SessionFactory sessionFactory;
	

	@Override
	public boolean addUser(User user) {
		
		//CriteriaBuilder builder = session.getCriteriaBuilder();
		//CriteriaQuery<Login> criteria = builder.createQuery(Login.class);
		System.out.println("\n\n\n"+user.getFirst_name()+"\n"+user.getLast_name()+"\n"+user.getUsername()+"\n"+user.getPassword()+"\n"+user.getPhoneno()+"\n"+user.getMailid());
		
		boolean validate= validateUser(user);
		boolean success=false;
		if(validate==true)
			success=false;
		
		else if(validate==false)
		{   Login log=new Login(user.getUsername(), user.getPassword(),"user");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			//int id1=(Integer)session.save(log);
	        session.save(log);
				session.getTransaction().commit();
			session.close();
			success=true;
		}
		
		return success;
	}


	private boolean validateUser(User user) {
		boolean flag=false;
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Login> criteria = builder.createQuery(Login.class);
		criteria.from(Login.class);
		List<Login> uc = session.createQuery(criteria).getResultList();
		for(int i=0;i<uc.size();i++)
        {
        	if(uc.get(i).getUsername().equals(user.getUsername())&&uc.get(i).getUsertype().equals("user"))
        	{
        		flag=true;
        	}
        			//" Password"+uc.get(i).getPassword());
        }
		return flag;
	}


	@Override
	public User getUserById(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);	
		//System.out.println("\n\n\n\n USerNAME: "+user.getFirst_name()+"\n");
		return user;
	}


	@Override
	public void bookRide(BookRide ride) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ride);
		session.getTransaction().commit();
		}


	@Override
	public List<BookRide> getRidesBookedByUser(String user_username) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BookRide> criteria = builder.createQuery(BookRide.class);
		Root<BookRide> root=criteria.from(BookRide.class);
		criteria.select(root).where(root.get("user_username").in(user_username));
		//Query<BookRide> query = (BookRide)session.createQuery(criteria);
		List<BookRide> list_of_rides = (List<BookRide>)session.createQuery(criteria).getResultList();
		return list_of_rides;
	}


	@Override
	public void confirmRide(int booking_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		BookRide ride=session.get(BookRide.class, booking_id);
		ride.setStatus("confirmed");
		//ride.setDriver_username(driver_username);
		session.update(ride);
		session.getTransaction().commit();
		
	}


	

}
