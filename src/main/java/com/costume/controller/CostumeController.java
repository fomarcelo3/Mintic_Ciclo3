package com.costume.controller;

import com.costume.model.Costume;
import com.costume.service.CostumeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador entidad Costume
 * @author Fredy
 */

@RestController
@RequestMapping("/api/Costume")
@CrossOrigin("*")
public class CostumeController {
    @Autowired
    private CostumeService costumeService;
    
    @GetMapping("/all")
    public List<Costume> getAll(){
        return costumeService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume){
        return costumeService.save(costume);
    }

    //Metodo para eliminar un elemento de la entidad Costume
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCostume(@PathVariable int id){
        return  costumeService.deleteCostume(id);
    }

    //metodo para actualizar un elemneto de  la entidad Costume
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume updateCostume(@RequestBody Costume costume){
        return  costumeService.update(costume);
    }

}
