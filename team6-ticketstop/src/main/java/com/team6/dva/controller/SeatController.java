package com.team6.dva.controller;

import com.team6.dva.model.Seat;
import com.team6.dva.service.SeatService;

import java.util.List;

public class SeatController {
    private final SeatService seatService;

    public SeatController() {
        this.seatService = new SeatService();
    }

    public List<Seat> getSeats(int showNo) {
        return seatService.selectSeatsByShowNo(showNo);
    }

    public Seat getSeatByNameAndShowNo(int showNo, String seatName) {
        return seatService.selectSeatByNameAndShowNo(showNo, seatName);
    }
}
