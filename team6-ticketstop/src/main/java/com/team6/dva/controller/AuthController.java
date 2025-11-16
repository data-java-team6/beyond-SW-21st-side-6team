package com.team6.dva.controller;

import com.team6.dva.model.User;
import com.team6.dva.service.UserService;

import java.util.Scanner;

public class AuthController {

    private final UserService userService;
    private final Scanner sc;
    public static String id;
    // 로그인은 구현이 안되어있는데 확인 하고 싶을떄
//    public static String id = "user01"

    public AuthController(UserService userService, Scanner sc) {
        this.userService = userService;
        this.sc = sc;
    }

    public User login() {
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
        id = sc.nextLine(); // static 으로 만들기 , 로그아웃은 null로 바꿔주기
        System.out.print("PW > ");
        pwd = sc.nextLine();

        // ID, PW 회원 테이블에 존재, 일치 시 메인 메뉴로 돌아가기

        return null;
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
                ║            회원가입              ║
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
