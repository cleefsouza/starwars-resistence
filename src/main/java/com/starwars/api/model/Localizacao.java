/**
 * 
 */
package com.starwars.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aryaovalldo Cleef
 *
 */

/*
 * Entidade que representa localização dentro da aplicação.
 * 
 * Utilizei as três letras iniciais da entidade como padrão para nomear suas
 * colunas no banco de dados, creio que torna mais facil diferenciar as
 * entidades.
 * 
 */

@Entity
@Table(name = "TB_LOCALIZACAO")
public class Localizacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "LOC_LATITUDE", nullable = false)
	private String latitude;

	@Column(name = "LOC_LONGITUDE", nullable = false)
	private String longitude;

	// Apenas o nome da galaxia
	@Column(name = "LOC_GALAXIA", nullable = false)
	private String galaxia;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the galaxia
	 */
	public String getGalaxia() {
		return galaxia;
	}

	/**
	 * @param galaxia the galaxia to set
	 */
	public void setGalaxia(String galaxia) {
		this.galaxia = galaxia;
	}
}