package com.team6.dva.view;

import com.team6.dva.controller.ConcertController;
import com.team6.dva.model.Concert;
import com.team6.dva.model.Seat;
import com.team6.dva.model.User;

import java.util.List;
import java.util.Scanner;

public class ConcertMenu {

    private final ConcertController concertController;
    private final SeatMenu seatMenu;

    static Scanner sc = new Scanner(System.in);
    public static int selectedShowNo;

    public ConcertMenu() {this.concertController = new ConcertController();
    this.seatMenu = new SeatMenu();}

    public void showConcertList(User loginUser) {
        String menu = """
                ╔════════════════════════════════╗
                                                  
                        밴드 / 가수 공연보기        
                                                  
                ╚════════════════════════════════╝
                """;
        while (true) {
            System.out.println(menu);
            concertController.selectAllConcerts();
            System.out.println();

            System.out.println("원하는 공연 명을 입력해주세요 > ");
            String selectedShowName = sc.nextLine().trim();

            Concert concert = concertController.selectConcertByShowName(selectedShowName);

            if (concert == null) {
                printErrorMessage("noShow");
                System.out.println();
                continue;
            }

            selectedShowNo = concert.getShowNo();
            boolean exit = true;
            while (exit) {
                System.out.println();
                System.out.println("결제 하시겠습니까? (Y/N) > ");
                String answer = sc.nextLine().trim().toUpperCase();

                switch (answer) {
                    case "Y": SeatMenu seatMenu = new SeatMenu(); seatMenu.showSeat(); return;
                    case "N": printInfoMessage("backShowList"); exit = false; break;
                    default:
                        printErrorMessage("wrongInput"); break;
                }
            }
            System.out.println();
        }
    }
    public static void printConcertList(List<Concert> concertList) {
        for (Concert concert : concertList) {
            System.out.println(concert.getShowName() + "   " + concert.getShowDate());
        }
    }

    public static void printConcert(Concert concert) {
        System.out.println(
                            "\n" + "공연명 : " + concert.getShowName() +
                            "\n" + "공연날짜 : " + concert.getShowDate() +
                            "\n" + "공연 내용 : " + concert.getShowInfo() +
                            "\n" + "공연 예약 가능 기간 : " + concert.getPayStart() + " ~ " + concert.getPayEnd() +
                            "\n" + "공연 가격 : " + concert.getPrice()
        );
    }

    public static void printErrorMessage(String errorCode) {
        System.out.println("⚠ ERROR! ⚠");
        String errorMessage = switch (errorCode) {
            case "selectList" -> "공연 목록 조회에 실패했습니다.";
            case "noShow" -> "없는 공연입니다.";
            case "wrongInput" -> "잘못된 입력입니다. 다시 입력해주세요.";
            case "noSelect" -> "조회할 내용이 없습니다.";
            default -> "오류가 발생했습니다.";
        };
        System.out.println(errorMessage);
    }

//    public void printSuccessMessage(String successCode) {
//        System.out.println("===== Success! =====");
//        String successMessage = switch (successCode) {
//            case "backShowList" -> "공연 목록으로 돌아갑니다.";
//            default -> "";
//        };
//        System.out.println(successMessage);
//    }
    public void printInfoMessage(String infoCode) {
        String successMessage = switch (infoCode) {
            case "backShowList" -> "공연 목록으로 돌아갑니다.";
            default -> "";
        };
        System.out.println(successMessage);
    }
}