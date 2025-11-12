package com.team6.dva.model;

import java.util.List;

public class Concert {

    private int show_no;
    private String show_name;
    private String show_info;
    private String show_date;
    private String pay_start;
    private String pay_end;

    public Concert() {
    }

    public Concert(int show_no, String show_name, String show_info, String show_date, String pay_start, String pay_end) {
        this.show_no = show_no;
        this.show_name = show_name;
        this.show_info = show_info;
        this.show_date = show_date;
        this.pay_start = pay_start;
        this.pay_end = pay_end;
    }

    public int getShow_no() {
        return show_no;
    }

    public void setShow_no(int show_no) {
        this.show_no = show_no;
    }

    public String getShow_name() {
        return show_name;
    }

    public void setShow_name(String show_name) {
        this.show_name = show_name;
    }

    public String getShow_info() {
        return show_info;
    }

    public void setShow_info(String show_info) {
        this.show_info = show_info;
    }

    public String getShow_date() {
        return show_date;
    }

    public void setShow_date(String show_date) {
        this.show_date = show_date;
    }

    public String getPay_start() {
        return pay_start;
    }

    public void setPay_start(String pay_start) {
        this.pay_start = pay_start;
    }

    public String getPay_end() {
        return pay_end;
    }

    public void setPay_end(String pay_end) {
        this.pay_end = pay_end;
    }
}
