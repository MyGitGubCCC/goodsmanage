package com.xzit.entity;

public class Dormitory {
    private Integer dormitoryid;

    private String dormitoryno;

    public Integer getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(Integer dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getDormitoryno() {
        return dormitoryno;
    }

    public void setDormitoryno(String dormitoryno) {
        this.dormitoryno = dormitoryno == null ? null : dormitoryno.trim();
    }
}