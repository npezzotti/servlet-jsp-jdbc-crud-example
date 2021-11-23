package com.nathan.userManagement.service;

import java.util.List;

import com.nathan.userManagement.beans.Post;

public interface PostService {

	public List<Post> getAllPosts();
	public boolean createPost(Post post);
	public boolean updatePost(Post post);
	public boolean deletePost(Post post);
}
