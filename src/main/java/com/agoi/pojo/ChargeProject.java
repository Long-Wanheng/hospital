package com.agoi.pojo;

public class ChargeProject {
    private Integer chapId;

    private String chapName;

    private Integer chapMoney;

    public Integer getChapId() {
        return chapId;
    }

    public void setChapId(Integer chapId) {
        this.chapId = chapId;
    }

    public String getChapName() {
        return chapName;
    }

    public void setChapName(String chapName) {
        this.chapName = chapName == null ? null : chapName.trim();
    }

    public Integer getChapMoney() {
        return chapMoney;
    }

    public void setChapMoney(Integer chapMoney) {
        this.chapMoney = chapMoney;
    }
}