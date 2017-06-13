package service;

import dao.PersonDao;
import dao.dao.impl.PersonDaoImpl;
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
}
