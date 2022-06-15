package com.g1generation.services;

import com.g1generation.models.Usuario;
import com.g1generation.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

// Logica de negocios o Validaciones del sistema
// llamar al Repository (inyeccion de dependecia)
@Service
public class UsuarioService {
    // llamar al Repository (inyeccion de dependecia)
    @Autowired
    UsuarioRepository usuarioRepository;
    public void saveUsuario(@Valid Usuario usuario) {

        usuarioRepository.save(usuario);


    }

}