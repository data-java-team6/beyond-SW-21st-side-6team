package com.team6.dva.service;

import com.team6.dva.common.Template;
import com.team6.dva.model.Concert;
import com.team6.dva.repository.ConcertMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.team6.dva.common.Template.getSqlSession;

public class ConcertService {


    public void showSummaryInfo() {
        SqlSession sqlSession = getSqlSession();
        ConcertMapper mapper = sqlSession.getMapper(ConcertMapper.class);

        List<Concert> conList = mapper.showSummaryInfo();

        if(conList != null && !conList.isEmpty()) {
            conList.forEach(con -> System.out.println(con.getShowName() +"   " + con.getShowDate()));
        } else {
            System.out.println("해당 정보 없음");
        }
    }
}
