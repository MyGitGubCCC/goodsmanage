package com.xzit.entity;

import java.util.List;

public class Student {
    private Integer sid;

    private String cardno;

    private String sno;

    private String spwd;

    private String sname;

    private String ssex;

    private String sphoneno;

    private String qq;

    private String homeadress;

    private Integer classid;

    private Integer dormitoryid;

    private Integer buildingid;

    private Integer bedno;

    //级联查询自己加的属性
    private Classinfo classinfo;
    private Dormitory dormitory;
    private Building building;

    //一个学生所有的物品
    private List<Goods> goods;
    //增加一个宿舍号它是由buildingno+dormitoryno得到的
    private String bandd;

    public String getBandd() {
        return bandd;
    }

    public void setBandd(String bandd) {
        this.bandd = bandd;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Classinfo getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(Classinfo classinfo) {
        this.classinfo = classinfo;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd == null ? null : spwd.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    public String getSphoneno() {
        return sphoneno;
    }

    public void setSphoneno(String sphoneno) {
        this.sphoneno = sphoneno == null ? null : sphoneno.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getHomeadress() {
        return homeadress;
    }

    public void setHomeadress(String homeadress) {
        this.homeadress = homeadress == null ? null : homeadress.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(Integer dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }

    public Integer getBedno() {
        return bedno;
    }

    public void setBedno(Integer bedno) {
        this.bedno = bedno;
    }
}