package entity;

import java.io.File;

/**
 * Created by song on 2017/6/15.
 */
public class TFile {
    private File file;//文件
    private String fileFileName;//文件名
    private String SavePath;//文件存储数据的路径
    private String fileContentType;//文件内容类型


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

    public String getSavePath() {
        return SavePath;
    }

    public void setSavePath(String savePath) {
        SavePath = savePath;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}
