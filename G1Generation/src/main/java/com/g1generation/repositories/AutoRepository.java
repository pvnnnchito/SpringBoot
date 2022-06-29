package com.g1generation.repositories;

import com.g1generation.models.Auto;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{
//vamos a trabajar querys desde el respository

    // Hay 2 formas de filtar o buscar con Querys

    //JPQL
    //Usamos el objeto
    @Query("SELECT a FROM Auto a WHERE a.marca = ?1")
    List<Auto> findAllAutoMarca(String marca);
    
    // ? = posición del parametro
    //Query común
    @Query(value = "SELECT * FROM autos a WHERE a.marca = ?1",nativeQuery = true)
    List<Auto> buscarMarca(String marca);

    //Filtro por algunas columnas de la tabla
    @Query(value="SELECT a.marca, a.color FROM autos a WHERE a.marca = ?1 and a.color=?2",nativeQuery = true)
	List<Object[]> buscarMarcaColor(String marca, String color);

    //Join 
    
}
