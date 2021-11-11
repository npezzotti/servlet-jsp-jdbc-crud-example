package com.nathan.userManagement.util;

import org.mindrot.jbcrypt.BCrypt;

import com.nathan.userManagement.beans.User;

public class AuthUtils {
	
	private static int workload = 12;
	
	public static boolean authenticate(User user, String password) {
		String hash = user.getPassword();
		if (hash != null) return (BCrypt.checkpw(password, hash));
		return false;
	}
	
	public static String generatePasswordHash(String password) {
		String hash = BCrypt.hashpw(password, BCrypt.gensalt(workload));
		return hash;
	}

}
