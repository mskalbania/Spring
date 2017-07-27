package com.spring.mvc.currencies;

import java.math.BigDecimal;

public class Rate {

    private String no;
    private String effectiveDate;
    private BigDecimal mid;

    public Rate() {
    }

    public Rate(String no, String effectiveDate, BigDecimal mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }

    @Override
    public String toString(){
        return "DATE: " + effectiveDate + " MID: " + mid.toString();
    }
}
