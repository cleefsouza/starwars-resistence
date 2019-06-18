package com.starwars.api.service;

import com.starwars.api.model.Localizacao;

/**
 * @author Aryaovalldo Cleef
 *
 */

public interface ILocalizacaoService {

	/*
	 * Reportar Localizacao do Rebelde
	 */
	void update(Localizacao localizacao, Long id);
}
