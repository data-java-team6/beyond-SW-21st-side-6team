package com.team6.dva.view;

import com.team6.dva.controller.ConcertController;
import com.team6.dva.model.Concert;

import java.util.List;
import java.util.Scanner;

public class ConcertMenu {

    private final ConcertController concertController;

    static Scanner sc = new Scanner(System.in);
    static int selectedShowNo;

    public ConcertMenu() {this.concertController = new ConcertController();}

    public void showConcertList() {
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║       밴드 / 가수 공연보기       ║
                ║                                ║
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
                System.out.println("공연이 없습니다.");
                System.out.println();
                continue;
            }

            selectedShowNo = concert.getShowNo();
            boolean exit = true;
            while (exit) {
                System.out.println("결제 하시겠습니까? (Y/N) > ");
                String answer = sc.nextLine().trim().toUpperCase();

                switch (answer) {
                    case "Y": exit = false; break;
                    case "N": System.out.println("공연 목록으로 돌아갑니다."); exit = false; break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요."); break;
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
            default -> "오류가 발생했습니다.";
        };
        System.out.println(errorMessage);
    }
}