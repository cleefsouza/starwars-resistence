package com.starwars.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;

/**
 * @author Aryaovalldo Cleef
 *
 */

/*
 * Entidade que representa os itens do inventario dentro da aplicação.
 * 
 * Utilizei as três letras iniciais da entidade como padrão para nomear suas
 * colunas no banco de dados, creio que torna mais fácil diferenciar as
 * entidades.
 * 
 */

@Entity
@Table(name = "TB_ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Column(name = "ITE_NOME", nullable = false)
	private String nome;

	@Column(name = "ITE_QUANTIDADE")
	@ColumnDefault("0")
	private int qtd;

	// Os pontos serão calculados pelo service
	@Column(name = "ITE_PONTOS", nullable = true)
	private int pontos;

	/*
	 * Verificando pontuação por nome do item, caso o item não seja válido o mesmo
	 * será cadastrado como "Lixo"
	 */
	public void adicionarPontos() {

		if (this.nome.equalsIgnoreCase("Arma")) {
			this.pontos = 4;
		} else if (this.nome.equalsIgnoreCase("Munição")) {
			this.pontos = 3;
		} else if (this.nome.equalsIgnoreCase("Água")) {
			this.pontos = 2;
		} else if (this.nome.equalsIgnoreCase("Comida")) {
			this.pontos = 1;
		}
	}

	/**
	 * @return the pontos
	 */
	public int getPontos() {
		return pontos;
	}

	/**
	 * @param pontos the pontos to set
	 */
	public void setPontos(int pontos) {
		this.pontos = pontos;
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
	 * @return the qtd
	 */
	public int getQtd() {
		return qtd;
	}

	/**
	 * @param qtd the qtd to set
	 */
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}