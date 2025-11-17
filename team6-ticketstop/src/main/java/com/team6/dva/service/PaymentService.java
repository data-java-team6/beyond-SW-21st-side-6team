package com.team6.dva.service;

import com.team6.dva.model.Payment;
import com.team6.dva.model.User;
import com.team6.dva.repository.PaymentMapper;
import com.team6.dva.repository.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.team6.dva.common.Template.getSqlSession;

public class PaymentService {

    public User getUserById(String memberId) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectUserById(memberId);

        sqlSession.close();
        return user;
    }

    public boolean processPayments(int memberNo, List<Integer> seatIds, int totalPrice, String memberId) {
        SqlSession sqlSession = getSqlSession();
        PaymentMapper paymentMapper = sqlSession.getMapper(PaymentMapper.class);

        try {
            int pricePerSeat = totalPrice / seatIds.size();

            for (int seatId : seatIds) {
                Payment payment = new Payment(memberNo, seatId, pricePerSeat);
                int paymentResult = paymentMapper.insertPayment(payment);

                if (paymentResult == 0) {
                    sqlSession.rollback();
                    return false;
                }
            }

            int balanceResult = paymentMapper.updateMemberBalance(memberId, totalPrice);

            if (balanceResult > 0) {
                sqlSession.commit();
                return true;
            } else {
                sqlSession.rollback();
                return false;
            }

        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
            return false;
        } finally {
            sqlSession.close();
        }
    }
}