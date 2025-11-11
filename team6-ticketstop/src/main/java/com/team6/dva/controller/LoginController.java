package com.team6.dva.controller;

import com.team6.dva.model.User;
import com.team6.dva.service.UserService;

import java.util.Scanner;

public class LoginController {

    private final UserService userService;
    private final Scanner sc;

    public LoginController(UserService userService, Scanner sc) {
        this.userService = userService;
        this.sc = sc;
    }

    public void login() {
        String id;
        String pwd;
        String loginMenu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║             로그인              ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
        System.out.println(loginMenu);
        System.out.print("ID > ");
        id = sc.nextLine();
        System.out.print("PW > ");
        pwd = sc.nextLine();

        // ID, PW 회원 테이블에 존재, 일치 시 메인 메뉴로 돌아가기



    }
}
