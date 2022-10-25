package com.vacantesupb.empresa.controller;

import com.vacantesupb.empresa.model.Empresa;
import com.vacantesupb.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    //Personalizar peticiones
    Map<String, Object> map = new HashMap<>();

    @PostMapping
    private ResponseEntity<Object> save(@RequestBody Empresa obj) {
        try {
            //Guardando empresa y a la vez almacenandola en una variable temporal
            obj = empresaService.saveOrUpdate(obj);
            return ResponseEntity.created(new URI("/api/empresas/"+obj.getId())).body(obj);
        } catch (Exception ex) {
            map.put("error", true);
            map.put("mensaje", "No se pudo crear la empresa");
            return new ResponseEntity<Object>(map, HttpStatus.CONFLICT);
        }
    }
}
