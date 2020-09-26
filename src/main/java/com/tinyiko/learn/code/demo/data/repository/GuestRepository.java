package com.tinyiko.learn.code.demo.data.repository;

import com.tinyiko.learn.code.demo.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
