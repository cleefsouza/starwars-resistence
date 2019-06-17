package com.starwars.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.model.Rebelde;
import com.starwars.api.service.RebeldeServiceImpl;

/**
 * @author Aryosvalldo Cleef
 * 
 */

@RestController
@RequestMapping(value = "/rebelde")
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
}
