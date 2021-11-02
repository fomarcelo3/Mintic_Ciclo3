package com.costume.repository.crud;

import com.costume.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

//Interfaz repositorio entidad Reservation
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo );

    public List<Reservation> findAllByStatus(String status);
}
