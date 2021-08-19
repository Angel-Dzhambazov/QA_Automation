package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.Helper;
import utils.SqlQueryBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneratingSteps {
    private static final String SUBJECTS_TABLE_NAME = "subjects";
    private static final String STUDENTS_TABLE_NAME = "students";
    private static final String PRODUCTS_TABLE_NAME = "products";
    private static final String CUSTOMERS_TABLE_NAME = "customers";
    private static final String CREATE_PRODUCTS_TABLE_QUERY = "CREATE TABLE `products` (\n" +
            "  `product_code` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `product_name` VARCHAR(45) NULL,\n" +
            "  `product_description` VARCHAR(45) NULL,\n" +
            "  `quantity` INT NULL,\n" +
            "  `price` DECIMAL(10,2) NULL,\n" +
            "  PRIMARY KEY (`product_code`));\n";

    private static final String CREATE_CUSTOMERS_TABLE_QUERY = "CREATE TABLE `testdatabase`.`customers` (\n" +
            "  `customer_number` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `first_name` VARCHAR(45) NOT NULL,\n" +
            "  `last_name` VARCHAR(45) NOT NULL,\n" +
            "  `phone` VARCHAR(45) NOT NULL,\n" +
            "  `address_line1` VARCHAR(45) NULL,\n" +
            "  `address_line2` VARCHAR(45) NULL,\n" +
            "  `city` VARCHAR(45) NULL,\n" +
            "  `postcode` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`customer_number`));";

    @Given("Successful generation of table {string};")
    public void createDataTable(String tableName) {
        switch (tableName) {
            case PRODUCTS_TABLE_NAME:
                if (Helper.doesTableExist(PRODUCTS_TABLE_NAME)) {
                    System.out.println("Table already created!");
                } else {
                    assertTrue("Could not generate table " + PRODUCTS_TABLE_NAME + "!",
                            Helper.executeUpdateQueryBoolean(CREATE_PRODUCTS_TABLE_QUERY));
                }
                break;
            case CUSTOMERS_TABLE_NAME:
                if (Helper.doesTableExist(CUSTOMERS_TABLE_NAME)) {
                    System.out.println("Table already created!");
                } else {
                    assertTrue("Could not generate table " + CUSTOMERS_TABLE_NAME + "!",
                            Helper.executeUpdateQueryBoolean(CREATE_CUSTOMERS_TABLE_QUERY));
                }
                break;
            case STUDENTS_TABLE_NAME:
            case SUBJECTS_TABLE_NAME:
                break;
            default:
                assertFalse("Could not find table to generate!", false);
                break;
        }
    }

    //complicated method for generating table and returning boolean
    private static boolean generateProductsTableQuery() {
        LinkedHashMap<String, String> columnNames = new LinkedHashMap<>();
        columnNames.put("product_code", "int");
        columnNames.put("product_name", "varchar(255)");
        columnNames.put("product_description", "varchar(255)");
        columnNames.put("quantity", "int");
        columnNames.put("price", "FLOAT");

        String createTableProducts = SqlQueryBuilder.createTableQuery(PRODUCTS_TABLE_NAME, columnNames);
        ResultSet rs = Helper.executeQuery(createTableProducts);
        return Helper.selectFromTableBoolean(PRODUCTS_TABLE_NAME);
    }

    @When("I add {string} into data table")
    public void addEntriesIntoTable(String tableName, DataTable dataTable) {
        switch (tableName) {
            case SUBJECTS_TABLE_NAME:
            case STUDENTS_TABLE_NAME:
                addEntryToStudentsOrSubjects(tableName, dataTable);
                break;
            case PRODUCTS_TABLE_NAME:
                addEntryToProducts(tableName, dataTable);
                break;
            case CUSTOMERS_TABLE_NAME:
                addEntryToCustomers(tableName, dataTable);
                break;
            default:
                System.out.println("Could not find such table!");

        }
        System.out.println("Successfully inserted subjects into data table");
    }

    private static void addEntryToStudentsOrSubjects(String tableName, DataTable table) {
        List<List<String>> subjectsEntries = table.asLists(String.class);

        for (List<String> columns : subjectsEntries) {
            String subjectName = columns.get(0);
            String year = columns.get(1);
            try {
                Helper.getStatement().executeUpdate("INSERT INTO " + tableName + " (name,year)\n" +
                        "VALUES ('" + subjectName + "', " + Integer.valueOf(year) + ");");
            } catch (SQLException e) {
                e.printStackTrace();
                assertFalse("Could not insert data into database table", false);
            }
        }
    }

    private static void addEntryToProducts(String tableName, DataTable table) {
        List<List<String>> subjectsEntries = table.asLists(String.class);

        for (List<String> columns : subjectsEntries) {
            String product_name = columns.get(0);
            String product_description = columns.get(1);
            int quantity = Integer.parseInt(columns.get(2));
            double price = Double.parseDouble(columns.get(3));


            try {
                Helper.getStatement().executeUpdate(
                        "INSERT INTO " + tableName + " (product_name, product_description, quantity, price)\n" +
                                "VALUES ('" + product_name + "', '" + product_description + "', " + quantity + ", " +
                                price + ");");
            } catch (SQLException e) {
                e.printStackTrace();
                assertFalse("Could not insert data into database table", false);
            }
        }
    }

    private static void addEntryToCustomers(String tableName, DataTable table) {
        List<List<String>> subjectsEntries = table.asLists(String.class);

        for (List<String> columns : subjectsEntries) {
            String first_name = columns.get(0);
            String last_name = columns.get(1);
            String phone = columns.get(2);
            String address_line1 = columns.get(3);
            String address_line2 = columns.get(4);
            String city = columns.get(5);
            String postcode = columns.get(6);
            try {
                Helper.getStatement().executeUpdate("INSERT INTO " + tableName +
                        " (first_name, last_name, phone, address_line1, address_line2, city, postcode)\n" +
                        "VALUES ('" + first_name + "', '" + last_name + "', '" + phone + "', '" + address_line1 +
                        "', '" + address_line2 + "', '" + city + "', '" + postcode + "' );");
            } catch (SQLException e) {
                e.printStackTrace();
                assertFalse("Could not insert data into database table", false);
            }
        }
    }
}
