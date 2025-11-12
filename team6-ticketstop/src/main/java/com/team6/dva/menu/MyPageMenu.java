package com.team6.dva.menu;

import com.team6.dva.model.User;
import com.team6.dva.service.MyPageService;

import java.util.Scanner;

public class MyPageMenu {

    private final User user = new User();

    private final Scanner sc = new Scanner(System.in);
    private final MyPageService myPageService = new MyPageService();

    public void showMyPage() {
        int choice = 0;
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║           마이 페이지           ║
                ║                                ║
                ║        1. 예치금 확인하기        ║
                ║      2. 결제 내역 확인하기       ║
                ║           3. 돌아가기           ║
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
                    myPageService.showDeposit(user);
                    break;
                case 2:
                    myPageService.showMyConcert();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("번호 잘못입력했어요");
                    System.out.print("선택 > ");
            }
        } while (choice != 3);
    }

}
