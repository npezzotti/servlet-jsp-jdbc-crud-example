package com.nathan.socialMediaApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static final String jdbcUrl = "jdbc:postgresql://localhost:5432/app";
	private static final String jdbcUsername = "postgres";
	private static final String jdbcPassword = "password";

	public static Connection getConnection() throws SQLException {

		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
