package com.ram.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ram.DAO.UserDAO;
import com.ram.model.User;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void initialise()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.ram");
	context.refresh();
	userDAO=(UserDAO)context.getBean("userDAO");
	}

	
	@Test
	public void addCategory()
	{
      User user=new User();
      user.setUsername("ramhardik");
      user.setPassword("ramkumarramkumar");
      user.setMobileno("123456789");
      user.setEmail("ramhardik@gmail.com0");
      user.setCustomername("preevenkumar");
      assertTrue("problem in adding user",userDAO.addUser(user));
	}

	@Ignore
	@Test
	public void updateUser()
	{ 
		User user=userDAO.getUser(18) ;
		
		user.setEmail("ramkumar@gamil.com");
		user.setMobileno("23456765");
		user.setPassword("ramkuamr@11123");
		user.setUserid(122);
		user.setUsername("RAMKUMAR");
		user.setCustomername("customername");
	
		assertTrue("Problem in updating user",userDAO.updateUser(user));
		
	}
	@Ignore
	@Test
	public void deleteSupplier()
	{
		User user =userDAO.getUser(17
				);
		assertTrue("Problem in updating user",userDAO.deleteUser(user));
		}
	@Ignore
	@Test
	public void listUsersTest()
	{
		List<User>listUsers=userDAO.ListUsers();
		assertNotNull("problem in list user",userDAO.ListUsers());
		for(User user:listUsers) {
			System.out.println("User Id::"+user.getUserid());
			System.out.println("User name::"+user.getUsername());
			System.out.println("User Email::"+user.getEmail());
			
		}
		
		
	}

}
