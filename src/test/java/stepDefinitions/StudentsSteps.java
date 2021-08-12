package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Helper;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StudentsSteps {

    private static List<List<String>> studentsList = null;
    @Given("I have university with table {string}")
    public void iHaveUniversityWithTable(String tableName) {
        assertTrue("Could not connect to database!", Helper.isConnectionEstablished());
        assertTrue("Table " + tableName + " does not exist!", Helper.selectFromTableBoolean(tableName));
    }

    @When("I add students into students table")
    public void iAddStudentsIntoTable(DataTable table) {
        studentsList = table.asLists(String.class);

        for (List<String> columns : studentsList) {
            String studentName = columns.get(0);
            String year = columns.get(1);
            try {
                Helper.getStatement().executeUpdate("INSERT INTO students (name,year)\n" +
                        "VALUES ('" + studentName + "', " + Integer.valueOf(year) + ");");
            } catch (SQLException e) {
                e.printStackTrace();
                assertFalse("Could not insert data into database table", false);
            }
        }
        System.out.println("Successfully inserted subjects into data table");
    }

    @Then("I check for successfully class full with {string}")
    public void iCheckForSuccessfullyClassFullWith(String tableName) {
        int countOfStudents = Helper.getTotalEntriesInTable(tableName);
        assertTrue("There are no students in the class!", countOfStudents>0);
    }


}
