package com.costume.repository.crud;

import com.costume.model.Costume;
import org.springframework.data.repository.CrudRepository;

public interface CostumeCrudRepository extends CrudRepository<Costume, Integer> {
    
}
