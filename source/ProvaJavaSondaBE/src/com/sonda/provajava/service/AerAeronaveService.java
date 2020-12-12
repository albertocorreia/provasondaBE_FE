package com.sonda.provajava.service;

import com.sonda.provajava.bean.AerAeronave;

import java.text.ParseException;
import java.util.List;

/**
 * <h1>Service interface</h1>
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */
public interface AerAeronaveService {

	public List<AerAeronave> getAerAeronaves();

	public AerAeronave getAerAeronave(Long id);

	public int deleteAerAeronave(Long id);

	public int updateAerAeronave(AerAeronave aerAeronave);

	public int createAerAeronave(AerAeronave aerAeronave) throws ParseException;

}
