package com.nathan.userManagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.userManagement.dao.UserDAO;
import com.nathan.userManagement.model.User;


@WebServlet(urlPatterns = { "/new" })
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public AddUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		showNewForm(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			insertUser(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(password);
		String country = request.getParameter("country");
		User newUser = new User(name, email, password, country);
		userDAO.insertUser(newUser);
		response.sendRedirect("/servlet-jsp-jdbc-crud-example");
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-form.jsp");
		dispatcher.forward(request, response);
	}

}
