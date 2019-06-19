package com.starwars.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.model.Relatorio;
import com.starwars.api.service.RelatorioServiceImpl;

@RestController
@RequestMapping(value = "/relatorio")
public class RelatorioController {

	@Autowired(required = true)
	private RelatorioServiceImpl relService;
	
	/*
	 * Exibindo relatório no endpoint
	 */
	@GetMapping
	public Relatorio showRelatorio() {
		return relService.getRelatorio();
	}
}
