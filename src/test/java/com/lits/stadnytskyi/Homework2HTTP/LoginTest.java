package com.lits.stadnytskyi.Homework2HTTP;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest {

    public static class R{
        @JsonProperty("r")
        private AccessInfo r;

        public AccessInfo getR() {
            return r;
        }

        public void setR(AccessInfo r) {
            this.r = r;
        }

        @Override
        public String toString() {
            return "R{" +
                    "r=" + r +
                    '}';
        }
    }

    public static class AccessInfo{
        @JsonProperty("access_token")
        private String access_token;
        @JsonProperty("scope")
        private String scope;
        @JsonProperty("expires_in")
        private Integer expires_in;
        @JsonProperty("token_type")
        private String token_type;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public Integer getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(Integer expires_in) {
            this.expires_in = expires_in;
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        @Override
        public String toString() {
            return "AccessInfo{" +
                    "access_token='" + access_token + '\'' +
                    ", scope='" + scope + '\'' +
                    ", expires_in=" + expires_in +
                    ", token_type='" + token_type + '\'' +
                    '}';
        }
    }

    @Test
    public void testLogin() throws IOException {
        //Initialize Http client
        OkHttpClient okHttpClient = new OkHttpClient();

        Request postLogin = new Request.Builder()
                .url("https://europe-west2-search-app-263e2.cloudfunctions.net/webapp/api/auth/login")
                .post(RequestBody.create(MediaType.parse("application/json"), "{" +
                        "\t\"email\":\"surgoot92@gmail.com\",\n" +
                        "\t\"password\":\"Qwerty123456\"\n" +
                        "}")).build();

        Response response = okHttpClient.newCall(postLogin).execute();
        String temp = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        R r = objectMapper.readValue(temp, R.class);
        System.out.println(r.toString());

        Assert.assertEquals(response.code(), 200);
    }
}