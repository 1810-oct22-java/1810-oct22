package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConnectionUtil {
	
	//this class will use the Configuration interface to create a 
	//singleton instance of a SessionFactory, which will give the 
	//application the ability to use sessions
	
	/**
	 * Hibernate utilizes sessions for connections to the database.
	 * JDBC used connections.
	 * 
	 * Hibernate will implement connection pooling.
	 * 		1. Connections will be maintained.
	 * 		2. We can have 1-n connections to the database.
	 * 
	 * Spinning up a new connection to the database is expensive. By not having to spin up new
	 * connections for every transaction, you save time and resources.
	 * 
	 * Secondly, the connections will be shared across transactions over time. It's a session
	 * because our transaction is utilizing a connection for a given period. And will release
	 * that session such that other transaction can use it.
	 * 
	 * Finally, hibernate will maintain a pool of connections, so concurrent transactions can
	 * occur without having to wait for a connection to open up.
	 */

	
	private static ConnectionUtil cu;
	private SessionFactory sessionFactory;
	
	public synchronized static ConnectionUtil getInstance() {
		if(cu==null) {
			cu = new ConnectionUtil();
		}
		return cu;
	}
	
	//ConnectionUtil.getInsance.getSession
	private synchronized SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			//get config details from hibernate.cfg.xml
			Configuration hibConfiguration = new Configuration().configure();
			
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(hibConfiguration.getProperties()).buildServiceRegistry();
			
			sessionFactory = hibConfiguration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
	
	// return session from sessionFactory
	public Session getSession() {
		return this.getSessionFactory().openSession();
	}
	
	

}
