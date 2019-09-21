package com.agoi.pojo;

import javax.persistence.Transient;

public class Drug {
    private Integer drId;

    private String drUrl;

    private Integer drInprice;

    private Integer drOutprice;

    private String drName;

    private Integer drType;

    private String drSimDesc;

    private String drTime;

    private String drDetaDesc;

    private String drFactory;

    private String drDirection;

    private String drRemark;

    private Integer drNumber;

    private String drStatusMap;

    public String getDrStatusMap() {
        return drStatusMap;
    }

    public void setDrStatusMap(String drStatusMap) {
        this.drStatusMap = drStatusMap;
    }

    //drugStatus
    @Transient
    private DrugStatus drugStatus;

    public DrugStatus getDrugStatus() {
        return drugStatus;
    }

    public void setDrugStatus(DrugStatus drugStatus) {
        this.drugStatus = drugStatus;
    }




    public Integer getDrId() {
        return drId;
    }

    public void setDrId(Integer drId) {
        this.drId = drId;
    }

    public String getDrUrl() {
        return drUrl;
    }

    public void setDrUrl(String drUrl) {
        this.drUrl = drUrl == null ? null : drUrl.trim();
    }

    public Integer getDrInprice() {
        return drInprice;
    }

    public void setDrInprice(Integer drInprice) {
        this.drInprice = drInprice;
    }

    public Integer getDrOutprice() {
        return drOutprice;
    }

    public void setDrOutprice(Integer drOutprice) {
        this.drOutprice = drOutprice;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName == null ? null : drName.trim();
    }

    public Integer getDrType() {
        return drType;
    }

    public void setDrType(Integer drType) {
        this.drType = drType;
    }

    public String getDrSimDesc() {
        return drSimDesc;
    }

    public void setDrSimDesc(String drSimDesc) {
        this.drSimDesc = drSimDesc == null ? null : drSimDesc.trim();
    }

    public String getDrTime() {
        return drTime;
    }

    public void setDrTime(String drTime) {
        this.drTime = drTime == null ? null : drTime.trim();
    }

    public String getDrDetaDesc() {
        return drDetaDesc;
    }

    public void setDrDetaDesc(String drDetaDesc) {
        this.drDetaDesc = drDetaDesc == null ? null : drDetaDesc.trim();
    }

    public String getdrFactory() {
        return drFactory;
    }

    public void setdrFactory(String drFactory) {
        this.drFactory = drFactory == null ? null : drFactory.trim();
    }

    public String getDrDirection() {
        return drDirection;
    }

    public void setDrDirection(String drDirection) {
        this.drDirection = drDirection == null ? null : drDirection.trim();
    }

    public String getDrRemark() {
        return drRemark;
    }

    public void setDrRemark(String drRemark) {
        this.drRemark = drRemark == null ? null : drRemark.trim();
    }

    public Integer getDrNumber() {
        return drNumber;
    }

    public void setDrNumber(Integer drNumber) {
        this.drNumber = drNumber;
    }
}