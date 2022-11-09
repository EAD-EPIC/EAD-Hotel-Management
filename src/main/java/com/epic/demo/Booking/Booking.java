package com.epic.demo.Booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    private String name;

    private String roomType;

    private Integer adults;

    private Integer kids;

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date checkIn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkIn;

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private Date checkOut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date checkOut;

    public Booking() {

    }

    public Booking(Long guestId, String name , String roomType , Integer adults, Integer kids , Date checkIn , Date checkOut){
        this.guestId = guestId;
        this.name = name;
        this.roomType = roomType;
        this.adults = adults;
        this.kids = kids;
        this.checkIn = checkIn;
        this.checkOut =checkOut;
    }
    public Booking(String name , String roomType , Integer adults, Integer kids , Date checkIn , Date checkOut){
        this.name = name;
        this.roomType = roomType;
        this.adults = adults;
        this.kids = kids;
        this.checkIn = checkIn;
        this.checkOut =checkOut;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getKids() {
        return kids;
    }

    public void setKids(int kids) {
        this.kids = kids;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

}
