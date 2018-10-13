
package com.niit.digikart.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.digikart.config.SpringConfig;
import com.niit.digikart.dao.UserDao;
import com.niit.digikart.model.User;

public class TestDao {
	public static void main(String[] args) {

		ApplicationContext c = new AnnotationConfigApplicationContext(SpringConfig.class);

		UserDao udao = (UserDao) c.getBean("userDao");

		User u = new User();
		u.setUsername("Surya");
		u.setPassword("surya");
		u.setDateOf("december");
		u.setEmail("surya@gmail.com");
		u.setRole("ROLE_ADMIN");
		u.setAddress("bangalore");
		udao.save(u);

	}
}
