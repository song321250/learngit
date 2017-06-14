package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Page;

import entity.Person;
import service.PersonService;
import javax.annotation.Resource;
import java.util.List;


/**
 * Created by song on 2017/6/9.
 */
public class PersonAction extends ActionSupport {
    @Resource(name = "personService")
    PersonService ps;
    private Person person;
    private Page page =new Page();
    private List<Person> list;
    public String login(){
        try {
            ps.add(person);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public String listPerson(){
        list = ps.getAll();
        return SUCCESS;
    }

    public String edit(){
        person =ps.getOne(person);
        if(person!=null){
            return SUCCESS;
        }
        return ERROR;
    }
    public String del(){
        try {
            ps.del(person);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
    public String listPage(){
        page =ps.getPage(page);
        return SUCCESS;
    }

    public String update(){
        try {
            ps.update(person);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
