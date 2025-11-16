package com.team6.dva.view;

import com.team6.dva.controller.SeatController;
import com.team6.dva.model.Seat;

import java.util.List;
import java.util.Scanner;

public class SeatMenu {

    private final Scanner sc = new Scanner(System.in);
    private final SeatController seatController;

    public SeatMenu(){
        this.seatController = new SeatController();
    }

    public void showSeat() {
        String menu = """
                ╔════════════════════════════════╗

                             좌석 선택

                ╚════════════════════════════════╝
                """;
        int showNo = ConcertMenu.selectedShowNo;
        // String showName = ConcertMenu.selectedShowName;

        if (showNo <= 0) {
            System.out.println("공연이 선택되지 않았습니다.");
            return;
        }

        while (true) {
            System.out.println(menu);
            System.out.println("공연 번호: " + showNo);
            System.out.println();
            displaySeats(showNo);
            System.out.println();

            String option = """

                예약 가능:[좌석 이름]
                예약 완료:[X]
                """;
            System.out.println(option);
            System.out.println("예약할 좌석을 입력해주세요 (또는 '취소') > ");

            String input = sc.nextLine().trim().toUpperCase();

            if (input.equals("취소")) {
                System.out.println("좌석 선택을 취소합니다.");
                return;
            }

            if (!isValidSeat(input)) {
                System.out.println("좔못된 좌석입니다.");
                continue;
            }

            boolean success = seatController.reserveSeat(showNo, input);

            System.out.println();
            if (success) {
                System.out.print("계속 예약하시겠습니까? (Y/N) > ");
                String choice = sc.nextLine().trim().toUpperCase();

                if (choice.equals("N")) {
                    System.out.println("좌석 선택을 종료합니다.");
                    return;
                }
            }
        }
    }

    private void displaySeats(int showNo) {
        List<Seat> seats = seatController.getSeats(showNo);

        if (seats == null || seats.isEmpty()) {
            System.out.println("좌석 정보를 불러올 수 없습니다.");
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
    }
    private boolean isValidSeat(String seatName) {
        return seatName.matches("^[A-E]([1-9]|10)$");
    }
}
