package dao.dao.impl;

import dao.PersonDao;
import entity.Page;
import entity.Person;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.env.SystemEnvironmentPropertySource;
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

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<Person> getAll() {
        String sql =" from Person ";
        return getSession().createQuery(sql).list();
    }

    public void add(Person p) {
        getSession().save(p);
    }

    public Person getOne(Person p) {
        return (Person) getSession().get(Person.class,p.getPid());
    }

    public Page getPage(Page page) {
        Session session= getSession();
        String hql="from Person";
        Query query =session.createQuery(hql);
        query.setFirstResult(page.getPageIndex());
        query.setMaxResults(page.getPageNum());
        List<Person> list = query.list();
        page.setList(list);
        return page;
    }

    public void del(Person p) {
        getSession().delete(p);
    }

    public void update(Person p) {
        getSession().update(p);
    }

    public boolean queryName(String username) {
        boolean flag=true;
        Query query =getSession().createQuery("from Person where username=:username");
        query.setParameter("username",username);
        Person p = (Person)query.uniqueResult();
        if(p==null){
            flag=false;
        }
        return flag;
    }
}
