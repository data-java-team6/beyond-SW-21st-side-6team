package com.team6.dva.view;

import com.team6.dva.common.SearchCriteria;
import com.team6.dva.controller.ConcertController;
import com.team6.dva.model.Concert;
import com.team6.dva.service.ConcertService;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ConcertMenu {

    private final Concert concert = new Concert();
    private final SeatMenu seatMenu = new SeatMenu();

    static Scanner sc = new Scanner(System.in);
    static String choiceConcert;
    private final ConcertService concertService = new ConcertService();

    public void showConcertList() {


        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║       밴드 / 가수 공연보기        ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
        do {
            System.out.println(menu);
            // 콘서트 정보
            // 공연명 , 공연 날짜
            // 목록 보여주기
            concertService.showSummaryInfo();
            System.out.println();

            if (true
                /*choiceConcert 와 디비의 공연명이 같으면*/) {
                // 공연 상세 정보 보여주기
                boolean correct = concertService.showInfo(inputSearchCriteria());
                System.out.println();

                if (correct) {
                    System.out.println("결제 하시겠습니까? (Y/N) > ");
                    String choice = sc.next().trim();
                    sc.nextLine();

                    switch (choice.toUpperCase()) {
                        case "Y":
                            seatMenu.showSeat(); break;
                        case "N":
                            System.out.println("공연 정보로 돌아갑니다.");
                            break;
                        default:
                            System.out.println("잘못되 입력입니다. 다시 입력해주세요.");
                            break;
                    }
                } else {
                    System.out.println(choiceConcert + "의 공연 정보 없음");
                }
            } else {
                System.out.println(choiceConcert + "의 공연 정보 없음");
            }
        } while (true);
    }

    private static SearchCriteria inputSearchCriteria() {

        System.out.print("원하는 공연 명을 입력해주세요 > ");
        choiceConcert = sc.nextLine();

        return new SearchCriteria(choiceConcert);
    }
}
