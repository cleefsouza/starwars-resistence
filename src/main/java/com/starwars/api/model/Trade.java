package com.starwars.api.model;

import java.util.List;

/**
 * @author Aryosvalldo Cleef
 * 
 */

/*
 * Classe especifica para negociações entre rebeldes
 */

public class Trade {
	private Long idRebelde;
	private List<Item> itens;

	/**
	 * @return the idRebelde
	 */
	public Long getIdRebelde() {
		return idRebelde;
	}

	/**
	 * @param idRebelde the idRebelde to set
	 */
	public void setIdRebelde(Long idRebelde) {
		this.idRebelde = idRebelde;
	}

	/**
	 * @return the item
	 */
	public List<Item> getItens() {
		return itens;
	}

	/**
	 * @param itens the itens to set
	 */
	public void setItem(List<Item> itens) {
		this.itens = itens;
	}
}
