package com.nathan.socialMediaApp.service;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.Comment;

public interface CommentService {

	public Comment getCommentById(int commentId, Session session);

	public boolean createComment(Comment comment, Session session);

	public boolean deleteComment(Comment comment, Session session);
}
