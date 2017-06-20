package service.impl;

import dao.UserMapper;
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
        return 0;
    }

    public int updatePerson(Person person) {
        return 0;
    }
}
