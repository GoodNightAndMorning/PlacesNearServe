package com.zsx.pn.dto;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class MyPageInfo<T> {
//    private static final long serialVersionUID = 1L;

    private Integer size;
    private long total;
    private Integer pages;
    private List<T> list;
    public MyPageInfo(Integer size, long total, Integer pages, List<T> list){
        this.size = size;
        this.total = total;
        this.pages = pages;
        this.list = list;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
