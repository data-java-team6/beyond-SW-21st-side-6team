package com.team6.dva.service;

import com.team6.dva.common.SearchCriteria;
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
        sqlSession.close();
    }

    public boolean showInfo(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        ConcertMapper mapper = sqlSession.getMapper(ConcertMapper.class);

        List<Concert> conList = mapper.showInfo(searchCriteria);
        if(conList != null && !conList.isEmpty()) {
            conList.forEach(con -> System.out.println(
                            "\n" +
                            "공연명 : " + con.getShowName() + "\n" +
                            "공연날짜 : " + con.getShowDate() + "\n" +
                            "공연 내용 : " + con.getShowInfo() + "\n" +
                            "공연 예약 가능 기간 : " + con.getPayStart() + " ~ " + con.getPayEnd() + "\n" +
                            "공연 가격 : " + con.getPrice()));
            sqlSession.close();
            return true;
        } else {
            System.out.println("조회할 내용이 없습니다.");
            sqlSession.close();
            return false;
        }
    }
}
