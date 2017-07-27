package com.spring.mvc.currencies;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;

public class CurrencyService {

    public enum CurrencyType {
        EUR, USD
    }

    public Currency getCurrencyRates(String startingDate, String endingDate, String currency) {

        String content = NBPConnectionService.getContent(startingDate, endingDate, currency);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(content, Currency.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Rate getMinRate(Currency currency) {
        Optional<Rate> min = currency.getRates()
                .stream()
                .min(Comparator.comparing(Rate::getMid));
        if(min.isPresent()){
            return min.get();
        }else {
            throw new RuntimeException("Rate list is empty!");
        }
    }

    public Rate getMaxRate(Currency currency){
        Optional<Rate> max = currency.getRates()
                .stream()
                .max(Comparator.comparing(Rate::getMid));
        if(max.isPresent()){
            return max.get();
        }else {
            throw new RuntimeException("Rate list is empty!");
        }
    }

}
