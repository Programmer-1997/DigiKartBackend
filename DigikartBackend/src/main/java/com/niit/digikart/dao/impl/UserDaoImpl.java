package com.niit.digikart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.digikart.dao.UserDao;
import com.niit.digikart.model.User;


@Repository(value="userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionfactory;
	
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	
	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
		
	}

	
	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.delete(u);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void update(User u) {
	/*	// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		User p=new User();
		p.setPid(101);
		p.setPname("vishnu");
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		session.close();*/
		
	}

	@Override
	public List<User> Userlist() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		List<User>Userlist=session.createQuery("from User").getResultList();
		return Userlist;
	}

	public User findbyUserId(String id) {

		Session session=sessionfactory.openSession();
		User p=null;
		try{
			session.beginTransaction();
		 p=session.createQuery("from User where email=:email", User.class).setParameter("email", id).uniqueResult();
		session.getTransaction().commit();
			
			
		}catch(HibernateException ex){
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
	
	}
	
	
}
