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


@WebServlet(urlPatterns = { "/edit" })
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

    public EditUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showEditForm(request, response);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			updateUser(request, response);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.getUserById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		User updatedUser = new User(id, name, email, password, country);
		userDAO.updateUser(updatedUser);
		response.sendRedirect("/servlet-jsp-jdbc-crud-example");
	}

}
