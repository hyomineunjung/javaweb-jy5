package com.itdr.testdemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.PreparedStatement;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoTest1 {
    @Test
    public void a() throws SQLException {
        ComboPooledDataSource co=new ComboPooledDataSource();
        Connection cn=co.getConnection();
        String q="select * from users";
        java.sql.PreparedStatement ps = cn.prepareStatement(q);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString(2));
        }
    }

}
