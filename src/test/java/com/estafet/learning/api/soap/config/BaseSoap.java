package com.estafet.learning.api.soap.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.net.URI;

import static io.restassured.RestAssured.*;
import static com.estafet.learning.api.utilsAPI.RequestResponseListener.requestLoggingFilter;
import static com.estafet.learning.api.utilsAPI.RequestResponseListener.responseLoggingFilter;

public class BaseSoap {
    private URI baseUrl;

    public void soapRequest(String soapUrl) {
        baseUrl = URI.create(soapUrl);
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

    public Response baseSoap(String soapUrl, String soapBody) {
        soapRequest(soapUrl);
        return given()
                .contentType("text/xml;charset=UTF-8;")
                .body(soapBody)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK).extract().response();
    }
}
