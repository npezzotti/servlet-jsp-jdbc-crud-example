package com.nathan.socialMediaApp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.Comment;
import com.nathan.socialMediaApp.service.CommentServiceImpl;
import com.nathan.socialMediaApp.util.HibernateUtil;

@WebServlet("/comment/delete")
public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentServiceImpl commentServiceImpl = new CommentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session dbSession = HibernateUtil.getSession();
		int commentId = Integer.parseInt(request.getParameter("id"));
		Comment comment = commentServiceImpl.getCommentById(commentId, dbSession);
		boolean deleted = commentServiceImpl.deleteComment(comment, dbSession);
		if (deleted) {
			response.sendRedirect(request.getContextPath() + "/post?id=" + comment.getPost().getId());
		} else {
			request.setAttribute("error", "Unable to delete comment.");
			request.setAttribute("post", comment.getPost());
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/post.jsp");
			dispatcher.forward(request, response);
		}
		dbSession.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
