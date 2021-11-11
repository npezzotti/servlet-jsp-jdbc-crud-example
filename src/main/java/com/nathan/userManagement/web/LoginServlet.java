package com.nathan.userManagement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathan.userManagement.beans.User;
import com.nathan.userManagement.dao.UserDAO;
import com.nathan.userManagement.util.AuthUtils;


@WebServlet(urlPatterns = { "/login" })
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        
        User user = null;
        
        try {
			user = userDAO.getUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user != null && AuthUtils.authenticate(user, password)) {
			
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            
			HttpSession newSession=request.getSession(true);
			newSession.setMaxInactiveInterval(10*60);
			newSession.setAttribute("user", user);
			response.sendRedirect(request.getContextPath());
		} else {
			String error = "Email or password invalid.";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
