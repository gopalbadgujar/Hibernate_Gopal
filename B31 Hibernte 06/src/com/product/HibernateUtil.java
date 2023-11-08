package com.product;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	public static StandardServiceRegistry registry;

	public static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			System.out.println("Hello");
			Map<String, Object> map = new HashMap<String, Object>();

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/batch31hbm6");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, "true");// Boolean String
			map.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Grocery.class)
					.addAnnotatedClass(Electronics.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.buildSessionFactory();

			return sf;

		}

		return sf;
	}

}
