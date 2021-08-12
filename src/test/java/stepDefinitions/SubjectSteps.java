package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Helper;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

public class SubjectSteps {
    private static List<List<String>> subjectsEntries = null;

    @Given("Table is created and I see some records")
    public void tableIsCreatedAndISeeSomeRecords() {
        assertTrue("Could not connect to database!", Helper.isConnectionEstablished());
    }

    @Then("data should be visible with select from datatable")
    public void dataShouldBeVisibleWithSelectFromDatatable() {
        ResultSet rs = null;
        try {
            rs = Helper.selectFromTable("testdatabase.subjects");
            //ResultSetMetaData rsmd = rs.getMetaData();
            Helper.printResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            assertFalse("Could not insert data into database table", false);
        }
    }

    @And("Total entries in {string} table should be {int}")
    public void areThereAnyEntries(String table, int expectedCount) {
        assertEquals("Entries in the table are not as expected!", expectedCount, Helper.getTotalEntriesInTable(table));
    }

    @When("I clear test entries")
    public void clearTestEntries() {
    }

    @When("I insert subjectName with year")
    public void iInsertSubjectNameWithYear(DataTable table) {
        subjectsEntries = table.asLists(String.class);

        for (List<String> columns : subjectsEntries) {
            String subjectName = columns.get(0);
            String year = columns.get(1);
            try {
                Helper.getStatement().executeUpdate("INSERT INTO subjects (name,year)\n" +
                        "VALUES ('" + subjectName + "', " + Integer.valueOf(year) + ");");
            } catch (SQLException e) {
                e.printStackTrace();
                assertFalse("Could not insert data into database table", false);
            }
        }
        System.out.println("Successfully inserted subjects into data table");
    }

    @And("I delete test data from {string}")
    public void iDeleteTestDataFrom(String table) {
        assertTrue("Could not delete entries from " + table + "!", Helper.deleteEntries(table));
        subjectsEntries = null;
    }
}
