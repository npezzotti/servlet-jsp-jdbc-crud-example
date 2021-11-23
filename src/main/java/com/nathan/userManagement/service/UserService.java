package com.nathan.userManagement.service;

import java.sql.SQLException;
import java.util.List;

import com.nathan.userManagement.beans.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByEmail(String email) throws SQLException;
	public boolean saveUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	
}
