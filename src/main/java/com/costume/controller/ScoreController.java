package com.costume.controller;

import com.costume.model.Score;
import com.costume.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Contrtolador entidad Score
@RestController
@RequestMapping("/api/Score")
@CrossOrigin("*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    //Metodo listar  elementos entidad Score
    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    //Metodo registrar un elemento entidad Score
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return  scoreService.save(score);
    }

    //Metodo para eliminar un elemento de la entidad Score
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteScore(@PathVariable int id){
        return  scoreService.deleteScore(id);
    }
}
