package com.nathan.socialMediaApp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nathan.socialMediaApp.model.Post;

public class PostDaoImpl implements PostDao {

	@Override
	public List<Post> getAllPosts(Session session) {
		List<Post> posts = new ArrayList<>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			posts = session.createQuery("from Post", Post.class).getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return posts;
	}

	@Override
	public Post getPostById(int postId, Session session) {
		Post post = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			post = session.get(Post.class, postId);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return post;
	}

	@Override
	public boolean createPost(Post post, Session session) {
		int postId = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			postId = (int) session.save(post);
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return postId > 0;
	}

	@Override
	public boolean deletePost(Post post, Session session) {
		boolean deleted = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(post);
			tx.commit();
			deleted = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return deleted;
	}

}
