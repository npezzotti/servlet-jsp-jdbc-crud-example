package com.nathan.socialMediaApp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.service.PostServiceImpl;

@WebServlet(urlPatterns = { "/post/edit" })
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostServiceImpl postServiceImpl = new PostServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Post post = postServiceImpl.getPostById(id);
		request.setAttribute("post", post);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/edit-post.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Post post = postServiceImpl.getPostById(id);
		String content = request.getParameter("content");
		post.setContent(content);
		boolean updated = postServiceImpl.updatePost(post);
		if (updated) {
			response.sendRedirect("/post/edit?id=" + id);
		}
	}

}
