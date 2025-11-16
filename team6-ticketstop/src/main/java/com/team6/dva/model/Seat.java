package com.team6.dva.model;

public class Seat {
    private int seatId;
    private String seatName;
    private int showNo;
    private boolean isReserved;

    public Seat() {
    }

    public Seat(int seatId, String seatName, int showNo, boolean isReserved) {
        this.seatId = seatId;
        this.seatName = seatName;
        this.showNo = showNo;
        this.isReserved = isReserved;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
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

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatName='" + seatName + '\'' +
                ", showNo=" + showNo +
                ", isReserved=" + isReserved +
                '}';
    }

    public String getDisplayName() {
        return isReserved == true ? "[X]" : "[" + seatName + "]";
    }
}

