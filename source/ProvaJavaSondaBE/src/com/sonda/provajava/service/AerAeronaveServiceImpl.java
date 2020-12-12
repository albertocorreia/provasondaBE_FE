package com.sonda.provajava.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonda.provajava.bean.AerAeronave;
import com.sonda.provajava.dao.AerAeronaveDaoImpl;
import com.sonda.provajava.dao.EntityFactory;
import com.sonda.provajava.exceptions.NonexistentEntityException;

/**
 * <h1>Service da API</h1>
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */

@Service("AerAeronaveService")
public class AerAeronaveServiceImpl implements AerAeronaveService {

	@Autowired
	private AerAeronaveDaoImpl aerAeronaveDao;

	/**
	 * RETORNA TODAS as aeronaves
	 */
	@Override
	public List<AerAeronave> getAerAeronaves() {
		aerAeronaveDao = new AerAeronaveDaoImpl(EntityFactory.getEntityManager().getEntityManagerFactory());

		List<AerAeronave> aerAeronaves = aerAeronaveDao.getAerAeronaves();
		return aerAeronaves;
	}

	/**
	 * RETORNA UMA aeronave
	 */
	@Override
	public AerAeronave getAerAeronave(Long id) {
		aerAeronaveDao = new AerAeronaveDaoImpl(EntityFactory.getEntityManager().getEntityManagerFactory());
		return aerAeronaveDao.getAerAeronave(id);
	}

	/**
	 * EXCLUI uma aeronave
	 */
	@Override
	public int deleteAerAeronave(Long id) {
		aerAeronaveDao = new AerAeronaveDaoImpl(EntityFactory.getEntityManager().getEntityManagerFactory());
		try {
			aerAeronaveDao.deleteAerAeronave(id);
		} catch (NonexistentEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * ATUALIZA uma aeronave
	 */
	@Override
	public int updateAerAeronave(AerAeronave aerAeronave) {
		aerAeronaveDao = new AerAeronaveDaoImpl(EntityFactory.getEntityManager().getEntityManagerFactory());
		try {
			aerAeronaveDao.updateAerAeronave(aerAeronave);
		} catch (NonexistentEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * CRIA uma nova aeronave
	 */
	@Override
	public int createAerAeronave(AerAeronave aerAeronave) throws ParseException {

		aerAeronaveDao = new AerAeronaveDaoImpl(EntityFactory.getEntityManager().getEntityManagerFactory());
		aerAeronaveDao.createAerAeronave(aerAeronave);

		return 0;
	}

}
