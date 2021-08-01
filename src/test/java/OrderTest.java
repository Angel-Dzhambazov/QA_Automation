
import com.estafet.learning.Order;
import com.estafet.learning.TradeOrder;
import com.estafet.learning.exceptions.ArticleException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.Assert.*;



public class OrderTest {
    private static Logger log = Logger.getLogger(OrderTest.class.getName());
    private static Order testOrder;

    @Before
    public void setUp() throws Exception {
        testOrder = generateFullDefaultOrder(testOrder);
    }

    @Test
    public void testToStringMehtod() {
        log.info(testOrder.toString());

        String filePath = "E:\\Estafet\\QA_Automation\\src\\main\\resources\\test-default-values\\TradeInvoiceDefaultToString.txt";

        String expected = readLineByLine(filePath);
        String actual = testOrder.toString();
        boolean isToStringAsExpected = expected.equals(actual);
        assertTrue("toString method is not as expected!", isToStringAsExpected);

        //log.info(testOrder.getItemPrice().toString());

    }

    @Test
    public void addItemPrice(){
        //first check number of items
        // second check total price of all items
        // add an item with its price
        //check if total item price has increased with the price of the item


        int expectedNumberOfItems = 2;
        assertEquals("testOrder has unexpected number of items",expectedNumberOfItems,
                testOrder.getItemPrice().size());


        double expectedTotalPriceOfItems = 40.0;
        assertEquals("testOrder has unexpected number of items",0 ,
                Double.compare(expectedTotalPriceOfItems, testOrder.getTotalAmount()));
    }


    @Test
    public void addArticle(){
        //check for articles //getListWithArticles
        //add articles addArticleToListWithArticles()
        // check for new articles //getListWithArticles

        assertEquals("Unexpected number of articles in testOrder", 0, testOrder.getListWithArticles().size());

        try {
            testOrder.addArticleToListWithArticles("TestArticle");
        } catch (ArticleException e) {
            log.info(e.getMessage());
        }

        assertEquals("Unexpected number of articles in testOrder", 1, testOrder.getListWithArticles().size());

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
        List<Double> itemPrices = new ArrayList<>(Arrays.asList(25.0, 15.0));

        return new TradeOrder(orderNumber, clientDetails, listWithArticles, accountName, dateOfActivation, billingCity,
                zipCode, paymentMethod, orderAuthorizedBy, dateOfAuthorization, itemPrices);
    }

    //Read file content into the string with - Files.lines(Path path, Charset cs)

    private static String readLineByLine(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append(System.lineSeparator()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return contentBuilder.toString().trim();
    }



}
