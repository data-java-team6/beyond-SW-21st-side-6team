package com.team6.dva.repository;

import com.team6.dva.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User login(@Param("id") String id,
               @Param("pw") String pw);

    int showMyDeposit(String memberId);

    // ⭐ 중복체크
    int checkDuplicatedId(String memberId);

    // ⭐ 회원가입
    int insertUser(User user);
}
