package com.starwars.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.model.Rebelde;
import com.starwars.api.repository.IRebeldeRepository;

/**
 * @author Aryosvalldo Cleef
 *
 */

/*
 * Classe que implementa a interface com os erviços para a entidade rebelde
 */

@Service
public class RebeldeServiceImpl implements IRebeldeService{

	/*
	 * Injetando as dependências necessárias
	 */
	
	@Autowired
	private IRebeldeRepository rebRepository;

	@Override
	public void save(Rebelde rebelde) {		
		rebRepository.save(rebelde);
	}
}