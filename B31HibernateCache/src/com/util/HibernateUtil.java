package com.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.producrts.Electronics;
import com.producrts.Grocery;

public class HibernateUtil {

	private static StandardServiceRegistry registry;
	
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		if(sf == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			//Database Connection
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/b31hbmcache");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");
			
			//Hibernate Properties
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			map.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Electronics.class).addAnnotatedClass(Grocery.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.buildSessionFactory();
			
			return sf;
		}
		return sf;
	}
}
