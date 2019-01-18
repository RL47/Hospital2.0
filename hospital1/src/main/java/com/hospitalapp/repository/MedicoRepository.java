package com.hospitalapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.hospitalapp.models.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String> {

Medico findByCodigo(long codigo);
	
}
