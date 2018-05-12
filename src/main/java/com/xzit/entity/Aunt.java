package com.xzit.entity;

public class Aunt {
    private Integer auntid;

    private String auntname;

    private String auntno;

    private String auntpassword;

    private String auntphoneno;

    private Integer buildingid;

    private Building building;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Integer getAuntid() {
        return auntid;
    }

    public void setAuntid(Integer auntid) {
        this.auntid = auntid;
    }

    public String getAuntname() {
        return auntname;
    }

    public void setAuntname(String auntname) {
        this.auntname = auntname == null ? null : auntname.trim();
    }

    public String getAuntno() {
        return auntno;
    }

    public void setAuntno(String auntno) {
        this.auntno = auntno == null ? null : auntno.trim();
    }

    public String getAuntpassword() {
        return auntpassword;
    }

    public void setAuntpassword(String auntpassword) {
        this.auntpassword = auntpassword == null ? null : auntpassword.trim();
    }

    public String getAuntphoneno() {
        return auntphoneno;
    }

    public void setAuntphoneno(String auntphoneno) {
        this.auntphoneno = auntphoneno == null ? null : auntphoneno.trim();
    }

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }
}