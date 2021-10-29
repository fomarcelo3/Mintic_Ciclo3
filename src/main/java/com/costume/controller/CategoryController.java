package com.costume.controller;

import com.costume.model.Category;
import com.costume.service.CategoryService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de Categorias
 * @author Fredy
 */
@RestController
@RequestMapping("/api/Category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Metodo para obtener todos los registros de la entidad Category
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    //Metodo para obtener un registro de la entidad Category
    @GetMapping("/{id}")
    public Optional<Category> getAdmin(@PathVariable int id){
        return categoryService.getCategory(id);
    }

    //Metodo para registrar un nuevo elemento de la entidad Category
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    //Metodo para actualizar un elemento de la entidad category
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    ////Metodo para eliminar un elemento de la entidad category
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable int id){
        return  categoryService.deleteCategory(id);
    }
}
