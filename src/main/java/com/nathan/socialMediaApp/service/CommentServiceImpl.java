package com.nathan.socialMediaApp.service;

import org.hibernate.Session;

import com.nathan.socialMediaApp.dao.CommentDaoImpl;
import com.nathan.socialMediaApp.model.Comment;

public class CommentServiceImpl implements CommentService {

	private CommentDaoImpl commentDaoImpl = new CommentDaoImpl();

	@Override
	public Comment getCommentById(int commentId, Session session) {
		Comment comment = commentDaoImpl.getCommentById(commentId, session);
		return comment;
	}

	@Override
	public boolean createComment(Comment comment, Session session) {
		boolean created = commentDaoImpl.createComment(comment, session);
		return created;
	}

	@Override
	public boolean deleteComment(Comment comment, Session session) {
		boolean deleted = commentDaoImpl.deleteComment(comment, session);
		return deleted;
	}

}
