package com.nathan.userManagement.dao;

import java.sql.SQLException;
import java.util.List;

import com.nathan.userManagement.beans.User;

public interface UserDao {
	static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?);";
	static final String SELECT_USER_BY_ID = "SELECT id, name, email, password FROM users WHERE id = ?;";
	static final String SELECT_USER_BY_EMAIL = "SELECT id, name, email, password FROM users WHERE email = ?;";
	static final String SELECT_ALL_USERS = "SELECT * FROM users;";
	static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
	static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?;";
	
	public void insertUser(User user) throws SQLException;
	public User getUserById(int id) throws SQLException;
	public User getUserByEmail(String emailAddress) throws SQLException;
	public List<User> getAllUsers() throws SQLException;
	public boolean deleteUser(int id) throws SQLException;
	public boolean updateUser(User user) throws SQLException;
}
