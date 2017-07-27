package com.spring.mvc.currencies;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


public class NBPConnectionService {

    private static final String NPBUrl = "http://api.nbp.pl/api/exchangerates/rates/a";

    public static String getContent(String startingDate, String endingDate, String currencyType) {

        String output = null;

        try {

            String requestUrl = NPBUrl + "/" + currencyType.toLowerCase() + "/" +
                    startingDate + "/" + endingDate;

            HttpClient client = HttpClientBuilder.create().build();

            HttpGet request = new HttpGet(requestUrl);

            HttpResponse response = client.execute(request);

            output = IOUtils.toString(response.getEntity().getContent(), "UTF-8");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return output;
    }


}
