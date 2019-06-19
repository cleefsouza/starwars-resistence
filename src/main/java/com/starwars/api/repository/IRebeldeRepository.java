package com.starwars.api.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

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
	@Transactional
	@Modifying
	void confirmarTraicao(long idRebelde);
}
