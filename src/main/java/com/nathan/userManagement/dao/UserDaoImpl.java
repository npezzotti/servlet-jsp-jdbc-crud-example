package com.nathan.userManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nathan.userManagement.beans.User;
import com.nathan.userManagement.util.DBUtils;

public class UserDaoImpl implements UserDao {
	
	public void insertUser(User user) throws SQLException {
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserById(int id) throws SQLException {
		User user = null;
		
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				user = new User();
				
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUserByEmail(String emailAddress) throws SQLException {		
		User user = null;
		
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
			preparedStatement.setString(1, emailAddress);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return user;
	}
	
	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<>();
		
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				User user = new User();
				
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL)) {
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;

		try (Connection connection = DBUtils.getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getId());
						
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
