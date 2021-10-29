package com.costume.repository.crud;

import com.costume.model.Category;
import org.springframework.data.repository.CrudRepository;

//interfaz repositoria de la entidad Category
public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}
