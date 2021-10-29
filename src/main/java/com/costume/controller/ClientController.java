package com.costume.controller;

import com.costume.model.Client;
import com.costume.service.ClientService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador de la entidad Client
 * @author Fredy
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    //Metodo listar elementos entidad Client
    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    //Metodo listar un elemento entidad Client
    @GetMapping("/{id}")
    public Optional<Client> getClient(int id){
        return clientService.getClient(id);
    }

    //Metodo registrar un elemento entidad Client
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    //Metodo para actualizar un elemento de la entidad Client
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  Client updateClient(@RequestBody Client client){
        return  clientService.updateClient(client);
    }

    //Metodo para eliminar un elemento de la entidad Client
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable int id){
        return  clientService.deleteClient(id);
    }
}
