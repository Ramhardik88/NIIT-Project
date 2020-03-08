package com.ram.DB;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ram.model.Category;
import com.ram.model.Product;
import com.ram.model.Supplier;
import com.ram.model.User;


@ComponentScan("com.ram")
@Configuration
@EnableTransactionManagement
public class DBConfig{

	@Bean(name="DataSource")
	public DataSource getmysqlDataSource()
	
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("Ramkumar@123");
		System.out.println("Data source");
		return datasource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionfactory() 
	{
		
		Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		hibernateproperties.setProperty("hibernate.hbm2ddl.auto","update");
		LocalSessionFactoryBuilder localSessionFactory= new LocalSessionFactoryBuilder(getmysqlDataSource());
		localSessionFactory.addProperties(hibernateproperties);
		localSessionFactory.addAnnotatedClass(Category.class);
		localSessionFactory.addAnnotatedClass(Product.class);
		localSessionFactory.addAnnotatedClass(Supplier.class);
		localSessionFactory.addAnnotatedClass(User.class);
		SessionFactory sessionFactory=localSessionFactory.buildSessionFactory();
		System.out.println("session Factory ");
		return sessionFactory;
	}
	@Bean(name="txtManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Factory ");
		return new HibernateTransactionManager(sessionFactory) ;
		
		
	}
}
