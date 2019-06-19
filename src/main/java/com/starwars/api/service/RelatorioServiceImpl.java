package com.starwars.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starwars.api.model.Relatorio;
import com.starwars.api.repository.IRebeldeRepository;

/**
 * @author Aryaovalldo Cleef
 *
 */

@Service
public class RelatorioServiceImpl {

	/*
	 * Injeção de dependencia
	 */
	@Autowired
	private IRebeldeRepository rebRepository;

	/*
	 * Retorna um relatório preenchido
	 */
	public Relatorio getRelatorio() {
		Relatorio relatorio = new Relatorio();
		relatorio.setPorcentagemTraidores(calcularPorcentagemTraidores());
		relatorio.setPorcentagemRebeldes(calcularPorcentagemRebeldes());
		return relatorio;
	}

	// Calcula a porcentagem de traidores
	public double calcularPorcentagemTraidores() {
		double result = ((double) rebRepository.totalTraidores(true) / 100) * rebRepository.totalRebeldes();
		return result;
	}

	// Calcula a porcentagem de rebeldes
	public double calcularPorcentagemRebeldes() {
		double result = ((double) rebRepository.totalTraidores(false) / 100) * rebRepository.totalRebeldes();
		return result;
	}
}
