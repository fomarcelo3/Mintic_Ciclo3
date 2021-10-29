package com.costume.repository.crud;

import com.costume.model.Message;
import org.springframework.data.repository.CrudRepository;


//Interfaz repositorio entidad message
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
