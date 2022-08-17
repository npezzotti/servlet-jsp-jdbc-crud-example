package com.nathan.socialMediaApp.service;

import java.util.List;

import org.hibernate.Session;

import com.nathan.socialMediaApp.model.Post;

public interface PostService {

	public List<Post> getAllPosts(Session session);

	public Post getPostById(int id, Session session);

	public boolean createPost(Post post, Session session);

	public boolean deletePost(Post post, Session session);
}
