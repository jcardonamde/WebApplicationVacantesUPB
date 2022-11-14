package com.vacantesupb.empresa.controller;

import com.vacantesupb.empresa.model.Usuario;
import com.vacantesupb.empresa.model.UsuarioSession;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    //Expongo el metodo web Post
    //@PostMapping("login")
    //Creo metodo de logueo usando la consulta tipo form generico
    public UsuarioSession loginToken(@RequestParam(value = "usuario") String usuario, @RequestParam(value = "contrasena") String contrasena) {
        String token = "qwertyuioasdfghjk456123";
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
        //String token = "qwertyuioasdfghjk456123";
        //Creo un nuevo objeto usuario sesión
        String token = getJWTToken(usr.getUsuario());
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

    private String getJWTToken(String usuario) {
        // Se define el tiempo que va durar la sesión
        int minutos = 1;
        int duracion = minutos * 60 * 1000;
        String claveSecreta = "myClave1900upb2112";

        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                //Libreria que permite generar rol anonimo para accesos
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("myId4578966413555")
                .setSubject(usuario)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList())
                )
                //Fecha cuando se creo y expira el Token
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+duracion))
                .signWith(SignatureAlgorithm.HS512,
                        claveSecreta.getBytes()).compact();
        return token;
    }
}