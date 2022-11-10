package com.vacantesupb.empresa.controller;

import com.vacantesupb.empresa.model.Usuario;
import com.vacantesupb.empresa.model.UsuarioSession;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    //Expongo el metodo web Post
    //@PostMapping("login")
    //Creo metodo de logueo usando la consulta tipo form generico
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


    @PostMapping("login")
    //Creo metodo de logueo usando la consulta de Tipo JSON
    public UsuarioSession loginToken2(@RequestBody Usuario usr) {
        String token = "sdsdsajdkajdksjakdja";
        //Creo un nuevo objeto usuario sesión
        String user = usr.getUsuario();
        String pwd = usr.getContrasena();

        UsuarioSession us = new UsuarioSession();
        us.setIdUsuario("41402563");
        us.setUsuario(us.getUsuario());
        us.setNombre("Jonathan Cardona C");
        us.setCorreo("yoto@upb.edu.co");
        us.setToken(token);
        return us;
    }
}
