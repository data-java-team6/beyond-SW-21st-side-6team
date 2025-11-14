package com.team6.dva.model;

public class Payment {

    private int memberNo;
    private int seatId;
    private int totalPrice;

    public Payment() {
    }

    public Payment(int memberNo, int seatId, int totalPrice) {
        this.memberNo = memberNo;
        this.seatId = seatId;
        this.totalPrice = totalPrice;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "memberNo=" + memberNo +
                ", seatId=" + seatId +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
