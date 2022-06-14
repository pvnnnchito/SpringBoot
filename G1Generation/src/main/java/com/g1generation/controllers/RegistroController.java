package com.g1generation.controllers;

import com.g1generation.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/registro") //estamos estableciendo parte de la ruta generica, //localhost:8080/registro
public class RegistroController {

    // una ruta para desplegar el jsp, ruta por default
    @RequestMapping("")
    public String registro (@ModelAttribute("usuario") Usuario usuario) {
        //Se crea variable, tipo Usuario, estamos pasando un objeto vacio desde el controlador hacia el jsp
        //pasamos el objeto usuario vacio
        return "registro.jsp"; // la pagina a desplegar
    }

    //ruta para capturar los datos del formulario, //localhost:8080/registro/usuario
    @PostMapping("/usuario/respaldo") // Postmapping es solo para recibir form post, para que no nos entreguen parametros por la url
    public String registroUsuario (@RequestParam(value="gato") String nombre,
                                   @RequestParam(value="apellido") String apellido,
                                   @RequestParam(value="edad") String edad) {
        System.out.println("Parametros gato" + nombre );
        System.out.println("Parametros apellido" + apellido );
        System.out.println("Parametros edad" + edad );

        return "registro.jsp"; //la pagina a deplegar
    }
    @PostMapping("/usuario")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                 BindingResult resultado, Model model) {
        //Despues del Valid, al final se pone una coma con BindingResult
        //capturamos el objeto con los atributos llenos

        if(resultado.hasErrors()) { // capturando si hay error en el ingreso de datos desde el jsp
            model.addAttribute("msgError", "Debe realizar ingreso correcto de los datos");
           return "registro.jsp"; // si hay un error la enviamos de vuelta a la pag de registro
        }

        System.out.println(usuario.getNombre()+" "+usuario.getApellidos()+" "+usuario.getEdad());
        return "index.jsp"; // la pagina a desplegar
    }
}
