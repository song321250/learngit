package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Page;
import entity.Person;
import org.apache.struts2.ServletActionContext;
import service.impl.PersonService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


/**
 * Created by song on 2017/6/9.
 */
public class PersonAction extends ActionSupport {
    @Resource(name = "personService")
    PersonService ps;
    private Person person;
    private Page pages;
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
        if(pages==null){
            pages= new Page();
        }
        pages =ps.getPage(pages);
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


    private String username;

    public String getAjax(){
        System.out.println(username);
        boolean flag =ps.queryName(username);
        String m="";
        if(flag){
            m="用户已存在";
        }else{
            m="可以注册";
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =null;
        try {
            out =response.getWriter();
            out.print(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Page getPages() {
        return pages;
    }

    public void setPages(Page pages) {
        this.pages = pages;
    }

}
