package com.nathan.userManagement.service;

import java.util.List;

import com.nathan.userManagement.beans.Comment;
import com.nathan.userManagement.beans.Post;

public interface CommentService {

	public List<Comment> getCommentsByPost(Post post);
}
