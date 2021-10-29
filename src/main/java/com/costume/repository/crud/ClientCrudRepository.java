package com.costume.repository.crud;

import com.costume.model.Client;
import org.springframework.data.repository.CrudRepository;

//Interfaz repositorio de la entidad Client
public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
}
