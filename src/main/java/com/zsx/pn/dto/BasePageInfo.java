package com.zsx.pn.dto;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class BasePageInfo {
    private Long total;
    private Integer pages;
    private List list;

    public BasePageInfo(PageInfo info) {
        total = info.getTotal();
        pages = info.getPages();
        list = info.getList();
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
