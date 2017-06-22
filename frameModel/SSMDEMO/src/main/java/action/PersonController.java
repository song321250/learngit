package action;


import entity.Page;
import entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;
import service.PersonService;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



/**
 * Created by song on 2017/6/19.
 */
@Controller
@RequestMapping("person")
public class PersonController {
    @Resource(name = "personService")
    private PersonService ps;
    @RequestMapping(value = "/getAll")
    public ModelAndView getAll(){
        List<Person> list =ps.getPersonList();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/show.jsp");
        return modelAndView;
    }
    @RequestMapping(value = "/add")
    public String addPerson(Person person){
        ps.addPerson(person);
        return "redirect:findPage";
    }
    @RequestMapping(value = "/del")
    public String delPerson(Person person){
        ps.delPerson(person);
        return "redirect:findPage";
    }
    @RequestMapping(value = "/getOne")
    public String getOne(Model model, Person person){
        Person persons = ps.getOne(person);
        model.addAttribute("person",persons);
        return "/update.jsp";
    }
    @RequestMapping(value = "/update")
    public String updatePerson(Person person){
        ps.updatePerson(person);
        return "redirect:findPage";
    }
    @RequestMapping(value = "/ajaxAction",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String AjaxPerson(HttpServletResponse response, Person person){
//        response.setContentType("text/html;chatset=utf-8");
        List<Person>  list =ps.isExit(person);
        if(list.size()>0){
            return "用户已存在";
        }
        return "可以注册";
    }
    @RequestMapping(value = "/findPage")
    public ModelAndView findPage(ModelAndView modelAndView,Page page){
        Page page1 = new Page();
        page1.setPageIndex(page.getPageIndex());
        int count = ps.getPersonCount();
        page1.setPageCount(count);
        List<Person> list =ps.findPage(page);
        page1.setList(list);
        modelAndView.addObject("pages",page1);
        modelAndView.setViewName("/show.jsp");
        return modelAndView;
    }
}
