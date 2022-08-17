package com.nathan.socialMediaApp.service;

import org.hibernate.Session;

import com.nathan.socialMediaApp.dao.UserDaoImpl;
import com.nathan.socialMediaApp.model.User;
import com.nathan.socialMediaApp.util.AuthUtils;

public class UserServiceImpl implements UserService {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	@Override
	public User getUserById(int id, Session session) {
		User user = null;
		user = userDaoImpl.getUserById(id, session);
		return user;
	}

	@Override
	public User getUserByEmail(String email, Session session) {
		User user = userDaoImpl.getUserByEmail(email, session);
		return user;
	}

	@Override
	public boolean createUser(User user, Session session) {
		boolean created = userDaoImpl.createUser(user, session);
		return created;
	}

	@Override
	public boolean deleteUser(User user, Session session) {
		boolean deleted = userDaoImpl.deleteUser(user, session);
		return deleted;
	}

	@Override
	public boolean updateUser(User user, Session session) {
		User userToUpdate = null;
		userToUpdate = userDaoImpl.getUserById(user.getId(), session);

		if (userToUpdate != null) {
			userToUpdate.setName(user.getName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setPassword(AuthUtils.generatePasswordHash(user.getPassword()));
		}

		boolean updated = userDaoImpl.updateUser(userToUpdate, session);
		return updated;
	}

}
