package com.nathan.socialMediaApp.dao;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.User;

public interface UserDao {

	public boolean createUser(User user, Session session);

	public User getUserById(int id, Session session);

	public User getUserByEmail(String emailAddress, Session session);

	public boolean deleteUser(User user, Session session);

	public boolean updateUser(User user, Session session);
}
