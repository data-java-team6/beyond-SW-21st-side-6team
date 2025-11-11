package com.team6.dva.model;

public class User {
    private String userId;
    private String pwd;
    private String userName;
    private int deposit;

    public User(String userId, String pwd, String userName, int deposit) {
        this.userId = userId;
        this.pwd = pwd;
        this.userName = userName;
        this.deposit = deposit;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
}
