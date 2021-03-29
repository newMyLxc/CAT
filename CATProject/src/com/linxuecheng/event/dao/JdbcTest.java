package com.linxuecheng.event.dao;

import com.linxuecheng.event.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        chaXun();
    }

    public static void chaXun(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            //定义sql语句
            String sql = "select * from balance";
            //获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //执行sql
            rs = pstmt.executeQuery();
            //读取rs中的内容
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                System.out.println(id + "---" + name + "---" + salary);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //释放资源
            JdbcUtils.close(rs, pstmt, conn);
        }

    }
}
