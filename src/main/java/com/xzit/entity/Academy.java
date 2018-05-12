package com.xzit.entity;

public class Academy {
    private Integer academyid;

    private String academyname;

    private Integer campusid;
    //另加的
    private Campus campus;

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Integer getAcademyid() {
        return academyid;
    }

    public void setAcademyid(Integer academyid) {
        this.academyid = academyid;
    }

    public String getAcademyname() {
        return academyname;
    }

    public void setAcademyname(String academyname) {
        this.academyname = academyname == null ? null : academyname.trim();
    }

    public Integer getCampusid() {
        return campusid;
    }

    public void setCampusid(Integer campusid) {
        this.campusid = campusid;
    }
}