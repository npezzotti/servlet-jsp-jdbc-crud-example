package com.nathan.socialMediaApp.dao;

import java.sql.SQLException;
import java.util.List;

import com.nathan.socialMediaApp.model.Post;

public interface PostDao {

	static final String GET_ALL_POSTS = "SELECT * FROM posts;";
	static final String GET_POST_BY_ID = "SELECT * FROM posts WHERE id = ?;";
	static final String CREATE_POST = "INSERT INTO posts (user_id, content) VALUES (?, ?);";
	static final String UPDATE_POST = "UPDATE posts SET content = ? WHERE id = ?;";
	static final String DELETE_POST = "DELETE FROM posts WHERE id = ?;";

	public List<Post> getAllPosts() throws SQLException;

	public Post getPostById(int id) throws SQLException;

	public boolean createPost(Post post) throws SQLException;

	public boolean updatePost(Post post) throws SQLException;

	public boolean deletePost(Post post) throws SQLException;
}
