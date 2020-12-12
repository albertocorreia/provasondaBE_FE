package com.sonda.provajava.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * <h1> factory </h1>
 * a fabrica de conexões com o banco
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since  2020-12-11 
 */
public class EntityFactory {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aeronavesPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
