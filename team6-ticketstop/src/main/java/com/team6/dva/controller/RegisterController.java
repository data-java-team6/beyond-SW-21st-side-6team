package com.team6.dva.controller;

import com.team6.dva.menu.LoginMenu;
import com.team6.dva.model.User;
import com.team6.dva.service.UserService;

import java.util.Scanner;

public class RegisterController {

    private final UserService userService;
    private final Scanner sc;

    public RegisterController(UserService userService, Scanner sc) {
        this.userService = userService;
        this.sc = sc;
    }

    public void register() {
        String id;
        String pwd;
        String pwd_chk;
        String userName;
        int deposit;

        String registerMenu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║            회원가입             ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
        System.out.println(registerMenu);
        System.out.print("ID > ");
        id = sc.nextLine();
        // 데이터 아이디 비교
        System.out.print("PW > ");
        pwd = sc.nextLine();
        System.out.print("PW 확인 > ");
        pwd_chk = sc.nextLine();
        // 비밀번호 비교 pwd, pwd_chk
        System.out.print("이름 > ");
        userName = sc.nextLine();
        System.out.print("예치금 > ");
        deposit = sc.nextInt();
        sc.nextLine();

        // 모두 들어가 있고, ID, Pw 조건 달성시 화원 가입 완료
        // LoginMenu로 들어가기
    }
}
