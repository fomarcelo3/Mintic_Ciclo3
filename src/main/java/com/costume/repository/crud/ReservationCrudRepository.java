package com.costume.repository.crud;

import com.costume.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Interfaz repositorio entidad Reservation
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

}
