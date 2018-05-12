package com.xzit.entity;

import java.util.Date;

public class Leaveschool {
    private Integer leaveschoolid;

    private Integer sid;

    private Date leavetime;

    private Date backtime;

    private String remark;

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getLeaveschoolid() {
        return leaveschoolid;
    }

    public void setLeaveschoolid(Integer leaveschoolid) {
        this.leaveschoolid = leaveschoolid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public Date getBacktime() {
        return backtime;
    }

    public void setBacktime(Date backtime) {
        this.backtime = backtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}