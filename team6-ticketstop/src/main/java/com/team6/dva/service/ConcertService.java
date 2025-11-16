package com.team6.dva.service;

import com.team6.dva.common.SearchCriteria;
import com.team6.dva.model.Concert;
import com.team6.dva.repository.ConcertMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.team6.dva.common.Template.getSqlSession;

public class ConcertService {

    public List<Concert> selectAllConcerts() {
        SqlSession sqlSession = getSqlSession();
        ConcertMapper mapper = sqlSession.getMapper(ConcertMapper.class);

        List<Concert> concertList = mapper.showSummaryInfo();

        sqlSession.close();
        return concertList;
    }

    public List<Concert> selectConcertByShowName(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        ConcertMapper mapper = sqlSession.getMapper(ConcertMapper.class);

        List<Concert> concertList = mapper.showInfo(searchCriteria);

        sqlSession.close();
        return concertList;
    }
    public Concert selectConcertByName(String showName) {
        SqlSession sqlSession = getSqlSession();
        ConcertMapper mapper = sqlSession.getMapper(ConcertMapper.class);

        Concert concert = mapper.selectConcertByName(showName);

        sqlSession.close();
        return concert;
    }

    public Concert selectConcertById(int showNo) {
        SqlSession sqlSession = getSqlSession();
        ConcertMapper mapper = sqlSession.getMapper(ConcertMapper.class);

        Concert concert = mapper.selectConcertById(showNo);

        sqlSession.close();
        return concert;
    }
}