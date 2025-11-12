package com.team6.dva.menu;

import com.team6.dva.model.Concert;

import java.util.Scanner;

public class ConcertMenu {

    private final Concert concert = new Concert();
    private final Scanner sc = new Scanner(System.in);

    public void showConcertList() {

        String concertTitle ="";
        String concertDate;
        String choiceConcert;

        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║       밴드 / 가수 공연보기       ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
        do {
            System.out.println(menu);
            // 콘서트 정보
            // 공연명 , 공연 날짜
            // 목록 보여주기


            System.out.print("원하는 공연 명을 입력해주세요 > ");
            choiceConcert = sc.nextLine();

            if (choiceConcert.equals(concertTitle)) {
                // 공연 상세 정보 보여주기
            } else {
                System.out.println("공연 정보 없음");
            }

        }while (true);

    }
}
