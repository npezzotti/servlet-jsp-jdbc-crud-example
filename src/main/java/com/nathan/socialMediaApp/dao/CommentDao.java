package com.nathan.socialMediaApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.nathan.socialMediaApp.model.Comment;
import com.nathan.socialMediaApp.model.Post;

public interface CommentDao {

	static final String GET_COMMENTS_BY_POST = "SELECT * FROM comments c " + "JOIN users u ON c.user_id = u.id "
			+ "WHERE post_id = ?";
	static final String CREATE_COMMENT = "INSERT INTO comments (user_id, post_id, content) VALUES (?, ?, ?);";
	static final String UPDATE_COMMENT = "UPDATE comments SET content = ? WHERE id = ?;";
	static final String DELETE_COMMENT = "DELETE FROM comments WHERE id = ?;";

	public List<Comment> getCommentsByPost(Post post) throws SQLException;

	public boolean createComment(Comment comment) throws SQLException;

	public boolean updateComment(Comment comment) throws SQLException;

	public boolean deleteComment(Comment comment) throws SQLException;
}
