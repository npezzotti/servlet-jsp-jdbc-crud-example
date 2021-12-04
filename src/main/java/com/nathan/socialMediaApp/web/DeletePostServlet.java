package com.nathan.socialMediaApp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.service.PostServiceImpl;

@WebServlet(urlPatterns = { "/post/delete" })
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostServiceImpl postServiceImpl = new PostServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Post post = postServiceImpl.getPostById(id);
		boolean deleted = postServiceImpl.deletePost(post);
		if (deleted) {
			response.sendRedirect(request.getContextPath() + "/posts");
		} else {
//			TODO set error
			response.sendRedirect(request.getContextPath() + "/posts");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
