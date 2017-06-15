package com.dao;

import com.entity.PageUser;
import com.entity.Person;

import java.util.List;

/**
 * Created by song on 2017/6/5.
 */
public interface UserDao {
    public List<Person> getAll();
    public int insertPerson(Person p );
    public int updatePerson(Person p);
    public int delPerson(int pid);
    public Person getOne(int pid);
    public int getCount();//总共有多少条数据
    public List<Person> getPage(PageUser pageUser);
    public boolean queryUser(String name);
}
