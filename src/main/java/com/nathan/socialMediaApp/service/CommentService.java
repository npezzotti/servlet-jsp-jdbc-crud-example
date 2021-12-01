package com.nathan.socialMediaApp.service;

import java.util.List;

import com.nathan.socialMediaApp.model.Comment;
import com.nathan.socialMediaApp.model.Post;

public interface CommentService {

	public List<Comment> getCommentsByPost(Post post);
	public boolean createComment(Comment comment);
	public boolean updateComment(Comment comment);
	public boolean deleteComment(Comment comment);
}
