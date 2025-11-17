package com.team6.dva.view;

import com.team6.dva.controller.PaymentController;
import com.team6.dva.controller.SeatController;
import com.team6.dva.controller.AuthController;
import com.team6.dva.model.Concert;
import com.team6.dva.model.Seat;
import com.team6.dva.model.User;
import com.team6.dva.service.ConcertService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentMenu {

    private static final Scanner sc = new Scanner(System.in);
    private final PaymentController paymentController;
    private final ConcertService concertService;
    private final SeatController seatController;

    public PaymentMenu() {
        this.paymentController = new PaymentController();
        this.concertService = new ConcertService();
        this.seatController = new SeatController();
    }

    public boolean showPayment() {
        String menu = """
                ╔════════════════════════════════╗
                             결제 하기
                ╚════════════════════════════════╝
                """;

        System.out.println(menu);

        int showNo = ConcertMenu.selectedShowNo;
        List<String> selectedSeatNames = SeatMenu.selectedSeatNames;
        String memberId = AuthController.id;

        User user = paymentController.getUserInfo(memberId);

        if (user == null) {
            printErrorMessage("noUser");
            return false;
        }

        Concert concert = concertService.selectConcertById(showNo);

        if (concert == null) {
            printErrorMessage("noShow");
            return false;
        }

        List<Integer> seatIds = new ArrayList<>();
        for (String seatName : selectedSeatNames) {
            Seat seat = seatController.getSeatByNameAndShowNo(showNo, seatName);
            if (seat != null) {
                seatIds.add(seat.getSeatId());
            }
        }

        int totalPrice = concert.getPrice() * selectedSeatNames.size();

        System.out.println("================================");
        System.out.println("공연명: " + concert.getShowName());
        System.out.println("선택 좌석: " + selectedSeatNames);
        System.out.println("좌석 수: " + selectedSeatNames.size() + "개");
        System.out.println("좌석당 가격: " + concert.getPrice() + "원");
        System.out.println("총 결제 금액: " + totalPrice + "원");
        System.out.println("현재 예치금: " + user.getBalance() + "원");
        System.out.println("================================");
        System.out.println();

        if (user.getBalance() < totalPrice) {
            printErrorMessage("lessBalance");
            System.out.println("부족 금액: " + (totalPrice - user.getBalance()) + "원");
            System.out.println();
            printSuccessMessage("backMainMenu");
        return false;
        }

        System.out.print("결제하시겠습니까? (Y/N) > ");
        String choice = sc.nextLine().trim().toUpperCase();

        if (choice.equals("Y")) {
            boolean success = paymentController.processPayment(
                              memberId,
                              seatIds,
                              totalPrice
            );

            System.out.println();
            if (success) {
                printSuccessMessage("successPayment");
                System.out.println("예약 좌석: " + selectedSeatNames);
                printSuccessMessage("thankYou");
                return true;
            } else {
                printErrorMessage("failedPayment");
                return false;
            }
        } else {
            printSuccessMessage("cancelPayment");
            return false;
        }
    }

    public static void printErrorMessage(String errorCode) {
        System.out.println("⚠ ERROR! ⚠");
        String errorMessage = switch (errorCode) {
            case "noUser" -> "없는 회원입니다.";
            case "noShow" -> "없는 공연입니다.";
            case "lessBalance" -> "예치금이 부족합니다.";
            case "paymentFailed" -> "결제 처리 중 오류가 발생했습니다.";
            case "failedPayment" -> "결제에 실패했습니다.";
            default -> "오류가 발생했습니다.";
        };
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {
        System.out.println("===== Success =====");
        String successMessage = switch (successCode) {
            case "backMainMenu" -> "메인 메뉴로 돌아갑니다.";
            case "successPayment" -> "결제가 완료되었습니다!";
            case "thankYou" -> "감사합니다";
            case "cancelPayment" -> "결제를 취소합니다.";
            default -> "";
        };
        System.out.println(successMessage);
    }
}