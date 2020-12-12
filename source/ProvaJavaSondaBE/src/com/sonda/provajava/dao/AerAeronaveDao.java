package com.sonda.provajava.dao;

import com.sonda.provajava.bean.AerAeronave;
import com.sonda.provajava.exceptions.NonexistentEntityException;

import java.text.ParseException;
import java.util.List;

/**
 * <h1>DAO interface</h1>
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */
public interface AerAeronaveDao {

	public List<AerAeronave> getAerAeronaves();

	public AerAeronave getAerAeronave(Long id);

	public void deleteAerAeronave(Long id) throws NonexistentEntityException;

	public int updateAerAeronave(AerAeronave aerAeronave) throws NonexistentEntityException;

	public int createAerAeronave(AerAeronave aerAeronave) throws ParseException;
}
