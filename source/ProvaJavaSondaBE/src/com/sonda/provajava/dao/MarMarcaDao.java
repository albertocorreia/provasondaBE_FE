package com.sonda.provajava.dao;

import com.sonda.provajava.bean.MarMarca;

import java.util.List;

/**
 * <h1>DAO interface</h1>
 * <b>Note:</b> esta classe foi criada para mehorias no projeto que não foram implementadas
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */
public interface MarMarcaDao {

	 public MarMarca getMarMarca(Long id);
	 public List<MarMarca> getMarMarcas();
}
