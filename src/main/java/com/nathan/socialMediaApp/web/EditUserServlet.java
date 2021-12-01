package com.nathan.socialMediaApp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathan.socialMediaApp.model.User;
import com.nathan.socialMediaApp.service.UserServiceImpl;


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
		
		User userToUpdate = new User();
		userToUpdate.setId(id);
		userToUpdate.setName(name);
		userToUpdate.setEmail(email);
		userToUpdate.setPassword(password);

		boolean updated = userServiceImpl.updateUser(userToUpdate);
		
		if (updated) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userServiceImpl.getUserById(userToUpdate.getId()));
			response.sendRedirect(request.getContextPath());
		} else {
//			TODO - add validation
			System.out.println("Something went wrong.");
		}
	}

}
