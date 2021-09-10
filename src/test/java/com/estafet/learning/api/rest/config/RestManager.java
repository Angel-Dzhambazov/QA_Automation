package com.estafet.learning.api.rest.config;

import com.estafet.learning.api.rest.restBaseMethods.BaseEmployees;

public class RestManager {
    private BaseEmployees baseEmployees;

    public BaseEmployees getBaseEmployees() {
        return (baseEmployees == null) ? new BaseEmployees() : baseEmployees;
    }
}
