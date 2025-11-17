package com.team6.dva.controller;

import com.team6.dva.model.Payment;
import com.team6.dva.model.User;
import com.team6.dva.service.PaymentService;
import com.team6.dva.service.SeatService;

import java.util.List;

public class PaymentController {

    private final PaymentService paymentService;
    private final SeatService seatService;

    public PaymentController() {this.paymentService = new PaymentService(); this.seatService = new SeatService();}

    public User getUserInfo(String memberId) {return paymentService.getUserById(memberId);}

    public boolean processPayment(String memberId, List<Integer> seatIds, int totalPrice) {

        User user = paymentService.getUserById(memberId);

        if (user == null) {
            System.out.println("회원 정보를 찾을 수 없습니다.");
            return false;
        }

        if (user.getBalance() < totalPrice) {
            System.out.println("예치금이 부족합니다.");
            return false;
        }

        boolean seatReserved = seatService.reserveSeats(seatIds);

        if (!seatReserved) {
            System.out.println("좌석 예약에 실패했습니다.");
            return false;
        }

        boolean paymentSuccess = paymentService.processPayments(
                user.getMemberNo(),
                seatIds,
                totalPrice,
                memberId
        );

        if (paymentSuccess) {
            System.out.println("결제가 완료되었습니다!");
            System.out.println("남은 예치금: " + (user.getBalance() - totalPrice) + "원");
            return true;
        } else {
            System.out.println("결제 처리 중 오류가 발생했습니다.");
            return false;
        }
    }
}