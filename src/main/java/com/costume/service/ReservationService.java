package com.costume.service;

import com.costume.model.Reservation;
import com.costume.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio entidad Reservation
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
 
    public List<Reservation> getAll(){
       return reservationRepository.getAll();
    }
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationUno = reservationRepository.getReservation(reservation.getIdReservation());
            if (reservationUno.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public boolean deleteReservation(int id){
        Optional<Reservation> reservation  = reservationRepository.getReservation(id);
        if (reservation.isEmpty()){
            return  false;
        }else {
            reservationRepository.delete(reservation.get());
            return  true;
        }
    }
}
