package com.team6.dva.repository;

import com.team6.dva.model.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentMapper {

    int insertPayment(Payment payment);

//    int updatePayment(@Param("memberId") String memberId,
//                      @Param("amount") int amount);

    int updateMemberBalance(@Param("memberId") String memberId, @Param("amount") int amount);
}
