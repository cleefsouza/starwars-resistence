package com.starwars.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
}
