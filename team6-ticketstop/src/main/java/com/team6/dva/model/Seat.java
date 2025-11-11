package com.team6.dva.model;

public class Seat {
    private String seatId;
    private String concertId;
    private String seatNumber;
    private int price;
    private boolean isReserved;

    public Seat(String seatId, String concertId, String seatNumber, int price) {
        this.seatId = seatId;
        this.concertId = concertId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isReserved = false;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getConcertId() {
        return concertId;
    }

    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
