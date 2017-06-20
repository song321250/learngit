package action;


import entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import service.PersonService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * Created by song on 2017/6/19.
 */
@Controller
public class PersonController {
    @Resource(name = "personService")
    private PersonService ps;
    @RequestMapping(value = "/getAll")
    public ModelAndView getAll(){
        List<Person> list =ps.getPersonList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("show.jsp");
        return modelAndView;
    }
    @RequestMapping(value = "/add")
    public String addPerson(Person person){
        ps.addPerson(person);
        return "redirect:getAll.action";
    }
}
