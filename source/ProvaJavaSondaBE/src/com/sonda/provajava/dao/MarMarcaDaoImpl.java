package com.sonda.provajava.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.sonda.provajava.bean.MarMarca;

/**
 * <h1>DAO implementação MarMarca</h1> 
 * <b>Note:</b> esta classe foi criada para mehorias no projeto que não foram implementadas
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */
public class MarMarcaDaoImpl implements MarMarcaDao {

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public MarMarcaDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public MarMarca getMarMarca(Long id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(MarMarca.class, id);
		} finally {
			em.close();
		}
	}

	@Override
	public List<MarMarca> getMarMarcas() {
		return findMarMarcaEntities(true, -1, -1);
	}

	public List<MarMarca> findMarMarcaEntities(int maxResults, int firstResult) {
		return findMarMarcaEntities(false, maxResults, firstResult);
	}

	private List<MarMarca> findMarMarcaEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(MarMarca.class));
			Query q = em.createQuery(cq);
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			em.close();
		}
	}
}
