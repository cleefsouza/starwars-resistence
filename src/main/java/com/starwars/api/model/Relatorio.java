package com.starwars.api.model;

/**
 * @author Aryaovalldo Cleef
 *
 */

/*
 * Relatórios A API deve oferecer os seguintes relatórios: Porcentagem de
 * traidores. Porcentagem de rebeldes. Quantidade média de cada tipo de recurso
 * por rebelde (Ex: 2 armas por rebelde). Pontos perdidos devido a traidores.
 */

public class Relatorio {

	/*
	 * Obs: do relatório implementei apenas dois itens que foram as porcentagens,
	 * pensei na lógica dos demais, mas travei na JPQL
	 */

	private double porcentagemTraidores;
	private double porcentagemRebeldes;

	/**
	 * @return the porcentagemTraidores
	 */
	public double getPorcentagemTraidores() {
		return porcentagemTraidores;
	}

	/**
	 * @param porcentagemTraidores the porcentagemTraidores to set
	 */
	public void setPorcentagemTraidores(double porcentagemTraidores) {
		this.porcentagemTraidores = porcentagemTraidores;
	}

	/**
	 * @return the porcentagemRebeldes
	 */
	public double getPorcentagemRebeldes() {
		return porcentagemRebeldes;
	}

	/**
	 * @param porcentagemRebeldes the porcentagemRebeldes to set
	 */
	public void setPorcentagemRebeldes(double porcentagemRebeldes) {
		this.porcentagemRebeldes = porcentagemRebeldes;
	}
}