package com.g1generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // como capturamos algun dato que nos quieran pasar
@RequestMapping("/api") // establecer el inicio de ruta por defecto
public class ParametrosRestController {

    //localhost:8080/api?fecha=20220613
    @RequestMapping("/")
    public String fecha(@RequestParam(value = "fecha") String fecha) {

        return "la fecha es: " + fecha;
    }

    //localhost:8080/api/seccion?modulo=3&seccion=5
    @RequestMapping("/seccion")
    //nos permite desde donde vamos a pasar parametros "?", incluir otro parametro "&"
    //signo de pregunta lo ocupamos cuando trabajamos con formularios
    //deben estar los dos parametros
    // rutas con / y parametros con

    public String fecha(@RequestParam(value = "modulo") String modulo,
                        @RequestParam(value = "seccion") String seccion) {

        return "el modulo es: " + modulo +" la seccion es: " + seccion;
    }

    /** rutas con parametros no obligatorios **/

    //localhost:8080/api/date?anio=2022&mes=6&dia=13
    @RequestMapping("/date")
    public String capturarParametros(@RequestParam(value="anio", required = false) String anio,
    @RequestParam(value="mes", required=false) String mes,
    @RequestParam(value="dia", required=false) String dia) {

        //insertar if

        System.out.println("El año es " + anio);
        System.out.println("El mes es "+ mes);
        System.out.println("El dia es "+ dia);

         return "La fecha es " +anio+mes+dia;
    }
}
