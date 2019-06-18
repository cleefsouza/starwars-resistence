package com.starwars.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.model.Localizacao;
import com.starwars.api.service.LocalizacaoServiceImpl;

/**
 * @author Aryosvalldo Cleef
 * 
 */

@RestController
@RequestMapping(value = "/localizacao")
public class LocalizacaoController {

	/*
	 * Injetando dependências necessárias
	 */
	@Autowired
	private LocalizacaoServiceImpl locService;

	/**
	 * Reportar nova Localização do Rebelde
	 * 
	 * @param id rebelde
	 * 
	 */
	@PutMapping("/reportar/{id}")
	public void reportarLocalizacao(@Valid @RequestBody Localizacao localizacao, @PathVariable("id") Long id) {
		locService.update(localizacao, id);
	}

}
