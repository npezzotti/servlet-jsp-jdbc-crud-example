package com.nathan.socialMediaApp.service;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.User;

public interface UserService {

	public User getUserById(int id, Session session);

	public User getUserByEmail(String email, Session session);

	public boolean createUser(User user, Session session);

	public boolean deleteUser(User user, Session session);

	public boolean updateUser(User user, Session session);

}
