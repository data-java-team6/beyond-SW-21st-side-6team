package com.team6.dva.model;

public class Payment {

    private int memberNo;
    private int seatId;
    private int totalPrice;

    // ★ 조회용 필드 추가
    private String showName;
    private String showDate;
    private String seatName;

    public Payment() {}

    public Payment(int memberNo, int seatId, int totalPrice) {
        this.memberNo = memberNo;
        this.seatId = seatId;
        this.totalPrice = totalPrice;
    }

    // --- getter / setter 원래 있던 거 + 아래 3개 추가 ---

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "memberNo=" + memberNo +
                ", seatId=" + seatId +
                ", totalPrice=" + totalPrice +
                ", showName='" + showName + '\'' +
                ", showDate='" + showDate + '\'' +
                ", seatName='" + seatName + '\'' +
                '}';
    }

}
