package com.sonda.provajava.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.sonda.provajava.bean.AerAeronave;
import com.sonda.provajava.exceptions.NonexistentEntityException;

/**
 * <h1>DAO implementação AerAeronave</h1>
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */
@Repository("AerAeronaveDao")
public class AerAeronaveDaoImpl implements AerAeronaveDao {

	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public AerAeronaveDaoImpl() {

	}

	public AerAeronaveDaoImpl(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * RETORNA TODAS as aeronaves
	 */
	@Override
	public List<AerAeronave> getAerAeronaves() {
		return findAerAeronaveEntities(true, -1, -1);
	}

	/**
	 * RETORNA UMA aeronave
	 */
	@Override
	public AerAeronave getAerAeronave(Long id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(AerAeronave.class, id);
		} finally {
			em.close();
		}
	}

	/**
	 * EXCLUI uma aeronave
	 */
	@Override
	public void deleteAerAeronave(Long id) throws NonexistentEntityException {
		EntityManager em = null;
		em = getEntityManager();
		em.getTransaction().begin();
		AerAeronave aerAeronave;
		try {
			aerAeronave = em.getReference(AerAeronave.class, id);
			aerAeronave.getAerId();
		} catch (EntityNotFoundException enfe) {
			throw new NonexistentEntityException("A aeronave " + id + " não existe mais.", enfe);
		}

		em.remove(aerAeronave);
		em.getTransaction().commit();

	}

	/**
	 * ATUALIZA uma aeronave
	 */
	@Override
	public int updateAerAeronave(AerAeronave aerAeronave) throws NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			aerAeronave = em.merge(aerAeronave);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Long id = aerAeronave.getAerId();
				if (getAerAeronave(id) == null) {
					throw new NonexistentEntityException("A aeronave " + id + " não existe mais.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return 0;
	}

	/**
	 * CRIA uma nova aeronave
	 */
	@Override
	public int createAerAeronave(AerAeronave aerAeronave) throws ParseException {

		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();

			em.persist(aerAeronave);

			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return 0;
	}

	/**
	 * métodos de apoio aos demais metodos de busca
	 */
	public List<AerAeronave> findAerAeronaveEntities(int maxResults, int firstResult) {
		return findAerAeronaveEntities(false, maxResults, firstResult);
	}

	private List<AerAeronave> findAerAeronaveEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(AerAeronave.class));
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
