package com.nathan.socialMediaApp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.service.PostServiceImpl;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet(urlPatterns = { "/posts" })
public class PostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PostServiceImpl postServiceImpl = new PostServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSession();
		List<Post> posts = postServiceImpl.getAllPosts(session);
		request.setAttribute("posts", posts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/posts.jsp");
		dispatcher.forward(request, response);
		session.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
