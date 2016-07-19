package com.example.administrator.my_maf_request.bean;

import java.util.List;


public class SubjectSum {
    private String limit;
    private int total;
    private List<Subject> items;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Subject> getItems() {
        return items;
    }

    public void setItems(List<Subject> items) {
        this.items = items;
    }
}
