package com.nathan.socialMediaApp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		if (sessionFactory == null) {
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
			try {
				sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
				StandardServiceRegistryBuilder.destroy(registry);
			}
			return sessionFactory;
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionfactory().close();
	}

	public static Session getSession() {
		return HibernateUtil.getSessionfactory().openSession();
	}
}
