package com.starwars.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.model.Reporte;
import com.starwars.api.service.ReporteServiceImpl;

@RestController
@RequestMapping(value = "/reporte")
public class ReporteController {

	/*
	 * Injetando dependências necessárias
	 */
	@Autowired
	private ReporteServiceImpl repService;

	/*
	 * Reportando rebelde por traição
	 */
	@PostMapping
	public void save(@Valid @RequestBody Reporte reporte) {
		repService.save(reporte);
	}
}
