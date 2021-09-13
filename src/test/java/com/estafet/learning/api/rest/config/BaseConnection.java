package com.estafet.learning.api.rest.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import managers.FileReaderManager;

import java.net.URI;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.reset;

import static com.estafet.learning.api.utilsAPI.RequestResponseListener.requestLoggingFilter;
import static com.estafet.learning.api.utilsAPI.RequestResponseListener.responseLoggingFilter;

public class BaseConnection {

    public void publicRequest() {
        URI baseUrl = URI.create(FileReaderManager.getInstance().configFileReader().getRestDummyApiURI());
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
