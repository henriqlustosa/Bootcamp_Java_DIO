package br.bootcamp.paciente.mapper;




import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import br.bootcamp.paciente.dto.request.PacienteDto;
import br.bootcamp.paciente.entity.Paciente;



@Mapper
public interface PacienteMapper {
	
	PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

	  
	    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	    Paciente toModel(PacienteDto pacienteDTO);

	    PacienteDto toDTO(Paciente paciente);
	
}
	