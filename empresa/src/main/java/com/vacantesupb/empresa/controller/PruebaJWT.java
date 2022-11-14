package com.vacantesupb.empresa.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// RestController Hace la llamadas al servidor
@RestController
class PruebaJWT {

    // RequestMapping nos ayuda a habilitar el metodo especifico para acceder el servidor
    @RequestMapping("jwt") //Endpoint
    public String miJWT(@RequestParam(value = "nombre", defaultValue = "UPB") String nombre) {
        return  "Hola " + nombre + "!!";
    }
}