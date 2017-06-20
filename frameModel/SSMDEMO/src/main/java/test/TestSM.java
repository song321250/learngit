package test;
import dao.UserMapper;
import entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2017/6/19.
 */
public class TestSM {
    @Test
    public void testSM(){
        ApplicationContext ax = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper person=(UserMapper)ax.getBean("userMapper");
        System.out.println(person.getPersinList());
    }
    @Test
    public void testSMADD(){
        ApplicationContext ax = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper person=(UserMapper)ax.getBean("userMapper");
        Person person1 =new Person();
        person1.setUsername("lajiqqqq");
        person1.setPassword("123");
        Person person2 =new Person();
        person2.setUsername("lajiwwww");
        person2.setPassword("123");
        List<Person> list = new ArrayList<Person>();
        list.add(person1);
        list.add(person2);
        System.out.println("list集合的长度："+list.size());
//        int i =person.addPerson(list);
        System.out.println();
    }
    @Test
    public void testBatch(){

    }
}
