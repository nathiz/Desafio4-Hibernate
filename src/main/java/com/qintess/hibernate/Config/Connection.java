package com.qintess.hibernate.Config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("GenericDao");;
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
