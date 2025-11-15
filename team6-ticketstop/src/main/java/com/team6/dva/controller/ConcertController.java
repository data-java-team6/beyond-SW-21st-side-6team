package com.team6.dva.controller;

import com.team6.dva.common.SearchCriteria;
import com.team6.dva.model.Concert;
import com.team6.dva.service.ConcertService;
import com.team6.dva.view.ConcertMenu;

import java.util.List;

public class ConcertController {

    private final ConcertService concertService;

    public ConcertController() {
        this.concertService = new ConcertService();
    }

    public void selectAllConcerts() {
        List<Concert> concertList = concertService.selectAllConcerts();

        if (concertList != null && !concertList.isEmpty()) {
            ConcertMenu.printConcertList(concertList);
        } else {
            ConcertMenu.printErrorMessage("selectList");
        }
    }

    public Concert selectConcertByShowName(String selectedShowName) {
        List<Concert> concertList = concertService.selectConcertByShowName(new SearchCriteria(selectedShowName));

        if (concertList != null && !concertList.isEmpty()) {
            Concert concert = concertList.get(0);
            ConcertMenu.printConcert(concert);
            return concert;
        } else {
            System.out.println("조회할 내용이 없습니다.");
            return null;
        }
    }

//    public Concert selectConcertById(int showNo) {
//        Concert concert = concertService.selectConcertById(showNo);
//
//        if (concert != null) {
//            return concert;
//        } else {
//            ConcertMenu.printErrorMessage("selectOne");
//            return null;
//        }
//    }

}