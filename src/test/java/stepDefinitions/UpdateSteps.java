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
    private static String customersPhone;

    @When("I pick a random entry from {string}")
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

    @And("I get quantity and price from next {string}")
    public void getValuesAndUpdate(String tableName) {
        ResultSet rs = null;

        switch (tableName) {
            case "products":
                rs = Helper.selectFromTable(tableName, "product_code", Integer.toString(followingEntryOfRandomOne));
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
                break;

            case "customers":
                rs = Helper.selectFromTable(tableName, "customer_number", Integer.toString(followingEntryOfRandomOne));
                try {
                    rs.next();
                    customersPhone = rs.getString(4);
                    System.out.println("customersPhone = " + customersPhone);
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                System.out.println("ERROR: Switch case could not catch what to do!");
                break;
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
                    break;
                }
                tempCounter++;
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }


    @Then("the needed item should have the update information in {string}")
    public void checkForUpdatedInformation(String tableName) {

        ResultSet rs;
        switch (tableName) {
            case "products":
                rs = Helper.selectFromTable(tableName, "product_code", Integer.toString(randomEntryUniqueID));
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
                } catch (
                        SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "customers":
                rs = Helper.selectFromTable(tableName, "customer_number", Integer.toString(randomEntryUniqueID));
                String actualPhone;
                try {
                    rs.next();
                    actualPhone = rs.getString(4);
                    boolean isPhoneAsExpected = actualPhone.equals(customersPhone);
                    assertTrue("Phone is not as updated!", isPhoneAsExpected);
                } catch (
                        SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                System.out.println("ERROR: Switch case could not catch what to do!");
                break;
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
                sqlUpdateQuery =
                        "UPDATE `customers` SET phone = '" + customersPhone + "' WHERE customer_number = " +
                                randomEntryUniqueID + ";";
                break;
            default:
                System.out.println("ERROR: Switch case could not catch what to do!");
                break;

        }
        assertTrue("Could not update random Query", Helper.executeUpdateQueryBoolean(sqlUpdateQuery));
    }

    @And("I print all information for this {string}")
    public void iPrintAllInformationForThis(String tableName) {
        ResultSet rs;

        switch (tableName) {
            case "products":
                rs = Helper.selectFromTable(tableName, "product_code", String.valueOf(randomEntryUniqueID));
                try {
                    Helper.printResultSet(rs);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "customers":
                rs = Helper.selectFromTable(tableName, "customer_number", String.valueOf(randomEntryUniqueID));
                try {
                    Helper.printResultSet(rs);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                System.out.println("ERROR: Switch case could not catch what to do!");
                break;
        }
    }
}
