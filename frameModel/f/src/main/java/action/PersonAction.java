package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.Page;
import entity.Person;
import org.apache.struts2.ServletActionContext;
import service.PersonService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    private String message;
    private File file;//文件
    private String fileFileName;//文件名
    private String fileContentType;//文件类型


    public String uploadFile(){
         String path =ServletActionContext.getServletContext().getRealPath("/upload");
         System.out.println(path);

         File dir  = new File(path);
         if(!dir.exists()){
             dir.mkdir();
         }
        FileInputStream finput=null;
        FileOutputStream foutput=null;
        try {
            finput =new FileInputStream(file);
            foutput = new FileOutputStream(dir+"\\"+fileFileName);
            byte b []=new byte[1024];
            int len=0;
            while((len=finput.read(b))>0){
                foutput.write(b,0,len);
            }

            finput.close();
            foutput.close();
        } catch (Exception e) {
            e.printStackTrace();
            message="上传失败";
            return ERROR;
        }finally {

        }
        message="上传成功";
        return SUCCESS;
    }



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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
}
