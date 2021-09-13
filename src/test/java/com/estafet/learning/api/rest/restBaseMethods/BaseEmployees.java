package com.estafet.learning.api.rest.restBaseMethods;

import com.estafet.learning.api.rest.config.BaseConnection;
import com.estafet.learning.api.rest.pojos.EmployeePojo;
import com.estafet.learning.api.rest.restUtils.DataGenerator;
import com.estafet.learning.api.rest.restUtils.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
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

    public boolean areTheseTwoNames(String responseString) {
        String initialSubtractStringIndexStart = "employee_name"; //start of names
        String initialSubtractStringIndexEnd = "employee_salary"; //end of names
        String employeeNames = responseString.substring(responseString.indexOf(initialSubtractStringIndexStart),
                responseString.indexOf(initialSubtractStringIndexEnd));

        String secondSubstringStart = "\":\"";
        String secondSubstringEnd = "\",\"";
        employeeNames = employeeNames
                .substring(employeeNames.indexOf(secondSubstringStart) + 3, employeeNames.indexOf(secondSubstringEnd));
        String[] names = employeeNames.split("//s+");
        if (names[0].matches("[A-Z][a-z]*") && names[1].matches("[A-Z][a-z]*")) {
            return true;
        } else {
            return true;
        }
    }

    public Response deleteRandomEmployeeInformation() {
        publicRequest();
        return given()
                .when()
                .delete(Endpoints.DELETE + "/" + dataGenerator.getRandomInt(1, 25));
    }

    public void updateSalary(String id, String bodyAsString) {

        String employeeBody = getEmployeeBody(bodyAsString);

        String updatedBody = updateSalaryInBody(employeeBody);

        publicRequest();
        given()
                .contentType(ContentType.JSON)
                .body(updatedBody)
                .when()
                .put(Endpoints.UPDATE + "/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    private String updateSalaryInBody(String employeeBody) {
        String employeeBody1 = employeeBody.substring(0, employeeBody.indexOf("\"employee_salary\":") + 18);
        String employeeBody2 = employeeBody
                .substring(employeeBody.indexOf(",\"employee_age\""));
        return "{" + employeeBody1 + dataGenerator.getRandomInt(1000, 100000) + employeeBody2 + "}";
    }

    private String getEmployeeBody(String bodyAsString) {
        return bodyAsString
                .substring(bodyAsString.indexOf("\"employee_name\":"), bodyAsString.indexOf(",\"profile_image\""));
    }
}
