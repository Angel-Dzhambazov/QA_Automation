package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UpdateSteps {
    private static int randomEntryUniqueID;
    private static int followingEntryOfRandomOne;
    private static int quantityToCopy;
    private static double priceToCopy;

    @When("I pick a random product from {string}")
    public void pickRandomEntryFromTable(String tableName) {
        ResultSet rs = Helper.selectFromTable(tableName);
        int countOfTotalEntries = Helper.getTotalEntriesInResultSet(rs);
        //returns a number [0, countOfTotalEntries)
        int randomEntry = (int) ((Math.random() * (countOfTotalEntries)) + 0);
        System.out.println("randomEntry = " + randomEntry);
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getUniqueID(tableName, randomEntry);
    }


    @And("I get quantity and price from next item")
    public void getValuesAndUpdate() {
        String tableName = "products";
        ResultSet rs = Helper.selectFromTable(tableName, "product_code", Integer.toString(followingEntryOfRandomOne));


        try {
            rs.next();
            quantityToCopy = rs.getInt(4);
            priceToCopy = rs.getDouble(5);
            System.out.println("quantityToCopy = " + quantityToCopy);
            System.out.println("priceToCopy = " + priceToCopy);
            rs.close();

            /*
            rs = Helper.selectFromTable(tableName, "product_code", Integer.toString(followingEntryOfRandomOne));
            Helper.printResultSet(rs);
             */
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void getUniqueID(String tableName, int rowCounter) {
        ResultSet rs = Helper.selectFromTable(tableName);
        int tempCounter = 0;

        while (true) {
            try {
                if (tempCounter == rowCounter) {
                    randomEntryUniqueID = rs.getInt(1);
                    System.out.println("randomEntryUniqueID = " + randomEntryUniqueID);

                } else if (tempCounter == rowCounter + 1) {
                    followingEntryOfRandomOne = rs.getInt(1);
                    System.out.println("followingEntryOfRandomOne = " + followingEntryOfRandomOne);
                }
                tempCounter++;
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }


    @Then("the needed item should have the update information")
    public void checkForUpdatedInformation() {
        String tableName = "products";
        ResultSet rs = Helper.selectFromTable(tableName, "product_code", Integer.toString(followingEntryOfRandomOne));

        int actualQuantity;
        double actualPrice;

        try {
            rs.next();
            actualQuantity = rs.getInt(4);
            actualPrice = rs.getDouble(5);
            System.out.println("actualQuantity = " + actualQuantity);
            System.out.println("actualPrice = " + actualPrice);
            rs.close();

            boolean isQuantityAsExpected = actualPrice == priceToCopy;
            assertTrue("Quantity is not as expected", isQuantityAsExpected);

            boolean isPriceAsExpected = Double.compare(priceToCopy, actualPrice) == 0;
            assertTrue("Price is not as expected", isPriceAsExpected);


            /*
            rs = Helper.selectFromTable(tableName, "product_code", Integer.toString(followingEntryOfRandomOne));
            Helper.printResultSet(rs);
             */
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @And("I delete this product")
    public void deleteSelectedEntry() {
        String deleteSelectedEntry =
                "DELETE FROM products WHERE product_code = " + followingEntryOfRandomOne + ";";
        assertTrue("Could not delete picked entry!", Helper.executeUpdateQueryBoolean(deleteSelectedEntry));
    }

    @Then("This product should not exist anymore")
    public void checkForProduct() {

        ResultSet rs = Helper.selectFromTable("products", "product_code", String.valueOf(followingEntryOfRandomOne));
        int totalRowsInThisRS = Helper.getTotalEntriesInResultSet(rs);

        assertEquals("Product is still visible", 0, totalRowsInThisRS);
    }

    @And("I update {string};")
    public void updateProduct(String type) {
        String sqlUpdateQuery = "";

        switch (type) {
            case "products":
                sqlUpdateQuery =
                        "UPDATE `products` SET quantity = " + quantityToCopy + ", price = " + priceToCopy +
                                " WHERE product_code = " + randomEntryUniqueID + ";";
                break;
            case "customers":
                break;
            default:
                break;

        }
        assertTrue("Could not update random Query", Helper.executeUpdateQueryBoolean(sqlUpdateQuery));
    }

}
