package com.nathan.socialMediaApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.nathan.socialMediaApp.model.Post;
import com.nathan.socialMediaApp.util.DBUtils;

public class PostDaoImpl implements PostDao {

	@Override
	public List<Post> getAllPosts() throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSTS);
		List<Post> posts = new ArrayList<>();
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			int userId = rs.getInt("user_id");
			String content = rs.getString("content");
			Timestamp createdAt = rs.getTimestamp("created_at");
			Post post = new Post();
			post.setId(id);
			post.setUserId(userId);
			post.setContent(content);
			post.setCreatedAt(createdAt);
			posts.add(post);
		}
		connection.close();
		return posts;
	}

	@Override
	public Post getPostById(int id) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(GET_POST_BY_ID);
		Post post = null;
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			int postId = rs.getInt("id");
			int userId = rs.getInt("user_id");
			String content = rs.getString("content");
			Timestamp createdAt = rs.getTimestamp("created_at");
			post = new Post();
			post.setPostId(postId);
			post.setUserId(userId);
			post.setContent(content);
			post.setCreatedAt(createdAt);
		}
		connection.close();
		return post;
	}

	@Override
	public boolean createPost(Post post) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(CREATE_POST);
		preparedStatement.setInt(1, post.getUserId());
		preparedStatement.setString(2, post.getContent());
		boolean saved = preparedStatement.executeUpdate() > 0;
		connection.close();
		return saved;
	}

	@Override
	public boolean updatePost(Post post) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POST);
		preparedStatement.setString(1, post.getContent());
		preparedStatement.setInt(2, post.getId());
		boolean updated = preparedStatement.executeUpdate() > 0;
		preparedStatement.close();
		connection.close();
		return updated;
	}

	@Override
	public boolean deletePost(Post post) throws SQLException {
		Connection connection = DBUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_POST);
		preparedStatement.setInt(1, post.getId());
		boolean deleted = preparedStatement.executeUpdate() > 0;
		connection.close();
		return deleted;
	}

}
