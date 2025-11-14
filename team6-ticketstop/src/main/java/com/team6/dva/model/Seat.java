package com.team6.dva.model;

public class Seat {

    private int seaId;
    private String seatName;
    private int showNo;

    public Seat() {
    }

    public Seat(int seaId, String seatName, int showNo) {
        this.seaId = seaId;
        this.seatName = seatName;
        this.showNo = showNo;
    }

    public int getSeaId() {
        return seaId;
    }

    public void setSeaId(int seaId) {
        this.seaId = seaId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    public int getShowNo() {
        return showNo;
    }

    public void setShowNo(int showNo) {
        this.showNo = showNo;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seaId=" + seaId +
                ", seatName='" + seatName + '\'' +
                ", showNo=" + showNo +
                '}';
    }
}
