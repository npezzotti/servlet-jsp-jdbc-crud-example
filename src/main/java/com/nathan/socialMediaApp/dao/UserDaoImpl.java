package com.nathan.socialMediaApp.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nathan.socialMediaApp.model.User;

public class UserDaoImpl implements UserDao {

	public boolean createUser(User user, Session session) {
		int userId = 0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			userId = (int) session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return userId > 0;
	}

	public User getUserById(int userId, Session session) {
		User user = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			user = session.get(User.class, userId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return user;
	}

	public User getUserByEmail(String emailAddress, Session session) {
		User user = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("from User u where u.email=:email", User.class).setParameter("email",
					emailAddress);
			List<User> rs = query.getResultList();
			tx.commit();
			if (rs.size() > 0)
				return rs.get(0);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return user;
	}

	public boolean deleteUser(User user, Session session) {
		boolean deleted = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			deleted = true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return deleted;
	}

	public boolean updateUser(User user, Session session) {
		boolean updated = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			updated = true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return updated;
	}

}
