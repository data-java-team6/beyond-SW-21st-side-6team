package com.team6.dva.service;

import com.team6.dva.common.SearchCriteria;
import com.team6.dva.controller.AuthController;
import com.team6.dva.model.User;
import com.team6.dva.repository.ConcertMapper;
import com.team6.dva.repository.UserMapper;
import org.apache.ibatis.session.SqlSession;

import static com.team6.dva.common.Template.getSqlSession;

public class MyPageService {
    // 로직 처리하기
    private final User user = new User();

    public void showMyDeposit(String id) {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //int deposit = mapper.showMyDeposit(id);
       // System.out.println("당신이 소유 하고 있는 예치금은 " + deposit + "원 입니다.");

        sqlSession.close();

    }

    public void showMyConcert(User user) {
        // UserRepository에서 들고오기
        int choice;
        String menu = """
                ╔════════════════════════════════╗
                ║                                ║
                ║        결제 내역 확인하기         ║
                ║                                ║
                ╚════════════════════════════════╝
                """;

        System.out.println(menu);

    }

}
