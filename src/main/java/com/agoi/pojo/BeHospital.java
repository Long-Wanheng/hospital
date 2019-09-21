package com.agoi.pojo;

public class BeHospital {
    private Integer behId;

    private String behNursepeople;

    private String behPatbed;

    private Integer behAntecedent;

    private String behIllness;

    private Integer behCloseprice;

    private Integer behState;

    public Integer getBehId() {
        return behId;
    }

    public void setBehId(Integer behId) {
        this.behId = behId;
    }

    public String getBehNursepeople() {
        return behNursepeople;
    }

    public void setBehNursepeople(String behNursepeople) {
        this.behNursepeople = behNursepeople == null ? null : behNursepeople.trim();
    }

    public String getBehPatbed() {
        return behPatbed;
    }

    public void setBehPatbed(String behPatbed) {
        this.behPatbed = behPatbed == null ? null : behPatbed.trim();
    }

    public Integer getBehAntecedent() {
        return behAntecedent;
    }

    public void setBehAntecedent(Integer behAntecedent) {
        this.behAntecedent = behAntecedent;
    }

    public String getBehIllness() {
        return behIllness;
    }

    public void setBehIllness(String behIllness) {
        this.behIllness = behIllness == null ? null : behIllness.trim();
    }

    public Integer getBehCloseprice() {
        return behCloseprice;
    }

    public void setBehCloseprice(Integer behCloseprice) {
        this.behCloseprice = behCloseprice;
    }

    public Integer getBehState() {
        return behState;
    }

    public void setBehState(Integer behState) {
        this.behState = behState;
    }
}