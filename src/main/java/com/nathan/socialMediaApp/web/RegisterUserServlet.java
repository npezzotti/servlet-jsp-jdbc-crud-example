package com.nathan.socialMediaApp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.User;
import com.nathan.socialMediaApp.service.UserServiceImpl;
import com.nathan.socialMediaApp.util.AuthUtils;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet(urlPatterns = { "/register" })
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSession();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (name == null || email == null || password == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
			request.setAttribute("error", "Invalid name, email, or password");
			dispatcher.forward(request, response);
		}

		User newUser = new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPassword(AuthUtils.generatePasswordHash(password));

		boolean created = userService.createUser(newUser, session);

		if (created) {
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
			request.setAttribute("error", "Unable to register user");
			dispatcher.forward(request, response);
		}

		session.close();
	}

}
