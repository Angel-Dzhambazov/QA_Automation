package com.automatedTests.jUnitTests;

import com.estafet.learning.TradeInvoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

@Ignore
public class TradeInvoiceTest  {

    private static Logger log = Logger.getLogger(TradeInvoiceTest.class.getName());
    private static TradeInvoice testInvoice;

    @Before
    public void setUp() throws Exception {
        //initialize default TestInvoice
        testInvoice = generateDefaultInvoice();
    }

    @Test
    public void makeDiscount() {

        log.info("executing test #1");
        log.info("This is a warning message!");

        testInvoice.setItemPrice(new long[3]);
        long initialTotalAmountInvoice = testInvoice.getTotalAmountInvoice();
        log.info("initialTotalAmountInvoice = " + initialTotalAmountInvoice);
        testInvoice.discountCalculation();

        long discountedTotalAmountInvoice = testInvoice.getTotalAmountInvoice();
        log.info("discountedTotalAmountInvoice = " + discountedTotalAmountInvoice);

        assertEquals("this is not equal", discountedTotalAmountInvoice, initialTotalAmountInvoice);
    }

    @After
    public void tearDown() throws Exception {
        testInvoice = null;
    }

    private static TradeInvoice generateDefaultInvoice() {

        String clientDetailsInvoice = "TestClient";
        String[] listWithArticlesInvoice = new String[10];
        long totalAmountInvoice = 230;
        int invoiceNumber = 1;
        String bankAccountIndexInvoice = "BAII";
        int dateOfReleaseInvoice = 20210728;
        long businessDiscountInvoice = 0;
        int vaTInvoice = 17;

        return new TradeInvoice(clientDetailsInvoice, listWithArticlesInvoice, totalAmountInvoice, invoiceNumber,
                        bankAccountIndexInvoice,
                        dateOfReleaseInvoice, businessDiscountInvoice, vaTInvoice);
    }
}


