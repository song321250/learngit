package dao;

import entity.Page;
import entity.Person;
import java.util.List;

/**
 * Created by song on 2017/6/9.
 */
public interface PersonDao {
    public List<Person> getAll();
    public void add(Person p );
    public Person getOne(Person p);
    public void update(Person p);
    public void del(Person p);

    public Page getPage(Page page);

    public boolean queryName(String username);
}
