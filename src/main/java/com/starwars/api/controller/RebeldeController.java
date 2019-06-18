package com.starwars.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.model.Rebelde;
import com.starwars.api.model.Trade;
import com.starwars.api.service.RebeldeServiceImpl;

/**
 * @author Aryosvalldo Cleef
 * 
 */

@RestController
@RequestMapping(value = "/rebelde", produces = "application/json")
public class RebeldeController {

	/*
	 * Injetando dependências necessárias
	 */
	@Autowired
	private RebeldeServiceImpl rebService;

	/*
	 * Cadastrar novo Rebelde
	 */
	@PostMapping
	public void save(@Valid @RequestBody Rebelde rebelde) {
		rebService.save(rebelde);
	}

	/**
	 * Exibindo informações do Rebelde
	 * 
	 * @param id
	 */
	@GetMapping
	public Rebelde getById(@RequestParam("id") long id) {
		return rebService.findById(id);
	}

	/*
	 * Realizando trade entre rebeldes
	 */
	@PostMapping("/trade")
	public void realizarTrade(@RequestBody Trade[] trade) {
		rebService.realizarTrade(trade[0], trade[1]);
	}
}
