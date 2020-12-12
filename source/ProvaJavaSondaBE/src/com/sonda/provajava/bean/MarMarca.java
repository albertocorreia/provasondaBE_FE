package com.sonda.provajava.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * <h1>bean mar_marca</h1>
 * Bean referente a tabela mar_marca 
 * <b>Note:</b> esta classe foi criada para mehorias no projeto que não foram implementadas
 * 
 * @author Alberto Correia (alberto.correia@gmail.com)
 * @version 1.0
 * 
 * @since 2020-12-11
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "mar_marca")
@NamedQueries({ @NamedQuery(name = "MarMarca.findAll", query = "SELECT m FROM MarMarca m"),
		@NamedQuery(name = "MarMarca.findByMarId", query = "SELECT m FROM MarMarca m WHERE m.marId = :marId"),
		@NamedQuery(name = "MarMarca.findByMarNome", query = "SELECT m FROM MarMarca m WHERE m.marNome = :marNome"),
		@NamedQuery(name = "MarMarca.findByMarCreated", query = "SELECT m FROM MarMarca m WHERE m.marCreated = :marCreated"),
		@NamedQuery(name = "MarMarca.findByMarUpdated", query = "SELECT m FROM MarMarca m WHERE m.marUpdated = :marUpdated") })
public class MarMarca implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "mar_id")
	private Long marId;
	@Basic(optional = false)
	@Column(name = "mar_nome")
	private String marNome;
	@Basic(optional = false)
	@Column(name = "mar_created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date marCreated;
	@Basic(optional = false)
	@Column(name = "mar_updated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date marUpdated;

	public MarMarca() {
	}

	public MarMarca(Long marId) {
		this.marId = marId;
	}

	public MarMarca(Long marId, String marNome, Date marCreated, Date marUpdated) {
		this.marId = marId;
		this.marNome = marNome;
		this.marCreated = marCreated;
		this.marUpdated = marUpdated;
	}

	public Long getMarId() {
		return marId;
	}

	public void setMarId(Long marId) {
		this.marId = marId;
	}

	public String getMarNome() {
		return marNome;
	}

	public void setMarNome(String marNome) {
		this.marNome = marNome;
	}

	public Date getMarCreated() {
		return marCreated;
	}

	public void setMarCreated(Date marCreated) {
		this.marCreated = marCreated;
	}

	public Date getMarUpdated() {
		return marUpdated;
	}

	public void setMarUpdated(Date marUpdated) {
		this.marUpdated = marUpdated;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (marId != null ? marId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof MarMarca)) {
			return false;
		}
		MarMarca other = (MarMarca) object;
		if ((this.marId == null && other.marId != null) || (this.marId != null && !this.marId.equals(other.marId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.mycompany.teste123.MarMarca[ marId=" + marId + " ]";
	}

}
