package com.team6.dva.model;

public class Payment {
    private String concertId;
    private String title;
    private String concertDate;
    private String seatId;
    private int countSeat;
    private int price;
    private int totalPrice;

    public Payment(String concertId, String title, String concertDate, String seatId, int countSeat, int price) {
        this.concertId = concertId;
        this.title = title;
        this.concertDate = concertDate;
        this.seatId = seatId;
        this.countSeat = countSeat;
        this.price = price;
        this.totalPrice = countSeat * price;
    }

    public String getConcertId() {
        return concertId;
    }

    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(String concertDate) {
        this.concertDate = concertDate;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getCountSeat() {
        return countSeat;
    }

    public void setCountSeat(int countSeat) {
        this.countSeat = countSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
