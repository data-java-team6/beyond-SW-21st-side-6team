package com.team6.dva.view;

import com.team6.dva.controller.SeatController;
import com.team6.dva.model.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatMenu {

    private static Scanner sc = new Scanner(System.in);
    private final SeatController seatController;
    private final PaymentMenu paymentMenu;

    public static List<String> selectedSeatNames = new ArrayList<>();

    public SeatMenu(){ this.seatController = new SeatController(); 
        this.paymentMenu = new PaymentMenu(); 
    }

    public void showSeat() {
        String menu = """
                ╔════════════════════════════════╗
                             좌석 선택
                ╚════════════════════════════════╝
                """;
        int showNo = ConcertMenu.selectedShowNo;

        if (showNo <= 0) {
            printErrorMessage("noShow");
            return;
        }

        //selectedSeatNames.clear();

        while (true) {
            System.out.println(menu);
            System.out.println("공연 번호: " + showNo);
            System.out.println();

            displaySeats(showNo);

            String option = """
                
                예약 가능:[좌석 이름]
                예약 완료:[X]
                (최대 5개까지 선택 가능합니다.)
                
                """;
            System.out.println(option);
            System.out.println("현재 선택한 좌석: " + (selectedSeatNames.isEmpty() ? "없음" : selectedSeatNames));
            System.out.println("예약할 좌석을 입력해주세요 (또는 '결제' / '취소') > ");

            String input = sc.nextLine().trim().toUpperCase();

            if (input.equals("취소")) {
                System.out.println("좌석 선택을 취소합니다.");
                selectedSeatNames.clear();
                return;
            }

            if (input.equals("결제")) {
                if (selectedSeatNames.isEmpty()) {
                    System.out.println("선택한 좌석이 없습니다.");
                    continue;
                }

                boolean paymentSuccess = paymentMenu.showPayment();

                if (paymentSuccess) {
                    System.out.println("좌석 예약 및 결제가 완료되었습니다!");
                    selectedSeatNames.clear();
                    return;
                } else {
                    System.out.println("결제가 취소되었습니다. 좌석 선택 화면으로 돌아갑니다.");
                    return;
                }
            }

            if (!isValidSeat(input)) {
                printErrorMessage("invalidSeat");
                continue;
            }

            if (selectedSeatNames.size() >= 5) {
                printErrorMessage("exceededSeats");
                continue;
            }

            if (selectedSeatNames.contains(input)) {
                System.out.println("이미 선택된 좌석입니다.");
                continue;
            }

            Seat seat = seatController.getSeatByNameAndShowNo(showNo, input);

            if (seat == null) {
                printErrorMessage("noSeat");
                continue;
            }

            if (seat.isReserved()) {
                printErrorMessage("reservedSeat");
                continue;
            }

            selectedSeatNames.add(input);
            System.out.println("좌석 [" + input + "]을(를) 선택했습니다.");
            }
        }

    private void displaySeats(int showNo) {
        List<Seat> seats = seatController.getSeats(showNo);

        if (seats == null || seats.isEmpty()) {
            printErrorMessage("noSeats");
            return;
        }

        System.out.println();

        String currentRow = "";

        System.out.println();
        System.out.println(" =====================[ 무  대 ]===================== ");
        System.out.println();
        System.out.println();

        for (Seat seat : seats) {
            String seatName = seat.getSeatName();
            String row = seatName.substring(0, 1);

            if (!row.equals(currentRow)) {
                if (!currentRow.isEmpty()) {
                    System.out.println();
                }
                System.out.print(row + " : ");
                currentRow = row;
            }

            System.out.print(seat.getDisplayName() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println(" =================================================== ");
    }
    private boolean isValidSeat(String seatName) {
        return seatName.matches("^[A-E]([1-9]|10)$");
    }

    public static void printErrorMessage(String errorCode) {
        System.out.println("⚠ ERROR! ⚠");
        String errorMessage = switch (errorCode) {
            case "noShow" -> "공연을 선택하지 않았습니다.";
            case "noSeats" -> "좌성을 불러올 수 없습니다.";
            case "invalidSeat" -> "잘못된 좌석입니다.";
            case "exceededSeats" -> "최대 5개의 좌석만 예약 가능합니다.";
            case "reservedSeat" -> "이미 예약된 좌석입니다.";
            default -> "오류가 발생했습니다.";
        };
        System.out.println(errorMessage);
    }
}
