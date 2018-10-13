package com.niit.digikart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.niit.digikart.model.Cart;
import com.niit.digikart.model.Category;
import com.niit.digikart.model.Orders;
import com.niit.digikart.model.Product;
import com.niit.digikart.model.Supplier;
import com.niit.digikart.model.User;

@Configuration
@ComponentScan("com.niit")
public class SpringConfig {

	@Autowired
	@Bean(name = { "dataSource" })

	public DataSource getdataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/world?useSSL=true");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public SessionFactory getsessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getdataSource());
		Properties p = new Properties();
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		p.put("hibernate.hbm2ddl.auto", "update");
		builder.addProperties(p);
		builder.addAnnotatedClass(Category.class);
		builder.addAnnotatedClass(Supplier.class);
		builder.addAnnotatedClass(Product.class);
		builder.addAnnotatedClass(Cart.class);
		builder.addAnnotatedClasses(User.class);
		builder.addAnnotatedClass(Orders.class);
		return builder.buildSessionFactory();
	}
}
