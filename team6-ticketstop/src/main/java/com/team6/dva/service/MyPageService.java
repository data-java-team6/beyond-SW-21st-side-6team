package com.team6.dva.service;

import com.team6.dva.model.User;

public class MyPageService {
    private final User user = new User();

    public void showDeposit(User user) {
        // 유저 ID 연결해서 그 ID와 일치하는 예치금 가져오기
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║          예치금 확인하기         ║
                ║                                ║
                ╚════════════════════════════════╝
                """;
        System.out.println(menu);
        System.out.println("당신이 소유 하고 있는 예치금은 " + user.getDeposit() + "원 입니다.");

    }

    public void showMyConcert() {
        int choice;
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║        결제 내역 확인하기        ║
                ║                                ║
                ╚════════════════════════════════╝
                """;

        do {
            System.out.println(menu);
            // 결제 내역
            // 로그인 된 ID의 유저가 결제한 콘서트 정보 보여주기
            // 그러면 choice도 그거와 같이 늘어 나야 겠죠?
            // 아니면 콘서트 명으로 검색 하게 하셔도 되요
        } while (true);

    }

}
