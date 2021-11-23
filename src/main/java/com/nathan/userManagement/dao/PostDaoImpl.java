package com.nathan.userManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.nathan.userManagement.beans.Post;
import com.nathan.userManagement.util.DBUtils;

public class PostDaoImpl implements PostDao {

	@Override
	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		try (Connection connection = DBUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POSTS)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("user_id");
				String content = rs.getString("content");
				Timestamp createdAt = rs.getTimestamp("created_at");
				Post post = new Post(id, userId, content, createdAt);
				posts.add(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public boolean createPost(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePost(int id, String content) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePost(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
