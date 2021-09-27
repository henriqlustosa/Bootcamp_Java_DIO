package br.bootcamp.paciente.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.bootcamp.paciente.dto.request.PacienteDto;
import br.bootcamp.paciente.dto.response.MessageResponseDto;
import br.bootcamp.paciente.entity.Paciente;
import br.bootcamp.paciente.exception.PacienteNotFoundException;
import br.bootcamp.paciente.mapper.PacienteMapper;
import br.bootcamp.paciente.repository.PacienteRepository;




@Service
public class PacienteService {
	
	
		@Autowired
	  	private PacienteRepository pacienteRepository;
	
		ModelMapper pacienteMapper = new ModelMapper();
		
		
	    public MessageResponseDto createPaciente(PacienteDto pacienteDto) {
	    	
	    	Paciente pacienteToSave = pacienteMapper.map(pacienteDto,Paciente.class);

	        Paciente savedPerson = pacienteRepository.save(pacienteToSave);
	        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
	    }

	    
	    
	    
	    public List<PacienteDto> listAll() {
	        List<Paciente> allPeople = pacienteRepository.findAll();
	        return allPeople.stream()
	        		.map(t -> pacienteMapper.map(t, PacienteDto.class))
	                .collect(Collectors.toList());
	    }

	    public PacienteDto findById(Long id) throws PacienteNotFoundException {
	        Paciente paciente = verifyIfExists(id);

	        return pacienteMapper.map(paciente, PacienteDto.class);
	    }

	    public void delete(Long id) throws PacienteNotFoundException {
	        verifyIfExists(id);
	        pacienteRepository.deleteById(id);
	    }

	    public MessageResponseDto updateById(Long id, PacienteDto pacienteDto) throws PacienteNotFoundException {
	        verifyIfExists(id);

	        Paciente personToUpdate =  pacienteMapper.map(pacienteDto, Paciente.class);

	        Paciente updatedPerson = pacienteRepository.save(personToUpdate);
	        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
	    }

	    private Paciente verifyIfExists(Long id) throws PacienteNotFoundException {
	        return pacienteRepository.findById(id)
	                .orElseThrow(() -> new PacienteNotFoundException(id));
	    }

	    private MessageResponseDto createMessageResponse(Long id, String message) {
	        return MessageResponseDto
	                .builder()
	                .message(message + id)
	                .build();
	    }

}
