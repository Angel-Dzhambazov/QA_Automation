package com.estafet.learning.api.rest.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.net.URI;


import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.reset;

import static com.estafet.learning.api.utilsAPI.RequestResponseListener.requestLoggingFilter;
import static com.estafet.learning.api.utilsAPI.RequestResponseListener.responseLoggingFilter;

public class BaseConnection {
    private URI baseUrl;

    public void publicRequest() {
//        baseUrl = URI.create(PropertyFileReader.getInstance("api.properties").getProperty("API_GATEWAY"));
        baseUrl = URI.create("http://dummy.restapiexample.com/api/v1");
        reset();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl.toString())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(requestLoggingFilter)
                .addFilter(responseLoggingFilter)
                .setRelaxedHTTPSValidation()
                .build();
    }
}
