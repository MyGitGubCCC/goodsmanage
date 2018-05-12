package com.xzit.entity;

public class Role {
    private Integer roleid;

    private String rolename;

    private String rolepermission;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolepermission() {
        return rolepermission;
    }

    public void setRolepermission(String rolepermission) {
        this.rolepermission = rolepermission == null ? null : rolepermission.trim();
    }
}