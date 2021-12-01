package com.nathan.socialMediaApp.service;

import java.util.List;

import com.nathan.socialMediaApp.model.Post;

public interface PostService {

	public List<Post> getAllPosts();
	
	public Post getPostById(int id);

	public boolean createPost(Post post);

	public boolean updatePost(Post post);

	public boolean deletePost(Post post);
}
