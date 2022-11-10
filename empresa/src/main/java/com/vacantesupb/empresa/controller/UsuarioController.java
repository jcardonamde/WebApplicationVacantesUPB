package com.vacantesupb.empresa.controller;

import com.vacantesupb.empresa.model.UsuarioSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    //Expongo el metodo web Post
    @PostMapping("login")
    //Creo metodo de logueo
    public UsuarioSession loginToken(@RequestParam(value = "usuario") String usuario, @RequestParam(value = "contrasena") String contrasena) {
        String token = "sdsdsajdkajdksjakdja";

        //Creo un nuevo objeto usuario sesión
        UsuarioSession us = new UsuarioSession();
        us.setIdUsuario("10376136678798");
        us.setNombre("Jonathan Cardona");
        us.setCorreo("yoto@upb.edu.co");
        us.setToken(token);
        return us;
    }
}
