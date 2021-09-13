package com.estafet.learning.api.soap.config;

import com.estafet.learning.api.soap.soapBaseMethods.BaseCalculator;

public class SoapManager {
    private BaseCalculator baseCalculator;

    public BaseCalculator getBaseCalculator() {
        return (baseCalculator == null) ? new BaseCalculator() : baseCalculator;
    }

}
