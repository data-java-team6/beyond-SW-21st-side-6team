package com.team6.dva.service;

import com.team6.dva.common.SearchCriteria;
import com.team6.dva.controller.AuthController;
import com.team6.dva.model.Payment;
import com.team6.dva.model.User;
import com.team6.dva.repository.ConcertMapper;
import com.team6.dva.repository.UserMapper;
import com.team6.dva.view.ConcertMenu;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.team6.dva.common.Template.getSqlSession;

public class MyPageService {
    // 로직 처리하기
    private final User user = new User();

    public void showMyDeposit(String id) {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int deposit = mapper.showMyDeposit(id);
        System.out.println("당신이 소유 하고 있는 예치금은 " + deposit + "원 입니다.");

        sqlSession.close();

    }

    public void showMyConcert(String id) {
        // UserRepository에서 들고오기
        String menu = """
                ╔════════════════════════════════╗
                
                         결제 내역 확인하기          
                
                ╚════════════════════════════════╝
                """;

        System.out.println(menu);

        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<Payment> paymentList = mapper.showMyConcert(id);

            if (paymentList == null || paymentList.isEmpty()) {
                System.out.println("결제 내역이 없습니다.");
                return;
            }

            String headerFormat = "%-4s | %-15s | %-10s | %-5s | %-8s%n";
            String rowFormat = "%-4d | %-15s | %-10s | %-5s | %,8d원%n";

// 1. 헤더 먼저 만들기
            String header = String.format(
                    headerFormat,
                    "번호", "공연명", "공연일", "좌석", "금액"
            );
            System.out.print(header);

// 2. 헤더 길이에 맞춰 선 그리기
            System.out.println("-".repeat(header.replace("\n", "").length()));

// 3. 데이터 출력
            int index = 1;
            for (Payment p : paymentList) {
                System.out.printf(
                        rowFormat,
                        index++,
                        p.getShowName(),
                        p.getShowDate(),
                        p.getSeatName(),
                        p.getTotalPrice()
                );
            }

        } finally {
            sqlSession.close();
        }
    }

}
