package com.team6.dva.repository;

import com.team6.dva.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserById(@Param("memberId") String memberId);

}
