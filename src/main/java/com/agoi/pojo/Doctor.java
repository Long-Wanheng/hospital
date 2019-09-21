package com.agoi.pojo;

import java.util.Date;

public class Doctor {
    private Integer dId;

    private String dDoctorName;

    private String dIdcard;

    private String dPhone;

    private String dTelphone;

    private Integer dSex;

    private Date dBirthday;

    private Integer dAge;

    private String dEmail;

    private Integer dKeshi;

    private String dXueli;

    private String dDesc;

    private Date dInTime;

    private Integer dState;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getdDoctorName() {
        return dDoctorName;
    }

    public void setdDoctorName(String dDoctorName) {
        this.dDoctorName = dDoctorName == null ? null : dDoctorName.trim();
    }

    public String getdIdcard() {
        return dIdcard;
    }

    public void setdIdcard(String dIdcard) {
        this.dIdcard = dIdcard == null ? null : dIdcard.trim();
    }

    public String getdPhone() {
        return dPhone;
    }

    public void setdPhone(String dPhone) {
        this.dPhone = dPhone == null ? null : dPhone.trim();
    }

    public String getdTelphone() {
        return dTelphone;
    }

    public void setdTelphone(String dTelphone) {
        this.dTelphone = dTelphone == null ? null : dTelphone.trim();
    }

    public Integer getdSex() {
        return dSex;
    }

    public void setdSex(Integer dSex) {
        this.dSex = dSex;
    }

    public Date getdBirthday() {
        return dBirthday;
    }

    public void setdBirthday(Date dBirthday) {
        this.dBirthday = dBirthday;
    }

    public Integer getdAge() {
        return dAge;
    }

    public void setdAge(Integer dAge) {
        this.dAge = dAge;
    }

    public String getdEmail() {
        return dEmail;
    }

    public void setdEmail(String dEmail) {
        this.dEmail = dEmail == null ? null : dEmail.trim();
    }

    public Integer getdKeshi() {
        return dKeshi;
    }

    public void setdKeshi(Integer dKeshi) {
        this.dKeshi = dKeshi;
    }

    public String getdXueli() {
        return dXueli;
    }

    public void setdXueli(String dXueli) {
        this.dXueli = dXueli == null ? null : dXueli.trim();
    }

    public String getdDesc() {
        return dDesc;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc == null ? null : dDesc.trim();
    }

    public Date getdInTime() {
        return dInTime;
    }

    public void setdInTime(Date dInTime) {
        this.dInTime = dInTime;
    }

    public Integer getdState() {
        return dState;
    }

    public void setdState(Integer dState) {
        this.dState = dState;
    }


}