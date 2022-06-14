package com.g1generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrutamientoRestController {
    //nombre de la clase - apellido
    // seria como http://localhost:8080/
    // cuando solo es el / es la pagina por default
    // pero


    /* ENRUTAMIENTOS */

    @RequestMapping("/usuario") //palabra reservada para crear una nueva ruta
    public String usuario() {
        return "estamos en la url usuario";
    }

    @RequestMapping("/usuario/inscrito")
    public String inscrito() {
        return "estamos en la url inscrito";
    }

    @RequestMapping("/cliente/registrado")
    public String cliente() {
        return "ruta de cliente";
    }

    @RequestMapping(value ="/proveedor/registrado", method = RequestMethod.GET) // otra forma de escribir una ruta
    public String proveedor() {
        return "ruta de proveedor";
    }



}


