package com.team6.dva.menu;

import com.team6.dva.service.ShowDeposit;
import com.team6.dva.service.ShowMyConcert;

import java.util.Scanner;

public class MyPageMenu {

    private final Scanner sc = new Scanner(System.in);
    private final ShowDeposit showDeposit = new ShowDeposit();
    private final ShowMyConcert showMyConcert = new ShowMyConcert();

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
                    showDeposit.showDeposit();
                    break;
                case 2:
                    showMyConcert.showMyConcert();
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
