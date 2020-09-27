package com.tinyiko.learn.code.demo.data.repository;

import com.tinyiko.learn.code.demo.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    Iterable<Reservation> findReservationByReservationDate(Date date);


}
