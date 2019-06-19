package com.starwars.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.starwars.api.model.Reporte;

/**
 * @author Aryaovalldo Cleef
 *
 */

public interface IReporteRepository extends JpaRepository<Reporte, Long>{
	
	/*
	 * Buscando quantidade de reportes de um rebelde
	 */
	long qtdReporteRebelde(long idRebelde);
}
