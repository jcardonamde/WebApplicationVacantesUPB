package com.vacantesupb.empresa.service;

import com.vacantesupb.empresa.model.Vacante;
import com.vacantesupb.empresa.repository.VacanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VacanteService {

    @Autowired
    private VacanteRepository vacanteRepository;

    //Devolver Información
    public ArrayList<Vacante> getAll() {
        //Casteo de la Información
        return (ArrayList<Vacante>) vacanteRepository.findAll();
    }

    //Guardar y actualizar
    public Vacante saveOrUpdate(Vacante e) {
        return vacanteRepository.save(e);
    }

    //Eliminar
    public void delete(long id) {
        vacanteRepository.deleteById(id);
    }

    //Buscar
    public Optional<Vacante> findById(long id) {
        return vacanteRepository.findById(id);
    }

}
