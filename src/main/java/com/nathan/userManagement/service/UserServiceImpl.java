package com.nathan.userManagement.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nathan.userManagement.beans.User;
import com.nathan.userManagement.dao.UserDaoImpl;
import com.nathan.userManagement.util.AuthUtils;

public class UserServiceImpl implements UserService {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			users = userDaoImpl.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		try {
			user = userDaoImpl.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;

		try {
			user = userDaoImpl.getUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void insertUser(String name, String email, String password) {
		
		String hash = AuthUtils.generatePasswordHash(password);
		
		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPassword(hash);
		
		try {
			userDaoImpl.insertUser(newUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public boolean deleteUser(int id) {
		boolean deleted = false;
		try {
			deleted = userDaoImpl.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleted;
	}

	@Override
	public boolean updateUser(int id, String name, String email, String password) {
		String hash = AuthUtils.generatePasswordHash(password);
		User updatedUser = new User();
		updatedUser.setId(id);
		updatedUser.setName(name);
		updatedUser.setEmail(email);
		updatedUser.setPassword(hash);
		boolean updated = false;
		try {
			updated = userDaoImpl.updateUser(updatedUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

}
