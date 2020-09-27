package com.tinyiko.learn.code.demo.business.service;

import com.tinyiko.learn.code.demo.business.domain.RoomReservationDTO;
import com.tinyiko.learn.code.demo.data.entity.Guest;
import com.tinyiko.learn.code.demo.data.entity.Reservation;
import com.tinyiko.learn.code.demo.data.entity.Room;
import com.tinyiko.learn.code.demo.data.repository.GuestRepository;
import com.tinyiko.learn.code.demo.data.repository.ReservationRepository;
import com.tinyiko.learn.code.demo.data.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;



    public List<RoomReservationDTO> getRoomReservationForDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservationDTO> roomReservationDTOMap = new HashMap<>();

        rooms.forEach(room -> {
            RoomReservationDTO roomReservationDTO = new RoomReservationDTO();
            roomReservationDTO.setRoomId(room.getRoomId());
            roomReservationDTO.setRoomName(room.getRoomName());
            roomReservationDTO.setRoomNumber(room.getRoomNumber());

            roomReservationDTOMap.put(room.getRoomId(), roomReservationDTO);
        });

        Iterable<Reservation> reservations = reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservationDTO roomReservationDTO = roomReservationDTOMap.get(reservation.getRoomId());
            roomReservationDTO.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservationDTO.setFirstName(guest.getFirstName());
            roomReservationDTO.setLastName(guest.getLastName());
            roomReservationDTO.setGuestId(guest.getGuestId());
        });
        List<RoomReservationDTO> roomReservations = new ArrayList<>();
        for (Long id: roomReservationDTOMap.keySet()){
            roomReservations.add(roomReservationDTOMap.get(id));
        }
        return roomReservations;
    }
}
