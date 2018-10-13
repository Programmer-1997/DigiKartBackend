package com.niit.digikart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.digikart.dao.CategoryDao;
import com.niit.digikart.model.Category;
import com.niit.digikart.model.User;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
@Autowired
SessionFactory sessionFactory;



@Override
public void save(Category cat) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.save(cat);
	session.getTransaction().commit();
	session.close();
}

@Override
public void delete(int categoryid) {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.delete(getcategory(categoryid));
	session.getTransaction();
	session.close();
}

@Override
public void update(Category cat) {
	
	
}

@Override
public List<Category> Categorylist() {
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	List<Category> Categorylist=session.createQuery("from Category").getResultList();
	return Categorylist;
}

@Override
public Category getcategory(int categoryid) {
	Session session=sessionFactory.openSession();
	Category p=null;
	try {
	session.beginTransaction();
	 p=session.get(Category.class,categoryid);
	session.getTransaction().commit();
	session.close();
	}
	catch(HibernateException ex){
		ex.printStackTrace();
		session.getTransaction().rollback();
		
	}
	return p;
}

@Override
public List<Category> list(Integer offset, Integer maxResults) {
	sessionFactory.openSession().getTransaction().begin();
	return sessionFactory.openSession()
			.createCriteria(Category.class)
			.setFirstResult(offset!=null?offset:0)
			.setMaxResults(maxResults!=null?offset:10)
			.list();
}
	
}
