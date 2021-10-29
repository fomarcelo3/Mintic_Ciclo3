package com.costume.repository.crud;

import com.costume.model.Score;
import org.springframework.data.repository.CrudRepository;

//Interfaz repositorio entidad Score
public interface ScoreCrudRepository extends CrudRepository<Score,Integer> {

}
