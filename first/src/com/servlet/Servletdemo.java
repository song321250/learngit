package com.servlet;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.PageUser;
import com.entity.Person;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by song on 2017/5/22.
 */
@WebServlet(value = "/ser")
public class Servletdemo extends HttpServlet {
   UserDao ud=null;
    @Override
    public void init() throws ServletException {
        ud=new UserDaoImpl();

    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        String op = req.getParameter("op");
        if(op==null)op="getall";
        if(op.equals("add")){
            String username = req.getParameter("username");
            String passwd = req.getParameter("passwd");
            Person p = new Person();
            p.setPassword(passwd);
            p.setUsername(username);

            ud.insertPerson(p);
            res.sendRedirect("ser?op=getall");
        }
        if(op.equals("getall")){
            PageUser pageUser =new PageUser();
            pageUser.setPageIndex(0);
            pageUser.setPageNum(3);
            pageUser.setPageCount(ud.getCount());
            List<Person> list = ud.getPage(pageUser);
            pageUser.setList(list);
            req.setAttribute("listPage",pageUser);
            req.getRequestDispatcher("show.jsp").forward(req,res);
        }
        if(op.equals("getOne")){
            String p =req.getParameter("pid");
            int pid =Integer.parseInt(p);
            Person person =ud.getOne(pid);
            req.setAttribute("person",person);
            req.getRequestDispatcher("update.jsp").forward(req,res);
        }
        if(op.equals("update")){
           String p = req.getParameter("pid");
           String username = req.getParameter("username");
           String password = req.getParameter("password");
           int pid = Integer.parseInt(p);
            Person pp=new Person(pid,username,password);
            ud.updatePerson(pp);
            res.sendRedirect("ser?op=getall");
        }
        if(op.equals("del")){
            String p =req.getParameter("pid");
            int pid =Integer.parseInt(p);
            ud.delPerson(pid);
            res.sendRedirect("ser?op=getall");
        }
        if(op.equals("page")){
            String p =req.getParameter("pageIndex");
            int pageIndex = Integer.parseInt(p);
            PageUser pageUser =new PageUser();
            pageUser.setPageIndex(pageIndex);
            pageUser.setPageNum(3);
            pageUser.setPageCount(ud.getCount());
            List<Person> list = ud.getPage(pageUser);
            pageUser.setList(list);
            req.setAttribute("listPage",pageUser);
            req.getRequestDispatcher("show.jsp").forward(req,res);
        }
        if(op.equals("upload")){
            String savepath  =getServletContext().getRealPath("/WEB-INF/upload");
            File f =new File(savepath);
            System.out.println(savepath);
            if(!f.exists()&&!f.isDirectory()){
                System.out.println(savepath+"目录不存在，需要创建");
                f.mkdir();
            }
            //消息提示
            String message="";
            try {
                //创建磁盘工厂
                DiskFileItemFactory df =new DiskFileItemFactory();
                //设置工厂的缓存大小
                int sizeThreshold =1024*100;
                df.setSizeThreshold(sizeThreshold);
                //
                //创建文件解析器
                ServletFileUpload fileUpload = new ServletFileUpload(df);
                //设置中文编码
                fileUpload.setHeaderEncoding("utf-8");
                //监听文件上传进度
                fileUpload.setProgressListener(new ProgressListener() {
                    @Override
                    public void update(long pBytesRead, long pContentLength, int arg2) {
                        System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
                    }
                });
                //设置上传单个文件的大小的最大值
                fileUpload.setFileSizeMax(1024*1024*2);

                if(!ServletFileUpload.isMultipartContent(req)){
                    return ;
                }
                //解析req请求
                List<FileItem> list = fileUpload.parseRequest(req);
                for(FileItem item :list){
                    if(item.isFormField()){
                       //表单域
                        String value =item.getString("utf-8");

                    }else{
                        //上传文件
                        String name = item.getName();
                        if(name==null&&name.trim().length()==0){
                            continue;
                        }
                        String realname = name.substring(name.lastIndexOf("\\")+1);
                        //获取item中的输入流
                        InputStream in =item.getInputStream();
                        //创建文件的输出流
                        FileOutputStream fout = new FileOutputStream(savepath+"\\"+realname);
                        //创建一个缓冲区
                        byte[]  buffer =new byte[1024];
                        //定义判断是否完成
                        int len;
                        while((len=in.read(buffer))>0){
                            //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                            fout.write(buffer,0,len);
                        }
                        //关闭流
                        in.close();
                        fout.close();
                        //删除处理文件上传时生成的临时文件
                        item.delete();
                        message = "文件上传成功！";

                    }
                }

            }catch (Exception e){
                message= "文件上传失败！";
                e.printStackTrace();
            }

            System.out.println(message);
        }

        if(op.equals("down")){
            //显示出所有能下载的文件
            //获取下载地址

            String downfile = this.getServletContext().getRealPath("/WEB-INF/upload");
            //存储要下载的文件名
            Map<String,String> fileMap = new HashMap<String,String>();
            //递归遍历downfile目录下的所有文件和目录，将文件的文件名存储到map集合中
            listfile(new File(downfile),fileMap);
            req.setAttribute("fileMap",fileMap);
            req.getRequestDispatcher("listfile.jsp").forward(req,res);
        }

        if(op.equals("dd")){
            //得到要下载的文件名
            String filename = req.getParameter("filename");
            //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
            String downpath = this.getServletContext().getRealPath("/WEB-INF/upload");
            File file = new File(downpath + "\\" + filename);
            //如果文件不存在
            if(!file.exists()){
                req.setAttribute("message","您要下载的资源已被删除");
                req.getRequestDispatcher("message.jsp").forward(req,res);
                return ;
            }
            //处理文件名
            //设置响应头，控制浏览器下载该文件
            res.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));
            //读取要下载的文件，保存到文件输入流
            FileInputStream fin = new FileInputStream(downpath+"\\"+filename);
            //创建输出流
            OutputStream out = res.getOutputStream();
            //创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            //循环将输入流中的内容读取到缓冲区当中
            while((len=fin.read(buffer))>0){
                out.write(buffer,0,len);
            }
            //关闭流
            fin.close();
            out.close();
        }

        if(op.equals("ajax")){
            //ajax
            System.out.println("this is jquery ajax");
            String p =req.getParameter("fpvalue");
            System.out.println(p);
            boolean flag  = ud.queryUser(p);
            PrintWriter out = res.getWriter();
            if(flag){
                out.print("用户名已存在");
            }else{
                out.print("可以注册");
            }
        }

    }

    /**
         * @Method: listfile
         * @Description: 递归遍历指定目录下的所有文件
         * @param file 即代表一个文件，也代表一个文件目录
         * @param map 存储文件名的Map集合
         */
    public void listfile(File file, Map<String,String> map){
        //如果file不是文件，而是目录
        if(!file.isFile()){
            //列出该目录下的所有文件和目录
            File files[] = file.listFiles();
            for(File f :files){
                //递归
                listfile(f,map);
            }
        }else {
            String realname = file.getName();
            map.put(file.getName(),realname);
        }

    }
    /**
         * @Method: findFileSavePathByFileName
         * @Description: 通过文件名和存储上传文件根目录找出要下载的文件的所在路径
         * @param filename 要下载的文件名
         * @param saveRootPath 上传文件保存的根目录，也就是/WEB-INF/upload目录
         * @return 要下载的文件的存储目录
         */
    public String  findFileSavePathByFileName(String filename,String saveRootPath){


        return null;
    }
}
