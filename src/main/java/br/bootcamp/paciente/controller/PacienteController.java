package br.bootcamp.paciente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.bootcamp.paciente.dto.request.PacienteDto;
import br.bootcamp.paciente.dto.response.MessageResponseDto;

import br.bootcamp.paciente.exception.PacienteNotFoundException;
import br.bootcamp.paciente.service.PacienteService;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/v1/paciente")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PacienteController {
	
	 private PacienteService pacienteService;
	@PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public MessageResponseDto createPerson(@RequestBody @Valid PacienteDto PacienteDto) {
	        return pacienteService.createPaciente(PacienteDto);
	    }

	    @GetMapping
	    public List<PacienteDto> listAll() {
	        return pacienteService.listAll();
	    }

	    @GetMapping("/{id}")
	    public PacienteDto findById(@PathVariable Long id) throws PacienteNotFoundException {
	        return pacienteService.findById(id);
	    }

	    @PutMapping("/{id}")
	    public MessageResponseDto updateById(@PathVariable Long id, @RequestBody @Valid  PacienteDto pacienteDto) throws PacienteNotFoundException {
	        return pacienteService.updateById(id, pacienteDto);
	    }

	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deleteById(@PathVariable Long id) throws PacienteNotFoundException {
	        pacienteService.delete(id);
	    }
}
