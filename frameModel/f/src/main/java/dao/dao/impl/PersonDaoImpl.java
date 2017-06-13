package dao.dao.impl;

import dao.PersonDao;
import entity.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song on 2017/6/9.
 */
@Service(value = "personDaoImpl")
public class PersonDaoImpl   implements PersonDao  {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;


    @Override
    public List<Person> getAll() {
        String sql =" from Person";
        return sessionFactory.getCurrentSession().createQuery(sql).list();
    }

//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
