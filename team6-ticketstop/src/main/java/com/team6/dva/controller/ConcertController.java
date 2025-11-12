package com.team6.dva.controller;

import com.team6.dva.service.ConcertService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.team6.dva.common.JDBCTemplate.close;

public class ConcertController {


    public ResultSet getConcertInfo(Connection con, PreparedStatement pstmt, ResultSet rs) {

        ConcertService concertService = new ConcertService();

        rs = concertService.getConcertInfo(con, pstmt, rs);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("show_name") + rs.getDate("show_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
            close(con);
        }
        return rs;
    }
}
