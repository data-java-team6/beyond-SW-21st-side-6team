package com.team6.dva.view;

import com.team6.dva.controller.MyPageController;
import com.team6.dva.model.User;
import com.team6.dva.service.MyPageService;

import java.util.Scanner;

public class MyPageMenu {

    private final User user = new User();

    private final Scanner sc = new Scanner(System.in);
    private final MyPageController myPageController = new MyPageController();

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
                    // 유저 ID 연결해서 그 ID와 일치하는 예치금 가져오기
                    String de_menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║          예치금 확인하기         ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
//                    int deposit = myPageController.showDeposit(user);
                    System.out.println(de_menu);
//                    System.out.println("당신이 소유 하고 있는 예치금은 " + user.getDeposit() + "원 입니다.");

                    break;
                case 2:
//                    myPageController.showMyConcert(user);
                    break;
                case 3:
                    System.out.println("마이페이지를 종료합니다.");
                    return;
                default:
                    System.out.println("번호 잘못입력했어요");
                    System.out.print("선택 > ");
            }
        } while (choice != 3);
    }

}
