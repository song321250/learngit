package service;

import dao.PersonDao;
import dao.dao.impl.PersonDaoImpl;
import entity.Page;
import entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 2017/6/9.
 */
@Service(value = "personService")
public class PersonService {
    @Resource(name = "personDaoImpl")
    PersonDao pd;
    public List<Person> getAll(){
       List<Person> list = pd.getAll();
        return list;
    }

    public void add(Person p){
        pd.add(p);
    }
    public Person getOne(Person p){
        return  pd.getOne(p);
    }
    public void update(Person p){
        pd.update(p);
    }
    public void del(Person p){
        pd.del(p);
    }

    public Page getPage(Page page){
        return pd.getPage(page);
    }


}
