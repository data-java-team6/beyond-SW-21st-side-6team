package com.team6.dva.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConcertRepository {


    public ResultSet getConcertInfo(Connection con, PreparedStatement pstmt, ResultSet rs) {

        try {
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rs;
    }
}
