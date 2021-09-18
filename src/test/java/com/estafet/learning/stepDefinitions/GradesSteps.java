package com.estafet.learning.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.estafet.learning.stepDefinitions.utils.Helper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GradesSteps {

    private static final int STUDENT_ID_INDEX = 1;
    private static final int SUBJECT_ID_INDEX = 3;

    @When("Fill {string} table with random grades between {int} and {int} for each student for each subject")
    public void fillTableWithRandomGrades(String tableName, int min, int max) {
        // iterate over students table
        // for each student iterate over subjects table and for each subject add a grade in grades table
        System.out.println("Filling grades table with entries");
        ResultSet rs;
        try {
            List<Integer> listWithStudents = new ArrayList<>();
            rs = Helper.selectFromTable("students");

            fillLitWithIDs(rs, listWithStudents, STUDENT_ID_INDEX);
            rs = Helper.selectFromTable("subjects");
            //Helper.printResultSet(rs);
            List<Integer> listWithSubjectIDs = new ArrayList<>();

            fillLitWithIDs(rs, listWithSubjectIDs, SUBJECT_ID_INDEX);

            String currentQuerry;
            for (int studentId : listWithStudents) {
                for (int subjectID : listWithSubjectIDs) {
                    currentQuerry = createInsertStatement(studentId, subjectID, getRandomGrade(min, max));
                    System.out.println(currentQuerry);
                    //log.info(currentQuerry);
                    Helper.getStatement().executeUpdate(currentQuerry);
                    System.out.println("adding another grade for current student");
                }
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void fillLitWithIDs(ResultSet rs, List<Integer> list, int columnIndex) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt(columnIndex);
            list.add(id);
        }
    }

    private int getRandomGrade(int min, int max) {
        return (int) ((Math.random() * (max + 1 - min)) + min);
    }

    private String createInsertStatement(int studentId, int subjectID, int grade) {
        return "INSERT INTO `grades` VALUES (" + studentId + ", " + subjectID + ", " + grade + ");";
    }

    @Then("I can calculate the average grade for {string} class")
    public void calculateAverageGrade(String subject) {
        String currentsSubjectID = "";
        ResultSet rs = Helper.selectFromTable("subjects", "name", subject);
        while (true) {
            try {
                if (!rs.next()) break;
                currentsSubjectID = rs.getString(SUBJECT_ID_INDEX);
                break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        rs = Helper.selectFromTable("grades", "subjectid", currentsSubjectID);

        int rsWithGradesCount = 0; //total count of math grades
        int sumOfAllGrades = 0; //sum of all Math grades
        try {
            while (rs.next()) {
                rsWithGradesCount++;
                sumOfAllGrades += rs.getInt(SUBJECT_ID_INDEX);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        double finalResult = (1.0 * sumOfAllGrades) / rsWithGradesCount;
        System.out.println("Average Math grade = " + finalResult);
    }
}
