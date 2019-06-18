package com.starwars.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.model.Localizacao;
import com.starwars.api.repository.ILocalizacaoRepository;

/**
 * @author Aryosvalldo Cleef
 * 
 */

@Service
public class LocalizacaoServiceImpl implements ILocalizacaoService{
	
	/*
	 * Injetando as dependências necessárias
	 */
	
	@Autowired
	private ILocalizacaoRepository locRepositorio;
	
	@Override
	public void update(Localizacao localizacao , Long id) {
		locRepositorio.update(localizacao.getLatitude(), localizacao.getLongitude(), localizacao.getGalaxia(), id);
	}

}
