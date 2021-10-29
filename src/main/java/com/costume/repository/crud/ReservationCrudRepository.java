package com.costume.repository.crud;

import com.costume.model.Reservation;
import org.springframework.data.repository.CrudRepository;

//Interfaz repositorio entidad Reservation
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

}
