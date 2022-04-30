package com.example.taxiwebapp.repository;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.taxiwebapp.model.BookRide;
import com.example.taxiwebapp.model.Driver;
import com.example.taxiwebapp.model.Login;
import com.example.taxiwebapp.model.User;
import com.example.taxiwebapp.service.LoginService;

@Repository
public class DriverDAOImpl implements DriverDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	
	
	@Override
	public boolean addDriver(Driver driver) {
		
		boolean validate= validateDriver(driver);
		boolean success=false;
		if(validate==true)
			success=false;
		
		else if(validate==false)
		{   Login log=new Login(driver.getUsername(), driver.getPassword(),"driver");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(driver);
			//int id1=(Integer)session.save(log);
	        session.save(log);
				session.getTransaction().commit();
			session.close();
			success=true;
		}
		
		return success;
	}

	private boolean validateDriver(Driver driver) {
		boolean flag=false;
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Login> criteria = builder.createQuery(Login.class);
		criteria.from(Login.class);
		List<Login> uc = session.createQuery(criteria).getResultList();
		for(int i=0;i<uc.size();i++)
        {
        	if(uc.get(i).getUsername().equals(driver.getUsername())&&uc.get(i).getUsertype().equals("driver"))
        	{
        		flag=true;
        	}
        			//" Password"+uc.get(i).getPassword());
        }
		return flag;
	}

	@Override
	public Driver getDriverById(String username) {
		Session session = sessionFactory.getCurrentSession();
		Driver driver=(Driver)session.get(Driver.class, username);
		return driver;
	}

	@Override
	public List<BookRide> getRideDetailsBySource(String source) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BookRide> criteria = builder.createQuery(BookRide.class);
		Root<BookRide> root=criteria.from(BookRide.class);
		criteria.select(root).where(root.get("source").in(source));
		//Query<BookRide> query = (BookRide)session.createQuery(criteria);
		List<BookRide> list_of_rides = (List<BookRide>)session.createQuery(criteria).getResultList();
		return list_of_rides;
	}
	
	@Override
	public BookRide getRideDetailsById(int booking_id) {
		Session session = sessionFactory.getCurrentSession();
		BookRide ride=(BookRide)session.get(BookRide.class, booking_id);	
		return ride;
	}

	@Override
	public void confirmRideByDriver(int booking_id, float rate, String driver_username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		BookRide ride=session.get(BookRide.class, booking_id);
		ride.setRate(rate);
		ride.setDriver_username(driver_username);
		session.update(ride);
		session.getTransaction().commit();
		
	}
}
