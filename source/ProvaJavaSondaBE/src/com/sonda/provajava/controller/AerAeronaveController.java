package com.sonda.provajava.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sonda.provajava.bean.AerAeronave;
import com.sonda.provajava.service.AerAeronaveService;

/**
 * <h1>Controller da API</h1> Contém os mapeamentos da API 
 * <b>Note:</b> o endpoint GET /aeronaves/find não foi implementado
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */

@RestController
public class AerAeronaveController {

	@Autowired
	private AerAeronaveService aerAeronaveService;

	/** 
	 * endpoint GET /aeronaves 
	 * RETORNA TODAS as aeronaves
	 * 
	 */
	@RequestMapping(value = "/aeronaves", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<AerAeronave>> aeronaves() {

		HttpHeaders headers = new HttpHeaders();
		List<AerAeronave> aeronaves = aerAeronaveService.getAerAeronaves();

		if (aeronaves == null) {
			return new ResponseEntity<List<AerAeronave>>(HttpStatus.NOT_FOUND);
		}
		headers.add("", String.valueOf(aeronaves.size()));
		return new ResponseEntity<List<AerAeronave>>(aeronaves, headers, HttpStatus.OK);

	}

	/** 
	 * endpoint GET /aeronaves/{id}
	 * RETORNA os detalhes de UMA aeronave
	 * 
	 */
	@RequestMapping(value = "/aeronaves/{id}", method = RequestMethod.GET)
	public ResponseEntity<AerAeronave> getEmployee(@PathVariable("id") Long id) {
		AerAeronave aerAeronave = aerAeronaveService.getAerAeronave(id);
		if (aerAeronave == null) {
			return new ResponseEntity<AerAeronave>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AerAeronave>(aerAeronave, HttpStatus.OK);
	}

	/** 
	 * endpoint DELETE /aeronaves/{id}
	 * EXCLUI uma aeronave
	 * 
	 */
	@RequestMapping(value = "/aeronaves/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<AerAeronave> deleteEmployee(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		AerAeronave aerAeronave = aerAeronaveService.getAerAeronave(id);
		if (aerAeronave == null) {
			return new ResponseEntity<AerAeronave>(HttpStatus.NOT_FOUND);
		}
		aerAeronaveService.deleteAerAeronave(id);
		headers.add("excluido", String.valueOf(id));
		return new ResponseEntity<AerAeronave>(aerAeronave, headers, HttpStatus.NO_CONTENT);
	}

	/** 
	 * endpoint POST /aeronaves/
	 * ADICIONA uma aeronave
	 * 
	 */
	@RequestMapping(value = "/aeronaves", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<AerAeronave> createAerAeronave(@RequestBody AerAeronave aerAeronave) throws ParseException {
		HttpHeaders headers = new HttpHeaders();
		if (aerAeronave == null) {
			return new ResponseEntity<AerAeronave>(HttpStatus.NOT_FOUND);
		}
		aerAeronaveService.createAerAeronave(aerAeronave);
		headers.add("criado", String.valueOf(aerAeronave.getAerId()));
		return new ResponseEntity<AerAeronave>(aerAeronave, headers, HttpStatus.CREATED);
	}

	/** 
	 * endpoint PUT /aeronaves/{id}
	 * ATUALIZA  os detalhes de uma aeronave
	 * 
	 */
	@RequestMapping(value = "/aeronaves/{id}", method = RequestMethod.PUT)
	public ResponseEntity<AerAeronave> updateAerAeronave(@PathVariable("id") Long id,
			@RequestBody AerAeronave aerAeronave) {
		HttpHeaders headers = new HttpHeaders();
		AerAeronave isExist = aerAeronaveService.getAerAeronave(id);
		if (isExist == null) {
			return new ResponseEntity<AerAeronave>(HttpStatus.NOT_FOUND);
		} else if (aerAeronave == null) {
			return new ResponseEntity<AerAeronave>(HttpStatus.BAD_REQUEST);
		}
		aerAeronave.setAerId(id);
		aerAeronave.setAerCreated(isExist.getAerCreated());
		aerAeronaveService.updateAerAeronave(aerAeronave);
		headers.add("atualizado", String.valueOf(id));
		return new ResponseEntity<AerAeronave>(aerAeronave, headers, HttpStatus.OK);
	}

}
