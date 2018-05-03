package org.imcs.MyMavenProjectTest.HibernateDemo.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CustomerUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();


	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionFactory = configuration.buildSessionFactory();
			return sessionFactory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
