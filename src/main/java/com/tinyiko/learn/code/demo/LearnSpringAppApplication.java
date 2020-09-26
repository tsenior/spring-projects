package com.tinyiko.learn.code.demo;

import com.tinyiko.learn.code.demo.data.entity.Guest;
import com.tinyiko.learn.code.demo.data.entity.Reservation;
import com.tinyiko.learn.code.demo.data.entity.Room;
import com.tinyiko.learn.code.demo.data.repository.GuestRepository;
import com.tinyiko.learn.code.demo.data.repository.ReservationRepository;
import com.tinyiko.learn.code.demo.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearnSpringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringAppApplication.class, args);
    }

    @RestController
    @RequestMapping("/rooms/")
    public class RoomController{
        @Autowired
        private RoomRepository roomRepository;

        @GetMapping
        public Iterable<Room> getRooms(){
            return this.roomRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/guests/")
    public class GuestController{
        @Autowired
        private GuestRepository guestRepository;

        @GetMapping
        public Iterable<Guest> getGuests(){
            return this.guestRepository.findAll();
        }
    }

    @RestController
    @RequestMapping("/reservations/")
    public class ReservationController{
        @Autowired
        private ReservationRepository reservationRepository;

        @GetMapping
        public Iterable<Reservation> getReservations(){
            return this.reservationRepository.findAll();
        }
    }
}
