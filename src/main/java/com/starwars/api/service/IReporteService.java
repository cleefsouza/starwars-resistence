package com.starwars.api.service;

import com.starwars.api.model.Reporte;

/**
 * @author Aryaovalldo Cleef
 *
 */

public interface IReporteService {
	
	/*
	 * Reportando Rebelde
	 */
	void save(Reporte reporte);
	
	/*
	 * Confirmando rebelde como traidor
	 */
	void confirmarTraicao(long idRebelde);
	
	/*
	 * Buscando quantidade de reportes de um rebelde
	 */
	long qtdReporteRebelde(long idRebelde);

}
