package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Person;

import org.springframework.stereotype.Controller;
import service.PersonService;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by song on 2017/6/9.
 */
@Controller(value = "personAction")
public class PersonAction extends ActionSupport {
    @Resource(name = "personService")
    PersonService ps;
    private String username;
    private List<Person> list;
    public String login(){
        System.out.println(username);
        list = ps.getAll();
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }
}
