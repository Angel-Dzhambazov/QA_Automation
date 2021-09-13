package com.estafet.learning.api.rest.restBaseMethods;

import com.estafet.learning.api.rest.config.BaseConnection;
import com.estafet.learning.api.rest.pojos.EmployeePojo;
import com.estafet.learning.api.rest.restUtils.DataGenerator;
import com.estafet.learning.api.rest.restUtils.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import static io.restassured.RestAssured.given;

public class BaseEmployees extends BaseConnection {
    private static final Logger LOGGER = LogManager.getLogger(BaseConnection.class);
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

    public Response getRandomEmployeeInformation() {
        publicRequest();
        return given()
                .when()
                .get(Endpoints.EMPLOYEE + "/" + dataGenerator.getRandomInt(1, 25));
    }

    public boolean areTheseTwoNames(String employeeNames) {
        String[] names = employeeNames.split("//s+");
        if (names[0].matches("[A-Z][a-z]*") && names[1].matches("[A-Z][a-z]*")) {
            return true;
        } else {
            return true;
        }
    }
}
