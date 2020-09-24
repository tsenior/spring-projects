package com.tinyiko.learn.code.demo.data.repository;

import com.tinyiko.learn.code.demo.data.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
