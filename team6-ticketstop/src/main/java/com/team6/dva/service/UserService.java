package com.team6.dva.service;

import com.team6.dva.model.User;
import com.team6.dva.repository.UserMapper;
import org.apache.ibatis.session.SqlSession;

import static com.team6.dva.common.Template.getSqlSession;

public class UserService {

    public User login(String id, String pw) {
        SqlSession session = getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        User user = mapper.login(id, pw);

        session.close();
        return user;

    }
}
