package com.Model;

public class WebTable {
    private String company;
    private String group;
    private String prevClose;
    private String currentPrice;
    private String change;


    public WebTable() {}
    public WebTable(String company,String group, String prevClose, String currentPrice, String change) {
        this.company = company;
        this.group = group;
        this.prevClose = prevClose;
        this.currentPrice = currentPrice;
        this.change = change;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPrevClose() {
        return prevClose;
    }

    public void setPrevClose(String prevClose) {
        this.prevClose = prevClose;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(String currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }
}
