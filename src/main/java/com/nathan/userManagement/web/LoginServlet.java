package com.nathan.userManagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathan.userManagement.dao.UserDAO;
import com.nathan.userManagement.model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    public LoginServlet() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        
        System.out.println(email);
        System.out.println(password);
       
        String error = null;
        
        if (request.getAttribute("user") == null) {
        	try {
        		User user = userDAO.getUserByEmail(email);
        		if (user == null) {
        			error = "User Name or password invalid";
        		}
        	} catch (SQLException e) {
        		e.printStackTrace();
        		error = e.getMessage();
        	}
        }
        
        if (error != null) {
        	request.setAttribute("error", error);
        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        	dispatcher.forward(request, response);
        } else {
        	response.sendRedirect("/servlet-jsp-jdbc-crud-example");
        }
	}

}
