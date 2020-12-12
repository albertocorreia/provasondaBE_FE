package com.sonda.provajava.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <h1> bean aer_aeronave</h1>
 * Bean referente a tabela aer_aeronave
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since  2020-12-11 
 */

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "aer_aeronave")
@NamedQueries({ @NamedQuery(name = "AerAeronave.findAll", query = "SELECT a FROM AerAeronave a"),
		@NamedQuery(name = "AerAeronave.findByAerId", query = "SELECT a FROM AerAeronave a WHERE a.aerId = :aerId"),
		@NamedQuery(name = "AerAeronave.findByAerNome", query = "SELECT a FROM AerAeronave a WHERE a.aerNome = :aerNome"),
		@NamedQuery(name = "AerAeronave.findByAerAno", query = "SELECT a FROM AerAeronave a WHERE a.aerAno = :aerAno"),
		@NamedQuery(name = "AerAeronave.findByAerVendido", query = "SELECT a FROM AerAeronave a WHERE a.aerVendido = :aerVendido"),
		@NamedQuery(name = "AerAeronave.findByAerCreated", query = "SELECT a FROM AerAeronave a WHERE a.aerCreated = :aerCreated"),
		@NamedQuery(name = "AerAeronave.findByAerUpdated", query = "SELECT a FROM AerAeronave a WHERE a.aerUpdated = :aerUpdated") })
public class AerAeronave implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "aer_id")
	private Long aerId;
	@Basic(optional = false)
	@Column(name = "aer_nome")
	@JsonProperty("aerNome")
	private String aerNome;
	@Basic(optional = false)
	@Column(name = "aer_ano")
	private int aerAno;
	@Basic(optional = false)
	@Lob
	@Column(name = "aer_descricao")
	private String aerDescricao;
	@Basic(optional = false)
	@Column(name = "aer_vendido")
	private short aerVendido;
	@Basic(optional = true)
	@Column(name = "aer_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aerCreated;
	@Basic(optional = true)
	@Column(name = "aer_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date aerUpdated;
	@Basic(optional = false)
	@Column(name = "aer_marca")
	private String aerMarca;

	public AerAeronave() {
	}

	public AerAeronave(Long aerId) {
		this.aerId = aerId;
	}

	public AerAeronave(Long aerId, String aerNome, int aerAno, String aerDescricao, short aerVendido, Date aerCreated,
			Date aerUpdated, String aerMarca) {
		this.aerId = aerId;
		this.aerNome = aerNome;
		this.aerAno = aerAno;
		this.aerDescricao = aerDescricao;
		this.aerVendido = aerVendido;
		this.aerCreated = aerCreated;
		this.aerUpdated = aerUpdated;
		this.aerMarca = aerMarca;
	}

	public Long getAerId() {
		return aerId;
	}

	public void setAerId(Long aerId) {
		this.aerId = aerId;
	}

	public String getAerNome() {
		return aerNome;
	}

	public void setAerNome(String aerNome) {
		this.aerNome = aerNome;
	}

	public int getAerAno() {
		return aerAno;
	}

	public void setAerAno(int aerAno) {
		this.aerAno = aerAno;
	}

	public String getAerDescricao() {
		return aerDescricao;
	}

	public void setAerDescricao(String aerDescricao) {
		this.aerDescricao = aerDescricao;
	}

	public short getAerVendido() {
		return aerVendido;
	}

	public void setAerVendido(short aerVendido) {
		this.aerVendido = aerVendido;
	}

	public Date getAerCreated() {
		return aerCreated;
	}

	public void setAerCreated(Date aerCreated) {
		this.aerCreated = aerCreated;
	}

	public Date getAerUpdated() {
		return aerUpdated;
	}

	public void setAerUpdated(Date aerUpdated) {
		this.aerUpdated = aerUpdated;
	}

	public String getAerMarca() {
		return aerMarca;
	}

	public void setAerMarca(String aerMarca) {
		this.aerMarca = aerMarca;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (aerId != null ? aerId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof AerAeronave)) {
			return false;
		}
		AerAeronave other = (AerAeronave) object;
		if ((this.aerId == null && other.aerId != null) || (this.aerId != null && !this.aerId.equals(other.aerId))) {
			return false;
		}
		return true;
	}

}
