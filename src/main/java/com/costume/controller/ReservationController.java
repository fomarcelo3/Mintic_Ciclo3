package com.costume.controller;

import com.costume.model.Reservation;
import com.costume.service.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//Contrtolador entidad Reservation
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin("*")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    //Metodo listar  elementos entidad Reservation
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    //Metodo registrar un elemento entidad reservation
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }


    //Metodo para eliminar un elemento de la entidad Reservation
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable int id){
        return  reservationService.deleteReservation(id);
    }
}
