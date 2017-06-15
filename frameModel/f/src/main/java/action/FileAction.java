package action;

import com.opensymphony.xwork2.ActionSupport;
import entity.TFile;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import java.io.*;

/**
 * Created by song on 2017/6/15.
 */
@Controller(value = "fileAction")
public class FileAction extends ActionSupport {
    private File file;
    private String fileFileName;//上传的名字
    private String message;
    private String filename;//要下载的名
    //上传文件
    public String uploadFile(){

        String path = ServletActionContext.getServletContext().getRealPath("/upload");
//        System.out.println(path);
//        System.out.println(file);

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

    //获得全部的文件
    public String getFiles(){
        String path =ServletActionContext.getServletContext().getRealPath("/upload");
        InputStream in =null;
        try {
            File downFile = new File(path+"\\"+filename);
//            if(!downFile.exists()){
//                message="您要下载的文件已删除";
//                return ERROR;
//            }
           String [] fileNames =file.list();
           ServletActionContext.getRequest().setAttribute("fileNames",fileNames);
        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
        return SUCCESS;
    }
    //下载文件
    private  InputStream fileIn;
    public String downFile(){
        System.out.println(filename);
        fileIn =ServletActionContext.getServletContext().getResourceAsStream("upload\\"+filename);
        System.out.println(fileIn);
        message="下载成功";
        return SUCCESS;
    }




    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getFileIn() {
        return fileIn;
    }

    public void setFileIn(InputStream fileIn) {
        this.fileIn = fileIn;
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

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }


}
