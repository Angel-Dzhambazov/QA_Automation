package com.estafet.learning.api.utilsAPI;

import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static io.restassured.RestAssured.filters;

public class RequestResponseListener {
    public static RequestLoggingFilter requestLoggingFilter;
    public static ResponseLoggingFilter responseLoggingFilter;
    private static ByteArrayOutputStream request;
    private static ByteArrayOutputStream response;

    static {
        try {
            request = new ByteArrayOutputStream();
            response = new ByteArrayOutputStream();
            PrintStream requestStream = new PrintStream(request);
            PrintStream responseStream = new PrintStream(response);
            requestLoggingFilter = new RequestLoggingFilter(LogDetail.ALL, false, requestStream);
            responseLoggingFilter = new ResponseLoggingFilter(LogDetail.ALL, false, responseStream);
            filters(requestLoggingFilter, responseLoggingFilter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
