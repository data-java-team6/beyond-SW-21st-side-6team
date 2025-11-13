package com.team6.dva.controller;

import com.team6.dva.model.User;
import com.team6.dva.service.MyPageService;

public class MyPageController {

    private final MyPageService myPageService = new MyPageService();

    // 예치금 조회
    public int showDeposit(User user) {
        return myPageService.showDeposit(user);
    }

    public void showMyConcert(User user) {
        myPageService.showMyConcert(user);
    }

}
