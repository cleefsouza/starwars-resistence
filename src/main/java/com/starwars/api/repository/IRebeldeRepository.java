package com.starwars.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.starwars.api.model.Rebelde;

/**
 * @author Aryaovalldo Cleef
 *
 */

public interface IRebeldeRepository extends JpaRepository<Rebelde, Long> {
	
	/*
	 * Método para buscar rebelde por id
	 */
	Rebelde findById(long id);
	
	/*
	 * Método para listar todos os rebeldes
	 */
	List<Rebelde> findAll();
	
	/*
	 * Confirmando rebelde como traidor
	 */
	@Transactional(readOnly = false)
	@Modifying
	void confirmarTraicao(long idRebelde);
	
	
	/*
	 * Métodos usados no relátorio da api
	 */
	
	// Retorna o total de traidores
	@Transactional(readOnly = true)
	int totalTraidores(boolean situacao);
	
	// Retorna o total de rebeldes fieis
	@Transactional(readOnly = true)
	int totalRebeldes();
}
