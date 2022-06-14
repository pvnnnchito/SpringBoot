package com.g1generation.repositories;

import com.g1generation.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> { //JpaRepository <Objeto, Tipo_de_dato_PK>
    //Las interfaces solo definen los metodos
    // Trabajar con todo lo relacionado a la base de datos
    // Querys y usar metodos que se conecten a la base de datos


}
