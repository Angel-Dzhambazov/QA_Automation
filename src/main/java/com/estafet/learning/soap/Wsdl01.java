package com.estafet.learning.soap;


import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;

public class Wsdl01 {
    public static void main(String[] args) throws Exception {


        String urlWsdl = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL";
        WsdlProject project = new WsdlProject();
        WsdlInterface[] wsdls = WsdlImporter.importWsdl(project, urlWsdl);
        WsdlInterface wsdl = wsdls[0];
    }
}
