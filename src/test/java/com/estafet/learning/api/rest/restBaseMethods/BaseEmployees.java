package com.estafet.learning.api.rest.restBaseMethods;

import com.estafet.learning.api.rest.config.BaseConnection;
import com.estafet.learning.api.rest.pojos.EmployeePojo;
import com.estafet.learning.api.rest.restUtils.DataGenerator;
import com.estafet.learning.api.rest.restUtils.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseEmployees extends BaseConnection {
    DataGenerator dataGenerator = new DataGenerator();

    public Response getAllEmployees() {
        publicRequest();
        return given()
                .when()
                .get(Endpoints.EMPLOYEES);
    }

    public Response createNewEmployee(EmployeePojo employee) {
        publicRequest();
        return given()
                .contentType(ContentType.JSON)
                .body(employee, ObjectMapperType.JACKSON_2)
                .when()
                .post(Endpoints.CREATE);
    }

    public void getEmployeeInformation() {
        publicRequest();
        given()
                .when()
                .get(Endpoints.EMPLOYEE + "/" + dataGenerator.getRandomInt(1, 25))
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
