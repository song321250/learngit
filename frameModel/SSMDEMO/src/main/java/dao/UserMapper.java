package dao;

import entity.Person;
import java.util.List;

/**
 * Created by song on 2017/6/16.
 */
public interface UserMapper {
    public Person getPersonId(int id);

    public List<Person> getPersinList();

    public int addPerson(Person person);

    public int delPerson(Person person);

    public int updatePerson(Person person);
}
