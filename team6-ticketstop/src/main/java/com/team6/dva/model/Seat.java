package com.team6.dva.model;

public class Seat {

    private int seat_id;
    private String seat_name;
    private int show_no;

    public Seat() {
    }

    public Seat(int seat_id, String seat_name, int show_no) {
        this.seat_id = seat_id;
        this.seat_name = seat_name;
        this.show_no = show_no;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public int getShow_no() {
        return show_no;
    }

    public void setShow_no(int show_no) {
        this.show_no = show_no;
    }
}
