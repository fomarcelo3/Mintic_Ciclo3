package com.costume.repository.crud;

import com.costume.model.Costume;
import org.springframework.data.repository.CrudRepository;

//Interfaz repositorio de la entidad Costume
public interface CostumeCrudRepository extends CrudRepository<Costume, Integer> {
    
}
