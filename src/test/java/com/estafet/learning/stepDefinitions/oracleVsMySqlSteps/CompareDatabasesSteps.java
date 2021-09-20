package com.estafet.learning.stepDefinitions.oracleVsMySqlSteps;

import com.estafet.learning.jdbc.DAO;
import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.dataBase.OracleDriver;
import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.stepDefinitions.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
        List<Customer> customersAsList = sqlDao.getHelper().selectAllCustomers();
        List<Product> productsAsList = sqlDao.getHelper().selectAllProducts();
        List<Checklist> checklistsAsList = sqlDao.getHelper().selectAllChecklists();
    }
}
