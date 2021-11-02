package com.costume.service;

import com.costume.model.Report.CountClient;
import com.costume.model.Report.StatusAmount;
import com.costume.model.Reservation;
import com.costume.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//Servicio entidad Reservation
public class ReservationService {

    @Autowired
    //Instancia clase repositorio
    private ReservationRepository reservationRepository;

    //metodo para obtener todos los registros de la tabla
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    //metodo para obtener un registro de la tabla por id
    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    //metodo para registrar un nuevo elemento en la tabla
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

    //metodo para actualizar un registro
    public Reservation updateReservation(Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> reservationBd = reservationRepository.getReservation(reservation.getIdReservation());

            if (!reservationBd.isEmpty()){
                if (reservation.getStartDate() != null){
                    reservationBd.get().setStartDate(reservation.getStartDate());
                }

                if (reservation.getDevolutionDate() != null){
                    reservationBd.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if (reservation.getStatus() != null){
                    reservationBd.get().setStatus(reservation.getStatus());
                }

                reservationRepository.save(reservationBd.get());

                return  reservationBd.get();
            }
        }

        return  reservation;
    }

    //metodo para eliminar un registro
    public boolean deleteReservation(int idReservation){
        //consultamos elemento en bd
        Optional<Reservation> reservation  = reservationRepository.getReservation(idReservation);
        //validamos si existe
        if (reservation.isEmpty()){
            return  false;
        }else {
            //si existe lo eliminamos
            reservationRepository.delete(reservation.get());
            return  true;
        }
    }

    //metodo para obtener reservas por fecha
    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }

    //metodo para obtener reservaas por estado
    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationsByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }

    //metodo para obtener los clientes con mayor reservas
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

}
