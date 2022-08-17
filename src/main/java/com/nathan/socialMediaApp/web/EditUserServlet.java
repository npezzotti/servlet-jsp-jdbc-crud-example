package com.nathan.socialMediaApp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.User;
import com.nathan.socialMediaApp.service.UserServiceImpl;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet(urlPatterns = { "/user/edit" })
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session dbSession = HibernateUtil.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		User userToEdit = userServiceImpl.getUserById(id, dbSession);
		userToEdit.setPassword("");
		request.setAttribute("userToEdit", userToEdit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-form.jsp");
		dispatcher.forward(request, response);
		dbSession.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session dbSession = HibernateUtil.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User userToUpdate = new User();
		userToUpdate.setId(id);
		userToUpdate.setName(name);
		userToUpdate.setEmail(email);
		userToUpdate.setPassword(password);

		boolean updated = userServiceImpl.updateUser(userToUpdate, dbSession);

		if (updated) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userServiceImpl.getUserById(userToUpdate.getId(), dbSession));
			response.sendRedirect(request.getContextPath() + "/posts");
		} else {
//			TODO - add validation
			System.out.println("Something went wrong.");
		}
		dbSession.close();
	}

}
