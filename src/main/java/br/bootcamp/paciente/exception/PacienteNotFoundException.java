package br.bootcamp.paciente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacienteNotFoundException extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PacienteNotFoundException(Long id) {
	        super("Person not found with ID " + id);
	    }
}
