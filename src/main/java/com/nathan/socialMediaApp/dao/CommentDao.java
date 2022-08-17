package com.nathan.socialMediaApp.dao;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.Comment;

public interface CommentDao {

	public Comment getCommentById(int commentId, Session session);

	public boolean createComment(Comment comment, Session session);

	public boolean deleteComment(Comment comment, Session session);
}
