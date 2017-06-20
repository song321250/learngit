package service;

import entity.Person;

import java.util.List;

/**
 * Created by song on 2017/6/16.
 */
public interface PersonService {

    public List<Person> getPersonList();//获得全部的用户

    public int addPerson(Person person);//添加

    public int delPerson(Person person);//删除

    public int updatePerson(Person person);//修改


}
