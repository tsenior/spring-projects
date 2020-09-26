package com.tinyiko.learn.code.demo.business.service;

import com.tinyiko.learn.code.demo.business.domain.RoomReservationDTO;
import com.tinyiko.learn.code.demo.data.repository.GuestRepository;
import com.tinyiko.learn.code.demo.data.repository.ReservationRepository;
import com.tinyiko.learn.code.demo.data.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;



    public List<RoomReservationDTO> getRoomReservationForDate(Date date){
        return null;
    }
}
