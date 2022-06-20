package com.g1generation.repositories;

import com.g1generation.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g1generation.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{

}
