package com.vacantesupb.empresa.controller;

import com.vacantesupb.empresa.model.Empresa;
import com.vacantesupb.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    //Personalizar peticiones
    Map<String, Object> map = new HashMap<>();

    @GetMapping
    private ResponseEntity<ArrayList<Empresa>> getAll() {
        return ResponseEntity.ok(empresaService.getAll());
    }

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

    @PutMapping(path = "/{id}")
    private ResponseEntity<Object> update(@PathVariable("id") long id, @RequestBody Empresa obj) {
        try {
            obj.setId(id);
            obj = empresaService.saveOrUpdate(obj);
            return ResponseEntity.accepted().body(obj);
        } catch (Exception ex) {
            map.put("error", true);
            map.put("mensaje", "No se pudo actualizar la empresa");
            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<Object> findById(@PathVariable("id") long id) {
        ResponseEntity response = ResponseEntity.ok(empresaService.findById(id));
        return response;
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
        ResponseEntity response = ResponseEntity.ok(empresaService.findById(id));
        if(response.toString().contains("Optional.empty")) {
            map.put("error", true);
            map.put("message", "No existe una empresa con id:" + id);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        } else {
            empresaService.delete(id);
            map.put("error", false);
            map.put("message", "La empresa fue eliminada correctamente");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
    }
}
