package com.team6.dva.model;

import java.util.List;

public class Concert {

    private int showNo;
    private String showName;
    private String showInfo;
    private String showDate;
    private String payStart;
    private String payEnd;
    private int price;

    public Concert() {
    }

    public Concert(int showNo, String showName, String showInfo, String showDate, String payStart, String payEnd, int price) {
        this.showNo = showNo;
        this.showName = showName;
        this.showInfo = showInfo;
        this.showDate = showDate;
        this.payStart = payStart;
        this.payEnd = payEnd;
        this.price = price;
    }

    public int getShowNo() {
        return showNo;
    }

    public void setShowNo(int showNo) {
        this.showNo = showNo;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(String showInfo) {
        this.showInfo = showInfo;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getPayStart() {
        return payStart;
    }

    public void setPayStart(String payStart) {
        this.payStart = payStart;
    }

    public String getPayEnd() {
        return payEnd;
    }

    public void setPayEnd(String payEnd) {
        this.payEnd = payEnd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "showNo=" + showNo +
                ", showName='" + showName + '\'' +
                ", showInfo='" + showInfo + '\'' +
                ", showDate='" + showDate + '\'' +
                ", payStart='" + payStart + '\'' +
                ", payEnd='" + payEnd + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
