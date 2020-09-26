package com.tinyiko.learn.code.demo.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private long reservationId;

    @Column(name = "ROOM_ID ")
    private long roomId;
    @Column(name = "GUEST_ID")
    private long guestId;
    @Column(name = "RES_DATE")
    private Date reservationId;
}
