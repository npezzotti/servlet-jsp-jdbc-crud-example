package com.nathan.userManagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.userManagement.dao.UserDAO;
import com.nathan.userManagement.model.User;


@WebServlet(urlPatterns = { "/" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public UserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			getAllUsers(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getAllUsers(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		List<User> users = userDAO.getAllUsers();
		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-list.jsp");
		dispatcher.forward(request, response);
	}

}
