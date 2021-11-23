package com.nathan.userManagement.service;

import java.util.List;

import com.nathan.userManagement.beans.Post;
import com.nathan.userManagement.dao.PostDaoImpl;

public class PostServiceImpl implements PostService {
	
	private PostDaoImpl postDaoImpl = new PostDaoImpl();

	@Override
	public List<Post> getAllPosts() {
		List<Post> posts = postDaoImpl.getAllPosts();
		return posts;
	}

	@Override
	public boolean createPost(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePost(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePost(Post post) {
		// TODO Auto-generated method stub
		return false;
	}

}
