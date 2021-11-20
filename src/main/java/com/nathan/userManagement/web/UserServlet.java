package com.nathan.userManagement.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.userManagement.beans.User;
import com.nathan.userManagement.service.UserServiceImpl;


@WebServlet(urlPatterns = { "/" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<User> users = userServiceImpl.getAllUsers();
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-list.jsp");
		dispatcher.forward(request, response);		
	}

}
