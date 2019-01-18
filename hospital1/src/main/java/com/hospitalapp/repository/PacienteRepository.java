package com.hospitalapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.hospitalapp.models.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String> {

	Paciente findByCodigo(long codigo);
}
