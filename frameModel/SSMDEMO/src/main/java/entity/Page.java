package entity;

import java.util.List;

/**
 * Created by song on 2017/6/21.
 */
public class Page {
    private int pageSum;//总共有多少页
    private int pageNum=5;//一页有多少条
    private int pageCount;//总共多少条
    private int pageIndex=0;//当前页
    private List<Person> list;

    public int getPageSum() {
        return pageSum/pageNum==0?pageSum%pageNum:pageSum%pageNum+1;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
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
