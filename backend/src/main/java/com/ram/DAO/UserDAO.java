package com.ram.DAO;

import java.util.List;

import com.ram.model.User;

public interface UserDAO {
	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public List<User>ListUsers();
	public User getUser(int UserId);
	
}
