package com.team6.dva.controller;

import com.team6.dva.model.User;
import com.team6.dva.service.UserService;

import java.util.Scanner;

public class AuthController {

    private final UserService userService;
    private final Scanner sc;
//    public static String id;
    // 로그인은 구현이 안되어있는데 확인 하고 싶을떄
    public static String id = "user01";

    public AuthController(UserService userService, Scanner sc) {
        this.userService = userService;
        this.sc = sc;
    }

    public User login() {
        String pwd;
        System.out.println("""
               ╔════════════════════════════════╗
                                                
                            로그인               
                                                
               ╚════════════════════════════════╝
                """);

        System.out.print("ID > ");
        id = sc.nextLine();

        System.out.print("PW > ");
        pwd = sc.nextLine();

        User loginUser = userService.login(id, pwd);

        if (loginUser == null) {
            System.out.println("\n일치하는 회원이 없습니다. 다시 입력해주세요.\n");
            return null;
        }

        System.out.println("\n로그인 성공!");
        System.out.println(loginUser.getMemberName() + "님 환영합니다!");
        System.out.println("현재 예치금: " + loginUser.getBalance() + "원\n");

        return loginUser;
    }

    public void register() {
        String id;
        String pwd;
        String pwd_chk;
        String userName;
        int deposit;

        System.out.println("""
                ╔════════════════════════════════╗
                                                  
                             회원가입              
                                                  
                ╚════════════════════════════════╝
                """);

        System.out.print("ID > ");
        id = sc.nextLine();

        System.out.print("PW > ");
        pwd = sc.nextLine();

        System.out.print("PW 확인 > ");
        pwd_chk = sc.nextLine();

        if (!pwd.equals(pwd_chk)) {
            System.out.println("\n비밀번호가 일치하지 않습니다!\n");
            return;
        }

        System.out.print("이름 > ");
        userName = sc.nextLine();

        System.out.print("예치금 > ");
        deposit = sc.nextInt();
        sc.nextLine();

        User user = new User();
        user.setMemberId(id);
        user.setMemberPw(pwd);
        user.setMemberName(userName);
        user.setBalance(deposit);

        boolean success = userService.registerUser(user);

        if (success) {
            System.out.println("\n회원가입이 완료되었습니다\n");
        } else {
            System.out.println("\n이미 존재하는 ID입니다.\n");
        }
    }
}
