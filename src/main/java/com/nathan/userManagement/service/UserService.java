package com.nathan.userManagement.service;

import java.sql.SQLException;
import java.util.List;

import com.nathan.userManagement.beans.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByEmail(String email) throws SQLException;
	public void insertUser(String name, String email, String password);
	public boolean deleteUser(int id);
	public boolean updateUser(int id, String name, String email, String password);
	
}
