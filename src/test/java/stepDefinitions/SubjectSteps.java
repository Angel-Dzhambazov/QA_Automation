package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Helper;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

public class SubjectSteps {
//    private static List<List<String>> subjectsEntries = null;

    @Given("Table {string} is created")
    public void isTableCreated(String tableName) {
        System.out.println("Establishing connection with database");
        assertTrue("Could not connect to database!", Helper.isConnectionEstablished());
        assertTrue("Table " + tableName + " does not exist!", Helper.doesTableExist(tableName));
    }

    @And("Total entries in {string} table should be greater or equal to {int}")
    public void areThereAnyEntries(String table, int expectedCount) {
        System.out.println("Checking for minimum amount of entries");
        assertTrue("Entries in the table are not as expected!", Helper.getTotalEntriesInTable(table) >= expectedCount);
    }

    @Then("data should be visible with manipulated table {string}")
    public void successfullyStoredEntries(String tableName) {
        ResultSet rs = null;
        try {
            rs = Helper.selectFromTable("testdatabase." + tableName);
            //ResultSetMetaData rsmd = rs.getMetaData();
            Helper.printResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            assertFalse("Could not insert data into database table", false);
        }
    }

    @And("I delete test data from {string}")
    public void deleteEntriesFromTable(String table) {
        assertTrue("Could not delete entries from " + table + "!", Helper.deleteEntries(table));
    }


}
