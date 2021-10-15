package com.estafet.learning.stepDefinitions.oracleVsMySqlSteps;

import com.estafet.learning.jdbc.DAO;
import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.dataBase.OracleDriver;
import com.estafet.learning.jdbc.dataBase.PostgreSqlDriver;
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
    private static PostgreSqlDriver postgreSqlDriver;

    private static DAO sqlDao;
    private static DAO oracleDao;
    private static DAO postgreDao;

    List<String> mySqlTables;
    List<String> oracleTables;
    List<String> postgreTables;

    Map<String, Integer> mySqlTableNamesAndEntriesCount;
    Map<String, Integer> oracleTableNamesAndEntriesCount;
    Map<String, Integer> postgreTableNamesAndEntriesCount;

    List<Integer> ids;

    @Given("^successful connection to MySQL database (.*)$")
    public void successfulConnectionToMySQLDatabaseTable(String tableName) {

    }

    @Given("Established connection to {string} and {string} databases.")
    public void connectToMySqlAndOracle(String db1, String db2) {
        // MySQL
        // Oracle
        connectToGivenDB(db1);
        connectToGivenDB(db2);

        createDaoObject(db1);
        createDaoObject(db2);
    }

    private void createDaoObject(String dbType) {
        switch (dbType) {
            case "MySQL":
                sqlDao = new DAO(mySqlDriver);
                Assert.assertNotNull("Could not Create MySQL Dao object!", sqlDao);
                break;
            case "Oracle":
                oracleDao = new DAO(oracleDriver);
                Assert.assertNotNull("Could not Create Oracle Dao object!", oracleDao);
                break;
            case "Postgre":
                postgreDao = new DAO(postgreSqlDriver);
                Assert.assertNotNull("Could not Create Postgre Dao object!", postgreDao);
                break;
            default:
                Assert.fail("Could not establish type of database!");
                break;
        }
    }


    @When("Information about tables is collected.")
    public void collectTableInfo() {
        if (mySqlDriver != null) {
            System.out.println("Collect table information!");
            mySqlTables = sqlDao.getHelper().selectAllTables();

            int countOfSqlTables = mySqlTables.size();
            System.out.println("countOfSqlTables = " + countOfSqlTables);
            Assert.assertTrue("No tables are present in MySQL Database!", countOfSqlTables > 0);

            System.out.println("count entries in mySQL DB!");
            mySqlTableNamesAndEntriesCount = new HashMap<>();
            for (String tableName : mySqlTables) {
                int countOfEntries = sqlDao.getHelper().getTotalEntriesOfTable(tableName);
                System.out.println("tableName + countOfEntries = " + tableName + " " + countOfEntries);
                mySqlTableNamesAndEntriesCount.put(tableName.toLowerCase(), countOfEntries);
            }
        }

        if (oracleDriver != null) {
            oracleTables = oracleDao.getHelper().selectAllTables();
            int countOfOracleTables = oracleTables.size();
            System.out.println("countOfOracleTables = " + countOfOracleTables);
            Assert.assertTrue("No tables are present in Oracle Database!", countOfOracleTables > 0);

            oracleTableNamesAndEntriesCount = new HashMap<>();

            System.out.println("count entries in oracle DB!");
            for (String tableName : oracleTables) {
                int countOfEntries = oracleDao.getHelper().getTotalEntriesOfTable(tableName);
                System.out.println("tableName + countOfEntries = " + tableName + " " + countOfEntries);
                oracleTableNamesAndEntriesCount.put(tableName.toLowerCase(), countOfEntries);
            }
        }

        if (postgreSqlDriver != null) {
            System.out.println("Collect table information from postgreSQL!");
            postgreTables = postgreDao.getHelper().selectAllTables();

            int countOfPostgreTables = postgreTables.size();
            System.out.println("countOfPostgreTables = " + countOfPostgreTables);
            Assert.assertTrue("No tables are present in Postgre Database!", countOfPostgreTables > 0);

            System.out.println("count entries in Postgre DB!");
            postgreTableNamesAndEntriesCount = new HashMap<>();
            for (String tableName : postgreTables) {
                int countOfEntries = postgreDao.getHelper().getTotalEntriesOfTable(tableName);
                System.out.println("tableName + countOfEntries = " + tableName + " " + countOfEntries);
                postgreTableNamesAndEntriesCount.put(tableName.toLowerCase(), countOfEntries);
            }
        }
    }

    @Then("Count of tables and rows should be equal.")
    public void compareEntryCount() {
        if (postgreSqlDriver == null) {
            Assert.assertEquals("Count of tables is not the same!", mySqlTables.size(), oracleTables.size());
            for (String tableName : mySqlTableNamesAndEntriesCount.keySet()) {
                int sqlEntriesInTable = mySqlTableNamesAndEntriesCount.get(tableName);
                int oracleEntriesInTable = oracleTableNamesAndEntriesCount.get(tableName);
                Assert.assertEquals("Count of entries is not the same!", sqlEntriesInTable, oracleEntriesInTable);
            }
        } else {
            Assert.assertEquals("Count of tables is not the same!", mySqlTables.size(), postgreTables.size());
            for (String tableName : mySqlTableNamesAndEntriesCount.keySet()) {
                int sqlEntriesInTable = mySqlTableNamesAndEntriesCount.get(tableName);
                int postgreEntriesInTable = postgreTableNamesAndEntriesCount.get(tableName);
                Assert.assertEquals("Count of entries is not the same!", sqlEntriesInTable, postgreEntriesInTable);
            }
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

        List<Customer> customersAsListPostgre = new ArrayList();
        List<Product> productsAsListPostgre = new ArrayList();
        List<Checklist> checklistsAsListsPostgre = new ArrayList();

        for (Integer currentId : ids) {
            if (mySqlDriver != null) {
                customersAsListMySQL.add(sqlDao.getHelper().selectCustomerById(currentId));
                productsAsListMySQL.add(sqlDao.getHelper().selectProductById(currentId));
                checklistsAsListsMySQL.add(sqlDao.getHelper().selectChecklistById(currentId));
            }

            if (oracleDriver != null) {
                customersAsListOracle.add(sqlDao.getHelper().selectCustomerById(currentId));
                productsAsListOracle.add(sqlDao.getHelper().selectProductById(currentId));
                checklistsAsListsOracle.add(sqlDao.getHelper().selectChecklistById(currentId));
            }

            if (postgreSqlDriver != null) {
                customersAsListPostgre.add(postgreDao.getHelper().selectCustomerById(currentId));
                productsAsListPostgre.add(postgreDao.getHelper().selectProductById(currentId));
                checklistsAsListsPostgre.add(postgreDao.getHelper().selectChecklistById(currentId));
            }
        }


        boolean compareCustomers = false;
        boolean compareProducts = false;
        boolean compareChecklists = false;

        if (postgreSqlDriver == null) { //compare MySql vs Oracle
            compareCustomers = customersAsListMySQL.equals(customersAsListOracle);
            compareProducts = productsAsListMySQL.equals(productsAsListOracle);
            compareChecklists = checklistsAsListsMySQL.equals(checklistsAsListsOracle);
        } else if (oracleDriver == null) { //compare MySql vs Postgre
            compareCustomers = customersAsListMySQL.equals(customersAsListPostgre);
            compareProducts = productsAsListMySQL.equals(productsAsListPostgre);
            compareChecklists = checklistsAsListsMySQL.equals(checklistsAsListsPostgre);
        }

        Assert.assertFalse("Tables are equal!", compareCustomers);
        Assert.assertFalse("Tables are equal!", compareProducts);
        Assert.assertFalse("Tables are equal!", compareChecklists);
    }

    private static void connectToGivenDB(String dbType) {
        switch (dbType) {
            case "MySQL":
                mySqlDriver = new MySqlDriver();
                Assert.assertNotNull("Could not establish MySQL connection!", mySqlDriver);
                break;
            case "Oracle":
                oracleDriver = new OracleDriver();
                Assert.assertNotNull("Could not establish Oracle connection!", oracleDriver);
                break;
            case "Postgre":
                postgreSqlDriver = new PostgreSqlDriver();
                Assert.assertNotNull("Could not establish Postgre connection!", postgreSqlDriver);
                break;
            default:
                Assert.fail("Could not establish type of database!");
                break;
        }
    }


}
