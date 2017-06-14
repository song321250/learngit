package entity;
import java.util.List;
/**
 * Created by song on 2017/6/13.
 */
public class Page {
    private int pageNum=5;//每页显示多少条
    private int pageIndex=0;//当前页

    private List<Person> list;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }
}
