package service.impl;

import dao.UserMapper;
import entity.Page;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.PersonService;

import java.util.List;

/**
 * Created by song on 2017/6/19.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private UserMapper userMapper;

    public List<Person> getPersonList() {

        return userMapper.getPersinList();
    }

    public int addPerson(Person person) {

        return userMapper.addPerson(person);
    }

    public int delPerson(Person person) {

        return userMapper.delPerson(person);
    }

    public int updatePerson(Person person) {
        return userMapper.updatePerson(person);
    }

    public Person getOne(Person person) {
        return userMapper.getOne(person);
    }

    public List<Person> isExit(Person person) {

        return userMapper.isExit(person);
    }

    public int getPersonCount() {

        return userMapper.getPersonCount();
    }

    public List<Person> findPage(Page page) {

        return userMapper.findPage(page);
    }
}
