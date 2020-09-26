package com.tinyiko.learn.code.demo.business.domain;

import lombok.Data;

import java.util.Date;


@Data
public class RoomReservationDTO {
    private long roomId;
    private  long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private Date date;
}
