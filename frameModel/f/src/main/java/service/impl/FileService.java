package service.impl;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by song on 2017/6/15.
 */
public interface FileService {
    public void save(String savePath);//存储到数据库，savePath是存储路径
    public List<String> getAllFile();//获得全部文件的路径
    public void write(OutputStream os,String fileId);//将文件写入到输出流
    public String getFileName(String fileId);//获取文件名
}
