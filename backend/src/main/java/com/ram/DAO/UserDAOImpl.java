package com.ram.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ram.model.User;
@Repository("userDAO")
@Transactional

public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionfactory;

	public boolean addUser(User user) {
		try {
			
	
		sessionfactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e) {
			return false;
		}}

	public boolean deleteUser(User user) {
		try {
			sessionfactory.getCurrentSession().delete(user);
			return true;
			}
			catch(Exception e) {
				return false;
			}
		
	}

	public boolean updateUser(User user) {
		try {
			sessionfactory.getCurrentSession().update(user);
			return true;
			}
			catch(Exception e) {
				return false;
			}
		
	}

	public List<User> ListUsers() {

		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUsers=query.list();
		session.close();
		return listUsers;
}

	public User getUser(int UserId) {
		Session session=sessionfactory.openSession();
		User user=session.get(User.class,UserId);
		session.close();
			return user;
		
	}

}
