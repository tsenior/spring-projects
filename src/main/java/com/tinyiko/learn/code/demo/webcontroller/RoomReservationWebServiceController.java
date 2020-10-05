package com.tinyiko.learn.code.demo.webcontroller;

import com.tinyiko.learn.code.demo.business.domain.RoomReservationDTO;
import com.tinyiko.learn.code.demo.business.service.ReservationService;
import com.tinyiko.learn.code.demo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class RoomReservationWebServiceController {

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebServiceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservationDTO> getRoomReservations(@RequestParam(name = "date", required = false)String dateString){
        Date date = DateUtils.createDateFromDateSting(dateString);
        return this.reservationService.getRoomReservationForDate(date);
    }
}
