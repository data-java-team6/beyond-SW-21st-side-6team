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
                                                  
                           Ticket Stop            
                                                  
                         1. 로그인 하러가기         
                        2. 회원가입 하러가기        
                        3. 프로그램 종료하기        
                                                  
                                                  
                ╚════════════════════════════════╝
                """;
        do {
            System.out.println(menu);
            System.out.print("선택 > ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: loginSubMenu();
                        break;

                case 2: registerSubMenu();
                        break;

                case 3:
                    System.out.println("프로그램을 종료합니다");
                    break;
                default:
                    System.out.println("번호를 잘못입력하셨습니다.");
                    System.out.print("선택 > ");
            }

        } while (choice != 3);

        return null;
    }

    private void loginSubMenu() {
        User loginUser = authController.login();
        if (loginUser == null) {
            System.out.println("일치하는 회원이 없습니다.\n");
            return;
        }

        System.out.println("로그인 성공. 메인페이지로 이동합니다.\n");

        MainMenu mainMenu = new MainMenu(loginUser);
        mainMenu.showMenu();

    }

    private void registerSubMenu() {
        authController.register();
    }

}
