package com.starwars.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.starwars.api.model.Localizacao;

/**
 * @author Aryaovalldo Cleef
 *
 */

public interface ILocalizacaoRepository extends JpaRepository<Localizacao, Long>{
	
	/*
	 * Reportar nova Localização do Rebelde
	 */
	@Transactional
	@Modifying
	void update(String lat, String lon, String gal, Long id);
}
