package com.nathan.socialMediaApp.service;

import java.sql.SQLException;
import java.util.List;

import com.nathan.socialMediaApp.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(int id);
	public User getUserByEmail(String email) throws SQLException;
	public boolean createUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	
}
