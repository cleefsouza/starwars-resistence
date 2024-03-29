package com.starwars.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Aryaovalldo Cleef
 *
 */

/*
 * Entidade que representa rebelde dentro da aplicação.
 * 
 * Utilizei as três letras iniciais da entidade como padrão para nomear suas
 * colunas no banco de dados, creio que torna mais fácil diferenciar as
 * entidades.
 * 
 */

@Entity
@Table(name = "TB_REBELDE")

/*
 * Utilizando named query para realizar comandos personalizados no banco de
 * dados
 */
@NamedQueries({
		@NamedQuery(name = "Rebelde.confirmarTraicao", query = "UPDATE Rebelde r SET r.traidor=true WHERE r.id=?1"),
		@NamedQuery(name = "Rebelde.totalTraidores", query = "SELECT COUNT(r.id) FROM Rebelde r WHERE r.traidor=?1"),
		@NamedQuery(name = "Rebelde.totalRebeldes", query = "SELECT COUNT(r.id) FROM Rebelde r") })

public class Rebelde implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(name = "REB_NOME", nullable = false)
	private String nome;

	@Column(name = "REB_IDADE", nullable = false)
	private int idade;

	@Column(name = "REB_GENERO", nullable = false)
	private char genero;

	@Column(name = "REB_TRAIDOR", nullable = false)
	private boolean traidor;

	/**
	 * @return the traidor
	 */
	public boolean isTraidor() {
		return traidor;
	}

	@OneToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "REB_ID_LOCALIZACAO", nullable = false)
	private Localizacao localizacao;

	@OneToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "REB_ID_INVENTARIO", nullable = false)
	private Inventario inventario;

	/**
	 * @param traidor the traidor to set
	 */
	public void setTraidor(boolean traidor) {
		this.traidor = traidor;
	}

	/**
	 * @return the inventario
	 */
	public Inventario getInventario() {
		return inventario;
	}

	/**
	 * @param inventario the inventario to set
	 */
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * @param idade the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * @return the genero
	 */
	public char getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * @return the localizacao
	 */
	public Localizacao getLocalizacao() {
		return localizacao;
	}

	/**
	 * @param localizacao the localizacao to set
	 */
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
}
