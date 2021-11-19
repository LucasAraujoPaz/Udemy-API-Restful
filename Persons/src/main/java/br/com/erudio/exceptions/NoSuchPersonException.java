package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchPersonException extends RuntimeException {

	private static final long serialVersionUID = -3940966221402737258L;

	public NoSuchPersonException(String message) {
		super(message);		
	}

}
