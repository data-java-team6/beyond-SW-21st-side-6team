package com.team6.dva.service;

import com.team6.dva.model.User;
import com.team6.dva.repository.UserMapper;
import org.apache.ibatis.session.SqlSession;

import static com.team6.dva.common.Template.getSqlSession;

public class UserService {

    public User login(String id, String pwd) {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.login(id, pwd);
        sqlSession.close();

        return user;
    }

    // ⭐ 회원가입 처리
    public boolean registerUser(User user) {

        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 1. 중복 체크
        int count = mapper.checkDuplicatedId(user.getMemberId());
        if (count > 0) {
            sqlSession.close();
            return false;
        }

        // 2. 삽입
        int result = mapper.insertUser(user);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;
    }
}
