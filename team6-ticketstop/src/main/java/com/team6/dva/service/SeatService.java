package com.team6.dva.service;

import com.team6.dva.model.Seat;
import com.team6.dva.repository.SeatMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.team6.dva.common.Template.getSqlSession;

public class SeatService {
    public List<Seat> selectSeatsByShowNo(int showNo){
        SqlSession sqlSession = getSqlSession();
        SeatMapper seatMapper = sqlSession.getMapper(SeatMapper.class);

        List<Seat> seatList = seatMapper.selectSeatsByShowNo(showNo);

        sqlSession.close();
        return seatList;
    }

    public Seat selectSeatByNameAndShowNo(int showNo, String seatName){
        SqlSession sqlSession = getSqlSession();
        SeatMapper seatMapper = sqlSession.getMapper(SeatMapper.class);

        Seat seat = seatMapper.selectSeatByNameAndShowNo(showNo, seatName);
        sqlSession.close();
        return seat;
    }

    public boolean reserveSeat(int seatId){
        SqlSession sqlSession = getSqlSession();
        SeatMapper seatMapper = sqlSession.getMapper(SeatMapper.class);
        int result = seatMapper.updateSeatReserved(seatId);

        if(result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0;
    }
}
