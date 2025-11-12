package com.team6.dva.model;

public class Payment {

    private int member_no;
    private int seat_id;
    private int total_price;

    public Payment() {
    }

    public Payment(int member_no, int seat_id, int total_price) {
        this.member_no = member_no;
        this.seat_id = seat_id;
        this.total_price = total_price;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
}
