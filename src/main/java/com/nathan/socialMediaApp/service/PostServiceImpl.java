package com.nathan.socialMediaApp.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nathan.socialMediaApp.dao.PostDaoImpl;
import com.nathan.socialMediaApp.model.Post;

public class PostServiceImpl implements PostService {

	private PostDaoImpl postDaoImpl = new PostDaoImpl();

	@Override
	public List<Post> getAllPosts(Session session) {
		List<Post> posts = new ArrayList<Post>();
		posts = postDaoImpl.getAllPosts(session);
		return posts;
	}

	@Override
	public Post getPostById(int id, Session session) {
		Post post = postDaoImpl.getPostById(id, session);
		return post;
	}

	@Override
	public boolean createPost(Post post, Session session) {
		boolean created = postDaoImpl.createPost(post, session);
		return created;
	}

	@Override
	public boolean deletePost(Post post, Session session) {
		boolean deleted = false;
		deleted = postDaoImpl.deletePost(post, session);
		return deleted;
	}

}
