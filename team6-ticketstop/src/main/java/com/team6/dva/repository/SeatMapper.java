package com.team6.dva.repository;

import com.team6.dva.model.Seat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatMapper {

    List<Seat> selectSeatsByShowNo(@Param("showNo") int showNo);

    Seat selectSeatByNameAndShowNo(@Param("showNo") int seatNo, @Param("seatName") String seatName);

    int updateSeatReserved(@Param("seatId") int seatId);
}
