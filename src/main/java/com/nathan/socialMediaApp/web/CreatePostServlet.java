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

import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.model.User;
import com.nathan.socialMediaApp.service.PostServiceImpl;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet(urlPatterns = { "/post/create" })
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostServiceImpl postServiceImpl = new PostServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session dbSession = HibernateUtil.getSession();

		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Post newPost = new Post();
		newPost.setUser(user);
		newPost.setContent(content);
		boolean created = postServiceImpl.createPost(newPost, dbSession);
		if (created) {
			response.sendRedirect(request.getContextPath() + "/posts");
		} else {
			request.setAttribute("error", "Unable to create post.");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/posts.jsp");
			dispatcher.forward(request, response);
		}
		dbSession.close();
	}

}
