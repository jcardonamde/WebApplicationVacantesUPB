package com.vacantesupb.empresa.repository;

import com.vacantesupb.empresa.model.Vacante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacanteRepository extends CrudRepository<Vacante,Long> {

}
