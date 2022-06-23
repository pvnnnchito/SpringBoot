package com.g1generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.g1generation.models.Licencia;
import com.g1generation.models.Usuario;
import com.g1generation.services.LicenciaService;
import com.g1generation.services.UsuarioService;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {

    @Autowired
    LicenciaService licenciaService;
    //Acceder a los metodos de usuarioService
    @Autowired
    UsuarioService usuarioService;
    
    @RequestMapping("") //Ruta vacia para desplegar su jsp
    public String despliegue(Model model){// es otra manera tambien de llamar al objeto
        Licencia licencia = new Licencia ();
        model.addAttribute("licencia", licencia);
        //Lista de usuarios
        List<Usuario> listaUsuarios = usuarioService.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);

        //enviar al jsp lista de Licencias
        List<Licencia> listaLicencias = licenciaService.findAll();
        model.addAttribute("listaLicencias", listaLicencias);
        
        return "licencia.jsp";
    }

    @PostMapping("/guardar")
    public String guardarLicencia(@Valid @ModelAttribute("licencia") Licencia licencia){
        
        licenciaService.save(licencia);
        return "redirect:/licencia";
    }
}
