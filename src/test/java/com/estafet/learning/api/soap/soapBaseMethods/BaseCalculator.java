package com.estafet.learning.api.soap.soapBaseMethods;

import com.estafet.learning.api.soap.config.BaseSoap;
import managers.FileReaderManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static java.lang.String.format;

public class BaseCalculator extends BaseSoap {
    private static final Logger LOGGER = LogManager.getLogger(BaseCalculator.class);

    public int calculate(String function, int intA, int intB) {
        String calculatorURL = FileReaderManager.getInstance().configFileReader().getSoapURL();
        String soapBody = generateEnvelope(function, intA, intB);
        return Integer.parseInt(sendSoapEnvelope(calculatorURL, soapBody).xmlPath()
                .getString(format("Envelope.Body.%sResponse.%sResult", function, function)));
    }

    private String generateEnvelope(String function, int intA, int intB) {
        String result = String.format(
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                        "   <soapenv:Header/>\n" +
                        "   <soapenv:Body>\n" +
                        "      <tem:%s>\n" +
                        "         <tem:intA>%d</tem:intA>\n" +
                        "         <tem:intB>%d</tem:intB>\n" +
                        "      </tem:%s>\n" +
                        "   </soapenv:Body>\n" +
                        "</soapenv:Envelope>", function, intA, intB, function);
        LOGGER.debug("soap body:");
        LOGGER.debug(result);
        return result;
    }
}

