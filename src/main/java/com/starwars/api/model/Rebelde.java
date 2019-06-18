package com.starwars.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@OneToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "REB_ID_LOCALIZACAO", nullable = false)
	private Localizacao localizacao;
	
	@OneToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "REB_ID_INVENTARIO", nullable = false)
	private Inventario inventario;

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
