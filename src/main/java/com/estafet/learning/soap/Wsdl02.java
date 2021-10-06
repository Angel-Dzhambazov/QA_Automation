package com.estafet.learning.soap;


import java.util.concurrent.TimeUnit;

public class Wsdl02 {
    private static final String GET_CONTINENTS = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.oorsprong.org/websamples.countryinfo\">\n" +
            "   <soapenv:Header/>\n" +
            "   <soapenv:Body>\n" +
            "      <web:ListOfContinentsByCode/>\n" +
            "   </soapenv:Body>\n" +
            "</soapenv:Envelope>";

    public static void main(String[] args) throws Exception {


//        WsdlProject project = new WsdlProject("this should fail");
//
//        String urlWsdl = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL";
//
//        WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, urlWsdl);
//        WsdlInterface wsdl = wsdls[0];
//
//        String soapResponse;
//        String currentOperation = "currentOperation";
//
//        for (Operation operation : wsdl.getOperationList()) {
//            WsdlOperation op = (WsdlOperation) operation;
//            WsdlRequest wsdlRequest = op.addNewRequest(currentOperation);
//
//            This public API does not need authorisation therefore I am not using credentials
//            wsdlRequest.setUsername(userName);
//            wsdlRequest.setPassword();
//            wsdlRequest.setWssPasswordType();
//
//
//            wsdlRequest.setTimeout(String.valueOf(TimeUnit.HOURS.toMillis(3L)));
//            String requestXML = GET_CONTINENTS;
//            wsdlRequest.setRequestContent(requestXML);
//            WsdlSubmitContext wsdlSubmitContext = new WsdlSubmitContext(wsdlRequest);
//            WsdlSubmit<?> submit = wsdlRequest.submit(wsdlSubmitContext, false);
//            Response response = submit.getResponse();
//            soapResponse = response.getContentAsString();
//            System.out.println(soapResponse);
//        }


    }

}
