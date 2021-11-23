package com.nathan.userManagement.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.userManagement.beans.User;
import com.nathan.userManagement.service.UserServiceImpl;


@WebServlet(urlPatterns = { "/edit" })
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User userToEdit = userServiceImpl.getUserById(id);
		userToEdit.setPassword("");
		request.setAttribute("userToEdit", userToEdit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User userToUpdate = new User(id, name, email, password);

		boolean updated = userServiceImpl.updateUser(userToUpdate);
		
		if (updated) {
			response.sendRedirect(request.getContextPath());
		} else {
//			TODO - add validation
			response.sendRedirect(request.getContextPath());
		}
	}

}
