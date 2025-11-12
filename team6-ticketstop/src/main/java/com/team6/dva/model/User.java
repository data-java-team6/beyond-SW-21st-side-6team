package com.team6.dva.model;

public class User {

    private int member_no;
    private String member_id;
    private String member_pw;
    private int deposit;
    private int member_name;

    public User() {
    }

    public User(int member_no, String member_id, String member_pw, int deposit, int member_name) {

        this.member_no = member_no;
        this.member_id = member_id;
        this.member_pw = member_pw;
        this.deposit = deposit;
        this.member_name = member_name;
    }

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getMember_pw() {
        return member_pw;
    }

    public void setMember_pw(String member_pw) {
        this.member_pw = member_pw;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getMember_name() {
        return member_name;
    }

    public void setMember_name(int member_name) {
        this.member_name = member_name;
    }
}
