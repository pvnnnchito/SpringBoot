package com.g1generation.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/var") //localhost:8080/var -> path por default
public class PathVariableRestController {
    /** capturar variables desde la ruta o path **/

    //localhost:8080/var/anio/2022/mes/06/dia/13
    @RequestMapping("/anio/{a}/mes/{m}/dia/{d}")// acceso a distintas rutas
    public String capturarVariablesPath(@PathVariable("a") String anio,
                                        @PathVariable("m") String mes,
                                        @PathVariable("d") String dia) {

        return "La fecha es: " + anio + "/" + mes + "/" + dia;
    }

    @RequestMapping("/fecha/{anio}/{mes}/{dia}")
    public String capVarPathCorto(@PathVariable("anio") String anio,
                                  @PathVariable("mes") String mes,
                                  @PathVariable("dia") String dia){
        return "La fecha es: "+anio+mes+dia;
    }
}
