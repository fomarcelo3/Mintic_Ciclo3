package com.costume.controller;

import com.costume.model.Admin;
import com.costume.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//clase controlador de la entidad Aadmin
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    //instacia clase servicio
    private AdminService adminService;

    //metodo para obtener todos los registros de la entidad admin
    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    //Metodo para registrar un nuevo elemento de la entidad Admin
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin category){
        return adminService.save(category);
    }


    //Metodo para actualizar un elemento de la entidad Admin
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@RequestBody Admin category){
        return adminService.updateAdmin(category);
    }

    //Metodo para eliminar un elemento de la entidad Admin
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable int id){
        return  adminService.deleteAdmin(id);
    }
}
