package com.team6.dva.common;

public class SearchCriteria {

    private String value;

    public SearchCriteria() {
    }

    public SearchCriteria(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                ", value='" + value + '\'' +
                '}';
    }
}
