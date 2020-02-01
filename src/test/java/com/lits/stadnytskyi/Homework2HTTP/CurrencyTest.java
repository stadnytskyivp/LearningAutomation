package com.lits.stadnytskyi.Homework2HTTP;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CurrencyTest {

    public static class CurrencyRate {
        @JsonProperty("StartDate")
        private String StartDate;
        @JsonProperty("TimeSign")
        private String TimeSign;
        @JsonProperty("CurrencyCode")
        private String CurrencyCode;
        @JsonProperty("CurrencyCodeL")
        private String CurrencyCodeL;
        @JsonProperty("Units")
        private int Units;
        @JsonProperty("Amount")
        private BigDecimal Amount;

        @Override
        public String toString() {
            return "CurrencyRate{" +
                    "StartDate='" + StartDate + '\'' +
                    ", TimeSign='" + TimeSign + '\'' +
                    ", CurrencyCode='" + CurrencyCode + '\'' +
                    ", CurrencyCodeL='" + CurrencyCodeL + '\'' +
                    ", Units=" + Units +
                    ", Amount=" + Amount +
                    '}';
        }


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
            TimeSign = TimeSign;
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

        public int getUnits() {
            return Units;
        }

        public void setUnits(int units) {
            Units = units;
        }

        public BigDecimal getAmount() {
            return Amount;
        }

        public void setAmount(BigDecimal amount) {
            Amount = amount;
        }
    }

    @Test
    public void testGetCurrencyExchangeRate() throws IOException {

        //Initialize Http client
        OkHttpClient okHttpClient = new OkHttpClient();

        //Prepare Http request
        Request getNBURequest = new Request.Builder().url("https://bank.gov.ua/NBU_Exchange/exchange?date=20.01.2020&json").build();

        //Execute reques
        // t/get response
        Response getNBUResponse = okHttpClient.newCall(getNBURequest).execute();

        //Create
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String string = getNBUResponse.body().string();

        // Tells Jackson how to read array
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, CurrencyRate.class);
        List<CurrencyRate> currencyRates = objectMapper.readValue(string, collectionType);

        for (CurrencyRate currencyRate : currencyRates) {
            if (currencyRate.getCurrencyCode().equals("840")) {
                System.out.println(currencyRate);
            }
        }
    }


}
