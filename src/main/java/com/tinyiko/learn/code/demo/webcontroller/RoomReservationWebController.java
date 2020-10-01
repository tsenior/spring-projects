package com.tinyiko.learn.code.demo.webcontroller;

import com.tinyiko.learn.code.demo.business.domain.RoomReservationDTO;
import com.tinyiko.learn.code.demo.business.service.ReservationService;
import com.tinyiko.learn.code.demo.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/reservations")
public class RoomReservationWebController {
//we first need a way to parse a date to a method - see DateUtils class

    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model){
        Date date = DateUtils.createDateFromDateSting(dateString);
        List<RoomReservationDTO> roomReservations = this.reservationService.getRoomReservationForDate(date);
        model.addAttribute("roomReservations",roomReservations);
        return "reservations";

    }

    /*
    *
    *  @RestController
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
    * */
}
