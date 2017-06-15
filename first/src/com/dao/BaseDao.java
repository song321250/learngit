package com.dao;

import java.sql.*;

/**
 * Created by song on 2017/5/18.
 */
public class BaseDao {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/test";
    private String username="root";
    private String password="123456";
    //数据库连接
    public Connection getConnection(){

        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn,PreparedStatement pstmt,ResultSet set){
         try {
             if(rs!=null)rs.close();
             if (pstmt!=null)pstmt.close();
             if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public int update(String sql ,Object o[]){
        int j=0;
        conn=getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < o.length; i++) {
                pstmt.setObject(i + 1, o[i]);
            }
            j=pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            close(conn,pstmt,rs);
        }
        return j;
    }

}
