package com.team6.dva.view;

import com.team6.dva.controller.AuthController;
import com.team6.dva.model.User;
import com.team6.dva.service.UserService;

import java.util.Scanner;

public class LoginMenu {

    private final UserService userService = new UserService();
    private final Scanner sc = new Scanner(System.in);
    private final AuthController authController = new AuthController(userService, sc);
    public User start() {
        int choice;
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║          Ticket Stop           ║
                ║                                ║
                ║        1. 로그인 하러가기        ║
                ║       2. 회원가입 하러가기       ║
                ║       3. 프로그램 종료하기       ║
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
                case 1: authController.login(); break;
                case 2: authController.register(); break;
                case 3: break;
                default:
                    System.out.println("번호 잘못입력했어요");
                    System.out.print("선택 > ");
            }

        } while (choice != 3);

        return null;
    }
}
