package com.nathan.userManagement.service;

import java.util.List;

import com.nathan.userManagement.beans.Comment;

public interface CommentService {

	public List<Comment> getCommentsByPost(int id);
	public boolean createComment(Comment comment);
	public boolean updateComment(Comment comment);
	public boolean deleteComment(Comment comment);
}
