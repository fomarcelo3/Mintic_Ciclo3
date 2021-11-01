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
    public Optional<Reservation> getReservation(int id){
       return reservationRepository.getReservation(id);
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

    public Reservation updateReservation(Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> reservation_bd = reservationRepository.getReservation(reservation.getIdReservation());

            if (!reservation_bd.isEmpty()){
                if (reservation.getStartDate() != null){
                    reservation_bd.get().setStartDate(reservation.getStartDate());
                }

                if (reservation.getDevolutionDate() != null){
                    reservation_bd.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if (reservation.getStatus() != null){
                    reservation_bd.get().setStatus(reservation.getStatus());
                }

                reservationRepository.save(reservation_bd.get());

                return  reservation_bd.get();
            }
        }

        return  reservation;
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
