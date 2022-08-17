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

import com.nathan.socialMediaApp.model.Comment;
import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.model.User;
import com.nathan.socialMediaApp.service.CommentServiceImpl;
import com.nathan.socialMediaApp.service.PostServiceImpl;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet("/comment/create")
public class CreateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CommentServiceImpl commentServiceImpl = new CommentServiceImpl();
	private PostServiceImpl postServiceImpl = new PostServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session session = HibernateUtil.getSessionfactory().openSession();
		String content = request.getParameter("content");
		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("user");
		int postId = Integer.parseInt(request.getParameter("postId"));
		Post post = postServiceImpl.getPostById(postId, session);

		Comment comment = new Comment();
		comment.setUser(user);
		comment.setPost(post);
		comment.setContent(content);

		boolean created = commentServiceImpl.createComment(comment, session);

		if (created) {
			response.sendRedirect(request.getContextPath() + "/post?id=" + postId);
		} else {
			request.setAttribute("error", "Unable to create comment.");
			request.setAttribute("post", post);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/post.jsp");
			dispatcher.forward(request, response);
		}
	}

}
