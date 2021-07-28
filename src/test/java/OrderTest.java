
import com.estafet.learning.Order;
import com.estafet.learning.TradeOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;


public class OrderTest {
    private static Logger log = Logger.getLogger(OrderTest.class.getName());
    private static Order testOrder;

    @Before
    public void setUp() throws Exception {
        testOrder = generateFullDefaultOrder(testOrder);

    }

    @Test
    public void testOrder() {
        log.info(testOrder.toString());

        log.info(testOrder.getItemPrice().toString());

    }

    private static TradeOrder generateFullDefaultOrder(Order order) {
        int orderNumber = 2021100;
        String clientDetails = "EstafetTestClient";
        List<String> listWithArticles = new ArrayList<>();
        String accountName = "JUnitTestAccount";
        String dateOfActivation = "28th July 2021";
        String billingCity = "Pazardzhik";
        int zipCode = 4400;
        boolean paymentMethod = true;
        String orderAuthorizedBy = "Angel Dzhambazov";
        String dateOfAuthorization = "28th July 2021";
        List<Double> itemPrices = new ArrayList<>(Arrays. asList(25.0, 15.0));

        return new TradeOrder(orderNumber, clientDetails, listWithArticles,accountName,dateOfActivation,billingCity,
                zipCode,paymentMethod,orderAuthorizedBy,dateOfAuthorization,itemPrices);
    }
}
