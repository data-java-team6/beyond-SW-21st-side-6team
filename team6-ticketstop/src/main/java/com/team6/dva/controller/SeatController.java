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

    public boolean reserveSeat(int showNo, String seatName) {
        Seat seat = seatService.selectSeatByNameAndShowNo(showNo, seatName);
        if (seat == null) {
            System.out.println("존재하지 않는 좌석입니다.");
            return false;
        }
        if (seat.isReserved()) {
            System.out.println("이미 예약된 좌석입니다.");
            return false;
        }

        boolean success = seatService.reserveSeat(seat.getSeatId());

        if (success) {
            System.out.println("좌석 [" + seatName + "] 예약이 완료되었습니다.");
        } else {
            System.out.println("예약 처리 중 오류가 발생했습니다.");
            return false;
        }
        return true;
    }
}
