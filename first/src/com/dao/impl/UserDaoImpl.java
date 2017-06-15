package com.dao.impl;

import com.dao.BaseDao;
import com.dao.UserDao;
import com.entity.PageUser;
import com.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2017/6/5.
 */
public class UserDaoImpl implements UserDao {
    BaseDao bd = new BaseDao();
    Connection conn = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;
    @Override
    public List<Person> getAll() {
        conn  = bd.getConnection();
        List<Person> list = new ArrayList<Person>();
        try {
            pstmt = conn.prepareStatement("select * from person ");
            rs = pstmt.executeQuery();
            while (rs.next()){
                Person p = new Person();
                p.setPassword(rs.getString("password"));
                p.setUsername(rs.getString("username"));
                p.setPid(rs.getInt("pid"));
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bd.close(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public int insertPerson(Person p) {
        String sql ="insert into person(username,password) values(?,?)";
        int j =bd.update(sql,new Object[]{p.getUsername(),p.getPassword()});
        return j;
    }

    @Override
    public int updatePerson(Person p) {
        String sql ="update person set username=?,password=? where pid =?";
        int j =bd.update(sql,new Object[]{p.getUsername(),p.getPassword(),p.getPid()});
        return j;
    }

    @Override
    public int delPerson(int pid) {
        String sql ="delete from person where pid=?";
        int j = bd.update(sql,new Object[]{pid});
        return j;
    }

    @Override
    public Person getOne(int pid) {
        conn = bd.getConnection();
        Person p =null;
        try {
            pstmt = conn.prepareStatement("select * from person where pid=?");
            pstmt.setInt(1, pid);
            rs = pstmt.executeQuery();
            if(rs.next()){
                p =new Person();
                p.setPid(rs.getInt("pid"));
                p.setPassword(rs.getString("password"));
                p.setUsername(rs.getString("username"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bd.close(conn,pstmt,rs);
        }
        return p;
    }

    @Override
    public int getCount() {
        int count=0;
        conn = bd.getConnection();
        try {
            pstmt = conn.prepareStatement("select count(*) from person");
            rs = pstmt.executeQuery();
            if (rs.next()) count = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bd.close(conn,pstmt,rs);
        }
        return count;
    }

    @Override
    public List<Person> getPage(PageUser pageUser) {
        List<Person> list = new ArrayList<Person>();
        conn = bd.getConnection();
        //String sql  ="select * from person limit"+pageUser.getPageIndex()*pageUser.getPageNum()+","+pageUser.getPageNum();
        try {
            pstmt = conn.prepareStatement("select * from person limit ?,?");
            pstmt.setInt(1,pageUser.getPageIndex()*pageUser.getPageNum());
            pstmt.setInt(2,pageUser.getPageNum());
            //pstmt.setInt(2,pageUser.getPageNum());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Person p = new Person();
                p.setPid(rs.getInt("pid"));
                p.setPassword(rs.getString("password"));
                p.setUsername(rs.getString("username"));
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bd.close(conn,pstmt,rs);
        }
        return list;
    }

    @Override
    public boolean queryUser(String name) {
        conn = bd.getConnection();
        boolean flag =false;
        try {
            pstmt=conn.prepareStatement("select * from person where username=?");
            pstmt.setString(1,name);
            rs =pstmt.executeQuery();
            if(rs.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return flag;
    }
}
