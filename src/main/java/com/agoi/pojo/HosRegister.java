package com.agoi.pojo;

import java.util.Date;

public class HosRegister {
    private Integer hosrId;

    private String hosrIdcard;

    private String hosrMedical;

    private Integer hosrRegPrice;

    private String hosrPhone;

    private Integer hosrSelfPrice;

    private Integer hosrSex;

    private Integer hosrAge;

    private String hosrWork;

    private String hosrLookDoctor;

    private Integer dId;

    private String hosrRemark;

    private Integer hosrState;

    private Date hosdate;

    private Integer deptid;

    private Doctor doctor;

    private Dept dept;

    public Integer getHosrId() {
        return hosrId;
    }

    public void setHosrId(Integer hosrId) {
        this.hosrId = hosrId;
    }

    public String getHosrIdcard() {
        return hosrIdcard;
    }

    public void setHosrIdcard(String hosrIdcard) {
        this.hosrIdcard = hosrIdcard == null ? null : hosrIdcard.trim();
    }

    public String getHosrMedical() {
        return hosrMedical;
    }

    public void setHosrMedical(String hosrMedical) {
        this.hosrMedical = hosrMedical == null ? null : hosrMedical.trim();
    }

    public Integer getHosrRegPrice() {
        return hosrRegPrice;
    }

    public void setHosrRegPrice(Integer hosrRegPrice) {
        this.hosrRegPrice = hosrRegPrice;
    }

    public String getHosrPhone() {
        return hosrPhone;
    }

    public void setHosrPhone(String hosrPhone) {
        this.hosrPhone = hosrPhone == null ? null : hosrPhone.trim();
    }

    public Integer getHosrSelfPrice() {
        return hosrSelfPrice;
    }

    public void setHosrSelfPrice(Integer hosrSelfPrice) {
        this.hosrSelfPrice = hosrSelfPrice;
    }

    public Integer getHosrSex() {
        return hosrSex;
    }

    public void setHosrSex(Integer hosrSex) {
        this.hosrSex = hosrSex;
    }

    public Integer getHosrAge() {
        return hosrAge;
    }

    public void setHosrAge(Integer hosrAge) {
        this.hosrAge = hosrAge;
    }

    public String getHosrWork() {
        return hosrWork;
    }

    public void setHosrWork(String hosrWork) {
        this.hosrWork = hosrWork == null ? null : hosrWork.trim();
    }

    public String getHosrLookDoctor() {
        return hosrLookDoctor;
    }

    public void setHosrLookDoctor(String hosrLookDoctor) {
        this.hosrLookDoctor = hosrLookDoctor == null ? null : hosrLookDoctor.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getHosrRemark() {
        return hosrRemark;
    }

    public void setHosrRemark(String hosrRemark) {
        this.hosrRemark = hosrRemark == null ? null : hosrRemark.trim();
    }

    public Integer getHosrState() {
        return hosrState;
    }

    public void setHosrState(Integer hosrState) {
        this.hosrState = hosrState;
    }

    public Date getHosdate() {
        return hosdate;
    }

    public void setHosdate(Date hosdate) {
        this.hosdate = hosdate;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

}