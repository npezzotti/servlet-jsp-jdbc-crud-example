package com.nathan.userManagement.dao;

import java.util.List;

import com.nathan.userManagement.beans.Comment;

public interface CommentDao {

	static final String GET_COMMENTS_BY_POST = "SELECT * FROM comments WHERE post_id = ?;";
	static final String CREATE_COMMENT = "INSERT INTO comments (user_id, post_id, content) VALUES (?, ?, ?);";
	static final String UPDATE_COMMENT = "UPDATE comments SET content = ? WHERE id = ?;";
	static final String DELETE_COMMENT = "DELETE FROM comments WHERE id = ?;";
	
	
	public List<Comment> getCommentsByPost(int id);
	public boolean createComment(int userId, int postId, String content);
	public boolean updateComment(String content, int id);
	public boolean deleteComment(int id);
}
