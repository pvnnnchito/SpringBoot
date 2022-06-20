package com.g1generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1generation.models.Auto;
import com.g1generation.repositories.AutoRepository;

@Service
public class AutoService {
	@Autowired
	AutoRepository autoRepository;

	//guardar un auto 
	public void guardarAuto(@Valid Auto auto) {
		autoRepository.save(auto);
		
	}
	//obtener una lista de autos
	public List<Auto> findAll() {
		
		return autoRepository.findAll();
	}

	public Auto buscarId(Long id) {
		return autoRepository.findById(id).get();
		//.findById
		//.get() especifica el tipo de dato que necesitamos
		//nos va a retornar especificamente un solo auto
	}

	public void eliminarPorId(Long id) {
		autoRepository.deleteById(id);
	}
}
