package com.nathan.socialMediaApp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nathan.socialMediaApp.model.Comment;

public class CommentDaoImpl implements CommentDao {

	@Override
	public Comment getCommentById(int commentId, Session session) {
		Comment comment = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			comment = session.get(Comment.class, commentId);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public boolean createComment(Comment comment, Session session) {
		int commentId = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			commentId = (int) session.save(comment);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return commentId > 0;
	}

	@Override
	public boolean deleteComment(Comment comment, Session session) {
		boolean deleted = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(comment);
			tx.commit();
			deleted = true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return deleted;
	}

}
