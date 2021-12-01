package com.nathan.socialMediaApp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nathan.socialMediaApp.dao.PostDaoImpl;
import com.nathan.socialMediaApp.model.Post;

public class PostServiceImpl implements PostService {

	private PostDaoImpl postDaoImpl = new PostDaoImpl();

	@Override
	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<Post>();
		try {
			posts = postDaoImpl.getAllPosts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public Post getPostById(int id) {
		Post post = null;
		try {
			post = postDaoImpl.getPostById(id);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return post;
	}

	@Override
	public boolean createPost(Post post) {
		boolean created = false;
		try {
			created = postDaoImpl.createPost(post);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public boolean updatePost(Post post) {
		boolean updated = false;
		try {
			updated = postDaoImpl.updatePost(post);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean deletePost(Post post) {
		boolean deleted = false;
		try {
			deleted = postDaoImpl.deletePost(post);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}

}
