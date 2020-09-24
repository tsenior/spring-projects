package com.tinyiko.learn.code.demo.data.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="ROOM")
@Data
public class Room {

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;
    @Column(name="NAME")
    private String roomName;
    @Column(name = "ROOM_NUMBER")
    private String roomNumber;
    @Column(name = "BED_INFO")
    private String bedInfo;
}
