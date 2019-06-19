package com.starwars.api.model.error;

/**
 * @author Aryosvalldo Cleef
 *
 */

/*
 * Classe que trata a exceção NullPointerException
 */

public class NullPointerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NullPointerException(String message) {
		super(message);
	}
}
