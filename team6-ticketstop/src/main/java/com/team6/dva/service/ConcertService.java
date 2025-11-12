package com.team6.dva.service;

import com.team6.dva.repository.ConcertRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.team6.dva.common.JDBCTemplate.getConnection;

public class ConcertService {


    public ResultSet getConcertInfo(Connection con, PreparedStatement pstmt, ResultSet rs) {

        con = getConnection();
        Properties prop = new Properties();
        ConcertRepository concertRepository = new ConcertRepository();
        try {
            prop.loadFromXML(new FileInputStream("src/main/resources/mapper/MemberMapper.xml"));
            pstmt = con.prepareStatement(prop.getProperty("showConcert"));
            rs = concertRepository.getConcertInfo(con, pstmt, rs);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return rs;
    }
}
