package service.impl;

import entity.Page;
import entity.Person;

import java.util.List;

/**
 * Created by song on 2017/6/15.
 */
public interface PersonService {
    public List<Person> getAll();//获得全部的Person记录
    public void add(Person p);//增加
    public void del(Person p);//删除
    public void update(Person p);//修改
    public Page getPage(Page page);//分页
    public Person getOne(Person p);//获得单个对象
}
