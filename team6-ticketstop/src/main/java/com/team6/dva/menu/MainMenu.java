package com.team6.dva.menu;

import com.team6.dva.model.Concert;
import com.team6.dva.model.User;

import java.util.Scanner;

public class MainMenu {

    private final MyPageMenu myPageMenu = new MyPageMenu();
    private final ConcertMenu concertMenu = new ConcertMenu();
    private final Scanner sc = new Scanner(System.in);

    public void showMenu(User user) {
        int choice;
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║          Ticket Stop           ║
                ║                                ║
                ║          1. 마이페이지          ║
                ║      2. 밴드 / 가수 공연보기     ║
                ║       3. 로그아웃 및 종료        ║
                ║                                ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
        do {
            System.out.println(menu);
            System.out.print("선택 > ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    myPageMenu.showMyPage();
                    break;
                case 2:
                    concertMenu.showConcertList();
                    break;
                case 3:
                    System.out.println("로그아웃 합니다. 안녕히가세요👋");
                    break;
                default:
                    System.out.println("번호 잘못입력했어요");
                    System.out.print("선택 > ");
            }
        } while (choice != 3);

    }
}
