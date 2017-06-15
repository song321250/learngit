package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2017/6/5.
 */
public class PageUser {
    private int pageIndex=0;//当前页
    private int pageNum;//每页显示几条
    private int pageCount;//总共有多少条
    private int pages;//有多少页
    private List<Person> list =new ArrayList<Person>();

    public int getPages() {
        if(pageCount>pageNum){
            return pageCount%pageNum==0?pageCount/pageNum:pageCount/pageNum+1;
        }
        return 1;
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
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

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }
}
