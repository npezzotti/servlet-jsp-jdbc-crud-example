package com.nathan.socialMediaApp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.service.PostServiceImpl;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet(urlPatterns = { "/post/delete" })
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostServiceImpl postServiceImpl = new PostServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Post post = postServiceImpl.getPostById(id, session);
		boolean deleted = postServiceImpl.deletePost(post, session);
		if (deleted) {
			response.sendRedirect(request.getContextPath() + "/posts");
		} else {
//			TODO set error
			response.sendRedirect(request.getContextPath() + "/posts");
		}
		session.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
