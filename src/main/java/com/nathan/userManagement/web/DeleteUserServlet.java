package com.nathan.userManagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.userManagement.dao.UserDAO;


@WebServlet(urlPatterns = { "/delete" })
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;


    public DeleteUserServlet() {
        super();
        this.userDAO = new UserDAO();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			deleteUser(request, response);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("/servlet-jsp-jdbc-crud-example");
	}

}
