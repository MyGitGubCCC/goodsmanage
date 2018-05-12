package com.xzit.entity;

public class Building {
    private Integer buildingid;

    private String buildingno;

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }

    public String getBuildingno() {
        return buildingno;
    }

    public void setBuildingno(String buildingno) {
        this.buildingno = buildingno == null ? null : buildingno.trim();
    }
}