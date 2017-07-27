package com.spring.mvc.currencies;

import java.util.List;

public class Currency {

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public Currency() {
    }

    public Currency(String table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CURRENCY: " + currency + " (code: " + code + ") " + "RATES: { \n");
        rates.forEach(rate -> sb.append(rate + "\n"));
        sb.append("}");
        return sb.toString();
    }
}
