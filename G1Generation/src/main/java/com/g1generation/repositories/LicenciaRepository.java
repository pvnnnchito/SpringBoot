package com.g1generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1generation.models.Licencia;

@Repository
public interface LicenciaRepository extends JpaRepository <Licencia, Long> {
    
}
