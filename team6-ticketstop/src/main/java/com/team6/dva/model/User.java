package com.team6.dva.model;

public class User {

    private int memberNo;
    private String memberId;
    private String memberPw;
    private int balance;
    private String memberName;

    public User() {
    }

    public User(int memberNo, String memberId, String memberPw, int balance, String memberName) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.balance = balance;
        this.memberName = memberName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public void setMemberPw(String memberPw) {
        this.memberPw = memberPw;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "User{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPw='" + memberPw + '\'' +
                ", balance=" + balance +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
