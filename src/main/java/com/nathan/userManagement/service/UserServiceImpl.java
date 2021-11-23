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
	public boolean saveUser(User user) {
		
		String hash = AuthUtils.generatePasswordHash(user.getPassword());
		user.setPassword(hash);
		
		boolean saved = false;
		try {
			saved = userDaoImpl.saveUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean deleted = false;
		try {
			deleted = userDaoImpl.deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleted;
	}

	@Override
	public boolean updateUser(User user) {
		User userToUpdate = null;
		try {
			userToUpdate = userDaoImpl.getUserById(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (userToUpdate != null) {
			userToUpdate.setName(user.getName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setPassword(AuthUtils.generatePasswordHash(user.getPassword()));		
		}
		
		boolean updated = false;
		try {
			updated = userDaoImpl.updateUser(userToUpdate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

}
