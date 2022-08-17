package com.nathan.socialMediaApp.web;

import java.io.IOException;

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

@WebServlet(urlPatterns = { "/user/delete" })
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session dbSession = HibernateUtil.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		User userToDelete = userServiceImpl.getUserById(id, dbSession);
		boolean deleted = userServiceImpl.deleteUser(userToDelete, dbSession);
		if (deleted) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			response.sendRedirect(request.getContextPath() + "/login");
		} else {
//			TODO- validation
			response.sendRedirect(request.getContextPath());
		}
		dbSession.close();
	}

}
