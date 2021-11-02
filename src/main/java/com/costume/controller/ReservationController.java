package com.costume.controller;

import com.costume.model.Report.CountClient;
import com.costume.model.Report.StatusAmount;
import com.costume.model.Reservation;
import com.costume.service.ReservationService;
import java.util.List;
import java.util.Optional;

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

    //Metodo listar  un elemento entidad Reservation
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable int id){
        return reservationService.getReservation(id);
    }

    //Metodo registrar un elemento entidad reservation
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    //Metodo registrar un elemento entidad reservation
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }


    //Metodo para eliminar un elemento de la entidad Reservation
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable int id){
        return  reservationService.deleteReservation(id);
    }

    //Metodo para reporte de reservas por fecha
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return reservationService.getReservationsPeriod(dateOne,dateTwo);
    }

    //metodo de reporte de reservas por estado
    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return reservationService.getReservationsStatusReport();
    }

    //metodp de reporte de clientes con mas reservas
    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return reservationService.getTopClients();
    }
}
