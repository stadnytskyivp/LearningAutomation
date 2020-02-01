package com.lits.stadnytskyi.http;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.lits.stadnytskyi.lits.LitsHttpClient;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lits.stadnytskyi.lits.LitsHttpClient.convert;

public class TestGetGoogle {

    // init http client
    private LitsHttpClient client = new LitsHttpClient();

    @Test
    public void testGetGoogle() throws IOException {

        // Execute Request / Obtain response
        Response getGoogleResponse = client.GET ("https://google.com");
        String responseContentType = getGoogleResponse.header("Content-Type");
        Assert.assertEquals(getGoogleResponse.code(), 200);
        Assert.assertEquals(responseContentType, "text/html; charset=ISO-8859-1");

    }


    @Test
    public void testGetCurrencyExchangeRate() throws IOException {

        String url = "https://bank.gov.ua/NBU_Exchange/exchange?date=20.01.2020&json";
        Response getNbuResponse = client.GET(url);
        CurrencyRate[] currencyRates = convert(getNbuResponse,CurrencyRate[].class);

        for (CurrencyRate currencyRate : currencyRates){
            System.out.println(currencyRate);
        }

        // Create
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // Response string
        String string = getNbuResponse.body().string();

        // Tells Jackson how to read array
        CollectionType collectionType = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, CurrencyRate.class);

        for (CurrencyRate currencyRate : currencyRates) {
            System.out.println(currencyRate);
        }

        // HOMEWORK WRITE ASSERTS
        // Check Currency rate by currency code
        // USD amount is 24.2527
    }

    @Test
    public void testLogin() throws IOException {

        // 1 DOWNLOAD POSTMAN
        // 2 REGISTER USER (via POSTMAN)
        // 3 ACTIVATE USER (via EMAIL)

        // 4 LOGIN USER (via JAVA CODE)

        // Request URL
        String url = "https://europe-west2-search-app-263e2.cloudfunctions.net/webapp/api/auth/login";

        // BODY
        HashMap<String, String> body = new HashMap<>();
        body.put("email","surgoot92@gmail.com");
        body.put("password","Qwerty123456");

        // POST and receive response
        Response loginResponse = client.POST(url, Headers.of(), body);

        // 5 CONVERT RESPONSE TO JAVA MODEL
        final Map<String, Map<String, String>> loginResponseData = convert(loginResponse, Map.class);



    }

    public static class  CurrencyRate {
        @JsonProperty("StartDate")
        private String StartDate;
        @JsonProperty("TimeSign")
        private String TimeSign;
        @JsonProperty("CurrencyCode")
        private String CurrencyCode;
        @JsonProperty("CurrencyCodeL")
        private String CurrencyCodeL;
        @JsonProperty("Units")
        private String Units;
        @JsonProperty("Amount")
        private String Amount;

        public String getStartDate() {
            return StartDate;
        }

        public void setStartDate(String startDate) {
            StartDate = startDate;
        }

        public String getTimeSign() {
            return TimeSign;
        }

        public void setTimeSign(String timeSign) {
            TimeSign = timeSign;
        }

        public String getCurrencyCode() {
            return CurrencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            CurrencyCode = currencyCode;
        }

        public String getCurrencyCodeL() {
            return CurrencyCodeL;
        }

        public void setCurrencyCodeL(String currencyCodeL) {
            CurrencyCodeL = currencyCodeL;
        }

        public String getUnits() {
            return Units;
        }

        public void setUnits(String units) {
            Units = units;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String amount) {
            Amount = amount;
        }

        @Override
        public String toString() {
            return "CurrencyRate{" +
                    "StartDate='" + StartDate + '\'' +
                    ", TimeSign='" + TimeSign + '\'' +
                    ", CurrencyCode='" + CurrencyCode + '\'' +
                    ", CurrencyCodeL='" + CurrencyCodeL + '\'' +
                    ", Units='" + Units + '\'' +
                    ", Amount='" + Amount + '\'' +
                    '}';
        }
    }
}