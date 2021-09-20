package com.estafet.learning.stepDefinitions.oracleVsMySqlSteps;

import com.estafet.learning.jdbc.DAO;
import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.dataBase.OracleDriver;
import com.estafet.learning.stepDefinitions.utils.Helper;
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
        Assert.assertTrue("No tables are present in MySQL Database!", mySqlTables.size() > 0);
        oracleTables = oracleDao.getHelper().selectAllTables();
        Assert.assertTrue("No tables are present in Oracle Database!", oracleTables.size() > 0);

        mySqlTableNamesAndEntriesCount = new HashMap<>();
        for (String tableName : mySqlTables) {
            int countOfEntries = sqlDao.getHelper().getTotalEntriesOfTable(tableName);
            mySqlTableNamesAndEntriesCount.put(tableName, countOfEntries);
        }

        oracleTableNamesAndEntriesCount = new HashMap<>();

        for (String tableName : oracleTables) {
            int countOfEntries = oracleDao.getHelper().getTotalEntriesOfTable(tableName);
            mySqlTableNamesAndEntriesCount.put(tableName, countOfEntries);
        }


    }

    @Then("Count of tables and rows should be equal.")
    public void compareEntryCount() {
        Assert.assertEquals("Count of tables is not the same!", mySqlTables.size(), oracleTables.size());

        for (String tableName : mySqlTableNamesAndEntriesCount.keySet()) {
            int sqlEntriesInTable = mySqlTableNamesAndEntriesCount.get(tableName);
            int oracleEntriesInTable = oracleTableNamesAndEntriesCount.get(tableName);
            Assert.assertEquals("Count of entries is not the same!", sqlEntriesInTable, oracleEntriesInTable);
        }
    }
}
