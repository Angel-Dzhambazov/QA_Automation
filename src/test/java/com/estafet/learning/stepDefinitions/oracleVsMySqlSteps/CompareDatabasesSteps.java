package com.estafet.learning.stepDefinitions.oracleVsMySqlSteps;

import com.estafet.learning.jdbc.DAO;
import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.dataBase.OracleDriver;
import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.stepDefinitions.utils.Helper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompareDatabasesSteps {

    int randomID = -999;

    private static MySqlDriver mySqlDriver;
    private static OracleDriver oracleDriver;

    private static DAO sqlDao;
    private static DAO oracleDao;

    List<String> mySqlTables;
    List<String> oracleTables;

    Map<String, Integer> mySqlTableNamesAndEntriesCount;
    Map<String, Integer> oracleTableNamesAndEntriesCount;

    List<Integer> ids;

    @When("I pick a random {string}")
    public void pickRandomCustomer(String tableName) {
        randomID = Helper.getRandomUniqueIDFromTable(tableName);
    }

    @Given("^successful connection to MySQL database (.*)$")
    public void successfulConnectionToMySQLDatabaseTable(String tableName) {

    }

    @Given("Established connection to MySQL and Oracle databases.")
    public void connectToMySqlAndOracle() {
        mySqlDriver = new MySqlDriver();
        Assert.assertNotNull("Could not establish MySQL connection!", mySqlDriver);
        oracleDriver = new OracleDriver();
        Assert.assertNotNull("Could not establish Oracle connection!", oracleDriver);

        sqlDao = new DAO(mySqlDriver);
        Assert.assertNotNull("Could not Create MySQL Dao object!", sqlDao);
        oracleDao = new DAO(oracleDriver);
        Assert.assertNotNull("Could not Create Oracle Dao object!", oracleDao);
    }

    @When("Information about tables is collected.")
    public void collectTableInfo() {

        System.out.println("Collect table information!");
        mySqlTables = sqlDao.getHelper().selectAllTables();

        int countOfSqlTables = mySqlTables.size();
        System.out.println("countOfSqlTables = " + countOfSqlTables);
        Assert.assertTrue("No tables are present in MySQL Database!", countOfSqlTables > 0);

        oracleTables = oracleDao.getHelper().selectAllTables();
        int countOfOracleTables = oracleTables.size();
        System.out.println("countOfOracleTables = " + countOfOracleTables);
        Assert.assertTrue("No tables are present in Oracle Database!", countOfOracleTables > 0);


        System.out.println("count entries in mySQL DB!");
        mySqlTableNamesAndEntriesCount = new HashMap<>();
        for (String tableName : mySqlTables) {
            int countOfEntries = sqlDao.getHelper().getTotalEntriesOfTable(tableName);
            System.out.println("tableName + countOfEntries = " + tableName + " " + countOfEntries);
            mySqlTableNamesAndEntriesCount.put(tableName.toLowerCase(), countOfEntries);
        }

        oracleTableNamesAndEntriesCount = new HashMap<>();

        System.out.println("count entries in oracle DB!");
        for (String tableName : oracleTables) {
            int countOfEntries = oracleDao.getHelper().getTotalEntriesOfTable(tableName);
            System.out.println("tableName + countOfEntries = " + tableName + " " + countOfEntries);
            oracleTableNamesAndEntriesCount.put(tableName.toLowerCase(), countOfEntries);
        }


    }

    @Then("Count of tables and rows should be equal.")
    public void compareEntryCount() {
        Assert.assertEquals("Count of tables is not the same!", mySqlTables.size(), oracleTables.size());

        String debug = "";
        for (String tableName : mySqlTableNamesAndEntriesCount.keySet()) {
            int sqlEntriesInTable = mySqlTableNamesAndEntriesCount.get(tableName);
            int oracleEntriesInTable = oracleTableNamesAndEntriesCount.get(tableName);
            Assert.assertEquals("Count of entries is not the same!", sqlEntriesInTable, oracleEntriesInTable);
        }
    }

    @And("{int} random IDs are chosen")
    public void collectRandomEntries(int countOfEntries) {
        ids = new ArrayList();
        Faker faker = new Faker();
        while (ids.size() < 5) {
            int tempInt = faker.number().numberBetween(1, 10);
            if (!ids.contains(tempInt)) {
                ids.add(tempInt);
            }
        }
        System.out.println(ids);
    }

    @Then("data from MySQL and Oracle should be the same")
    public void compareObjects() {
        List<Customer> customersAsListMySQL = new ArrayList();
        List<Product> productsAsListMySQL = new ArrayList();
        List<Checklist> checklistsAsListsMySQL = new ArrayList();

        List<Customer> customersAsListOracle = new ArrayList();
        List<Product> productsAsListOracle = new ArrayList();
        List<Checklist> checklistsAsListsOracle = new ArrayList();

        for (Integer currentId : ids) {
            customersAsListMySQL.add(sqlDao.getHelper().selectCustomerById(currentId));
            productsAsListMySQL.add(sqlDao.getHelper().selectProductById(currentId));
            checklistsAsListsMySQL.add(sqlDao.getHelper().selectChecklistById(currentId));

            customersAsListOracle.add(sqlDao.getHelper().selectCustomerById(currentId));
            productsAsListOracle.add(sqlDao.getHelper().selectProductById(currentId));
            checklistsAsListsOracle.add(sqlDao.getHelper().selectChecklistById(currentId));
        }


        boolean compareCustomers = customersAsListMySQL.equals(customersAsListOracle);
        boolean compareProducts = productsAsListMySQL.equals(productsAsListOracle);
        boolean compareChecklists = checklistsAsListsMySQL.equals(checklistsAsListsOracle);

        Assert.assertFalse("Tables are equal!", compareCustomers);
        Assert.assertFalse("Tables are equal!", compareProducts);
        Assert.assertTrue("Tables are equal!", compareChecklists);
    }
}
