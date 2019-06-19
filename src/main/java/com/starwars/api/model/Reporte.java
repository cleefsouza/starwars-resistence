package com.starwars.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Aryaovalldo Cleef
 *
 */

/*
 * Entidade que representa os reportes feitos pelos rebeldes dentro da
 * aplicação.
 * 
 * Utilizei as três letras iniciais da entidade como padrão para nomear suas
 * colunas no banco de dados, creio que torna mais fácil diferenciar as
 * entidades.
 * 
 */

@Entity
@Table(name = "TB_REPORTE")
/*
 * Utilizando named query para realizar comandos personalizados no banco de
 * dados
 */
@NamedQuery(name = "Reporte.qtdReporteRebelde", query = "SELECT COUNT(r.idAcusado) FROM Reporte r WHERE r.idAcusado=?1")
public class Reporte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "REP_ACUSADO", nullable = false)
	private Long idAcusado;

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
	 * @return the idAcusado
	 */
	public Long getIdAcusado() {
		return idAcusado;
	}

	/**
	 * @param idAcusado the idAcusado to set
	 */
	public void setIdAcusado(Long idAcusado) {
		this.idAcusado = idAcusado;
	}
}