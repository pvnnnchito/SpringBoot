package com.g1generation.controllers;

import com.g1generation.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller  // sera nuestra ruta controlador
public class IndexControllers {
        //http://localhost:8080/
        @RequestMapping("/") //anotacion para capturar las rutas
        public String index(Model model) {
            model.addAttribute("Apellidos","Perez Morales");
            model.addAttribute("Nombres","Francisco Javier");
            model.addAttribute("Edad",26);

            //Instancia de usuario
            Usuario usuario = new Usuario("Tom","Delorean",24,"Admin1234");
            //pasando el objeto a la vista (JSP JavaServer Pages)
            model.addAttribute("usuario",usuario);

            return "index.jsp"; //return siempre entre comillas
        }
}