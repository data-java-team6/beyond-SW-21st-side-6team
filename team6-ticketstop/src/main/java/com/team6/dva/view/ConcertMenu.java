package com.team6.dva.view;

import com.team6.dva.controller.ConcertController;
import com.team6.dva.model.Concert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ConcertMenu {

    private final Concert concert = new Concert();
    private final Scanner sc = new Scanner(System.in);

    public void showConcertList() {

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
            Connection con = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            ConcertController concertController = new ConcertController();

            rs = concertController.getConcertInfo(con, pstmt, rs);

            System.out.println();
            System.out.print("원하는 공연 명을 입력해주세요 > ");
            choiceConcert = sc.nextLine();

            if (true
                /*choiceConcert 와 디비의 공연명이 같으면*/) {
                // 공연 상세 정보 보여주기


            } else {
                System.out.println(choiceConcert + "의 공연 정보 없음");
            }

        } while (true);

    }
}
