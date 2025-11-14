package com.team6.dva.service;

import com.team6.dva.model.User;

public class MyPageService {
    // 로직 처리하기
    private final User user = new User();

    public int showDeposit(User user) {
        // UserRepository에서 들고오기
        return user.getDeposit();
    }

    public void showMyConcert(User user) {
        // UserRepository에서 들고오기
        int choice;
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║        결제 내역 확인하기        ║
                ║                                ║
                ╚════════════════════════════════╝
                """;

        System.out.println(menu);

    }

}
