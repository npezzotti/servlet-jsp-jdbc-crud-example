package com.nathan.userManagement.dao;

import java.util.List;

import com.nathan.userManagement.beans.Post;

public interface PostDao {

	static final String GET_ALL_POSTS = "SELECT * FROM posts;";
	static final String CREATE_POST = "INSERT INTO posts (user_id, content) VALUES (?, ?);";
	static final String UPDATE_POST = "UPDATE posts SET content = ? WHERE id = ?;";
	static final String DELETE_POST = "DELETE FROM posts WHERE id = ?;";

	public List<Post> getAllPosts();
	public boolean createPost(Post post);
	public boolean updatePost(int id, String content);
	public boolean deletePost(int id);
}
