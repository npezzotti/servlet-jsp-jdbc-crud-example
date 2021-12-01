package com.nathan.socialMediaApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.nathan.socialMediaApp.model.Comment;
import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.util.DBUtils;

public class CommentDaoImpl implements CommentDao {

	@Override
	public List<Comment> getCommentsByPost(Post post) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_COMMENTS_BY_POST);
		List<Comment> comments = new ArrayList<Comment>();
		preparedStatement.setInt(1, post.getId());
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			int postId = rs.getInt("post_id");
			int userId = rs.getInt("user_id");
			String content = rs.getString("content");
			Timestamp createdAt = rs.getTimestamp("created_at");
			comments.add(new Comment(id, postId, userId, content, createdAt));
		}
		return comments;
	}

	@Override
	public boolean createComment(Comment comment) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE_COMMENT);
		preparedStatement.setInt(1, comment.getUserId());
		preparedStatement.setInt(2, comment.getPostId());
		preparedStatement.setString(3, comment.getContent());
		boolean saved = preparedStatement.executeUpdate() > 0;
		connection.close();
		return saved;
	}


	@Override
	public boolean updateComment(Comment comment) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMENT);
		preparedStatement.setString(1, comment.getContent());
		preparedStatement.setInt(2, comment.getId());
		boolean updated = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		connection.close();
		return updated;
	}

	@Override
	public boolean deleteComment(Comment comment) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENT);
		preparedStatement.setInt(1, comment.getId());
		boolean deleted = preparedStatement.executeUpdate() > 0;
		connection.close();
		return deleted;
	}

}
