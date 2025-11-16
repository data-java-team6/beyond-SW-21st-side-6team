package com.team6.dva.repository;

import com.team6.dva.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User login(@Param("id") String id,
               @Param("pw") String pw);

}
