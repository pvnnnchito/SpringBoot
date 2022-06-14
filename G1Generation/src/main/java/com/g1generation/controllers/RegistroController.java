package com.g1generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registro") //estamos estableciendo parte de la ruta generica, //localhost:8080/registro
public class RegistroController {

    // una ruta para desplegar el jsp, ruta por default
    @RequestMapping("")
    public String registro () {
        return "registro.jsp"; // la pagina a desplegar
    }

    //ruta para capturar los datos del formulario, //localhost:8080/registro/usuario
    @PostMapping("/usuario") // Postmapping es solo para recibir form post, para que no nos entreguen parametros por la url
    public String registroUsuario (@RequestParam(value="gato") String nombre,
                                   @RequestParam(value="apellido") String apellido,
                                   @RequestParam(value="edad") String edad) {
        System.out.println("Parametros gato" + nombre );
        System.out.println("Parametros apellido" + apellido );
        System.out.println("Parametros edad" + edad );

        return "registro.jsp"; //la pagina a deplegar
    }


}
