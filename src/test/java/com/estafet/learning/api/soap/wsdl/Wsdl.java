package com.estafet.learning.api.soap.wsdl;

import com.eviware.soapui.impl.WsdlInterfaceFactory;
import com.eviware.soapui.impl.wsdl.*;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.model.iface.Response;
import com.eviware.soapui.support.SoapUIException;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Wsdl {

    public static void main(String[] args) throws Exception {


//        String endPointUrl = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL";


        WsdlProject project = new WsdlProject();
        /*
        WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, endPointUrl);
        WsdlInterface wsdl = wsdls[0];


        for (Operation operation : wsdl.getOperationList()) {
            WsdlOperation op = (WsdlOperation) operation;
            System.out.println("OP:" + op.getName());
            System.out.println(op.createRequest(true));
            System.out.println("Response:");
            System.out.println(op.createResponse(true));
        }


        WsdlOperation op = (WsdlOperation) operation;
        WsdlRequest wsdlRequest = op.addNewRequest();

        wsdlRequest.setUsername();
        wsdlRequest.setPassword();
        wsdlRequest.setWssPasswordType();

        wsdlRequest.setTimeout(String.valueOf(TimeUnit.HOURS.toMillis(3L)));
        String requestXML = "";
        wsdlRequest.setRequestContent(requestXML);
        WsdlSubmitContext wsdlSubmitContext = new WsdlSubmitContext(wsdlRequest);
        WsdlSubmit<?> submit = wsdlRequest.submit(wsdlSubmitContext, false);
        Response response = submit.getResponse();
        soapResponse = response.getContentAsString();


         */
    }
}
