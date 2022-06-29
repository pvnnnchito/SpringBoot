package com.g1generation.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.g1generation.models.Auto;
import com.g1generation.repositories.AutoRepository;

@Service
@Transactional
public class AutoService {
	@Autowired
	AutoRepository autoRepository;

	//guardar un auto 
	public void guardarAuto(@Valid Auto auto) {
		autoRepository.save(auto);
		
	}
	/**obtener una lista de autos**/
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

    public List<Auto> buscarMarca(String marca) {
		//llamar a un metodo propio
		//no es parte del CRUD
		//por lo que lo creamos en el repository
        //return autoRepository.buscarMarca(marca); --> QUERY TRADICIONAL 
		return autoRepository.findAllAutoMarca(marca);// --> QUERY OBJETO 
    }

	//PAGINACIÓN
	//1° Variable estatica - queda fija y no va a cambiar en nada, cantidad de datos/elementos a mostrar por paginas
	private static final int TAMANIOPAGINA = 5; 

	public Page<Auto> paginarAutos(int numeroPagina){
		PageRequest pageRequest = PageRequest.of(numeroPagina, TAMANIOPAGINA,Sort.Direction.DESC,"velocidad");
		//Page<Auto> autos = autoRepository.findAll(pageRequest);
		return autoRepository.findAll(pageRequest);
	}
}
