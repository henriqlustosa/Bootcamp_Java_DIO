package br.bootcamp.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.bootcamp.paciente.entity.Paciente;



public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}