package com.g1generation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g1generation.models.Auto;
import com.g1generation.services.AutoService;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class ApiRestController {
    //Instancia de clase, creamos un objeto y accedemos a sus atributos 
    @Autowired //inyeccion de dependencia, estamos trayendo una clase para utilizar lo metodos de ella para usarla internamente
    AutoService autoService;

    @RequestMapping("/obtener/auto")//
    //tenemos que explicar o especificar el tipo de dato que vamos a retornar 
    // (Por ej, public List<Auto>, public String, public Integer)
    // Importamos porque no existe en este package
    public List<Auto> obtenerListaAutos(){
        List<Auto> listaAutos = autoService.findAll();
        return listaAutos;
        
        
    }

    //API (JSON) JavaScript Object Notation (JSON) es un formato basado en texto estándar para representar datos estructurados en
    // la sintaxis de objetos de JavaScript.
    /*Disponibilizar informacion para que sea consumida por cualquier usuario*/


}
