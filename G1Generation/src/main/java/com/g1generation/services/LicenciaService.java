package com.g1generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g1generation.models.Licencia;
import com.g1generation.repositories.LicenciaRepository;

@Service
public class LicenciaService {

    @Autowired
    LicenciaRepository licenciaRepository;

    // almacenar en base de datos la licencia
    public void save(@Valid Licencia licencia) {
        licenciaRepository.save(licencia);
    }

    // retorno de la lista de licencias
    public List<Licencia> findAll() {
        return licenciaRepository.findAll();
    }

}
