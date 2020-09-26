package com.tinyiko.learn.code.demo.data.repository;

import com.tinyiko.learn.code.demo.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {


}
