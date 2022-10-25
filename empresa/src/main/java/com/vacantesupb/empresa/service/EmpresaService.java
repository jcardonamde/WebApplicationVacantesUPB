package com.vacantesupb.empresa.service;

import com.vacantesupb.empresa.model.Empresa;
import com.vacantesupb.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    //Devolver Información
    public ArrayList<Empresa> getAll() {
        //Casteo de la Información
        return (ArrayList<Empresa>) empresaRepository.findAll();
    }

    //Guardar y actualizar
    public Empresa saveOrUpdate(Empresa e) {
        return empresaRepository.save(e);
    }

    //Eliminar
    public void delete(long id) {
        empresaRepository.deleteById(id);
    }

    //Buscar
    public Optional<Empresa> findById(long id) {
        return empresaRepository.findById(id);
    }
}
