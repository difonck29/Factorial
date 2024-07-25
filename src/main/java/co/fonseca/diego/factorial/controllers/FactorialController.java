package co.fonseca.diego.factorial.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.fonseca.diego.factorial.services.FactorialService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Clase encargada de saludar al equipo de desarrollo y de calcular factorial
 */
@RestController
@RequestMapping("/api")
public class FactorialController {

    @Autowired
    FactorialService factorialService;

    @GetMapping("/hola")
    public Map obtenerNombreEquipo(){
        Map<String,String> mensaje = new HashMap<>();
        mensaje.put("saludo", "Hola equipo Java");
        return mensaje;
    }

    @GetMapping("/factorial/{numero}")
    public Map getMethodName(@PathVariable(name = "numero") long numero) {
        long factorial = factorialService.calcularFactorial(numero);
        Map<String,String> resultado = new HashMap<>();
        resultado.put("factorial", String.valueOf(factorial));
        return resultado;
    }
    

}
