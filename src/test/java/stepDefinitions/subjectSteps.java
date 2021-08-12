package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Helper;

import java.sql.*;

import static org.junit.Assert.*;

public class subjectSteps {

    @Given("Table is created and I see some records")
    public void tableIsCreatedAndISeeSomeRecords() {
        assertTrue("Could not connect to database!", Helper.isConnectionEstablished());
    }

    @When("I insert {string} with {int}")
    public void insertEntry(String subjectName, Integer year) {
        try {
            Helper.getStatement().executeUpdate("INSERT INTO subjects\n" +
                    "VALUES ('" + subjectName + "', " + year + ");");
        } catch (SQLException e) {
            e.printStackTrace();
            assertFalse("Could not insert data into database table", false);
        }
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
}
