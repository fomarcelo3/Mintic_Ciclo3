package com.costume.controller;

import com.costume.model.Message;
import com.costume.service.MessageService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador entidad Message
 * @author Fredy
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin("*")
public class MessageController {
    @Autowired
    private MessageService messageService;

    //Metodo listar elementos entidad Message
    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    //Metodo listar in elemento entidad Message
    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable int id){
        return messageService.getMessage(id);
    }

    //Metodo registrar un elemento entidad Message
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return messageService.save(message);
    }

    //Metodo actualziar un elemento entidad Message
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message updateMessage(@RequestBody Message message){
        return messageService.update(message);
    }

    //Metodo para eliminar un elemento de la entidad Message
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable int id){
        return  messageService.deleteMessage(id);
    }
   
}
