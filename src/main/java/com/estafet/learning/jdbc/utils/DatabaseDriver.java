package com.estafet.learning.jdbc.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseDriver implements DatabaseHelper {

    protected Connection setConnection(String jdbcURL, String username, String password) {
        try {
            return DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public void createTables() {

    }

    public void printResultSet(ResultSet rs) throws SQLException {
        // Prepare metadata object and get the number of columns.

        ResultSetMetaData rsmd = rs.getMetaData();

        StringBuilder sb = new StringBuilder();

        int columnsNumber = rsmd.getColumnCount();

        for (int i = 1; i <= columnsNumber; i++) {
            sb.append(" |"); // appending a divider between column names
            sb.append(rsmd.getColumnName(i)); //printing column name
        }
        //new line after finishing all elements in resultSet row. (i.e. system line separator)
        sb.append(System.lineSeparator());

        //System.out.println("");

        int rowsSelected = 0; //counting rows in resultSet
        while (rs.next()) {
            rowsSelected++;
            for (int i = 1; i <= columnsNumber; i++) {

                if (i > 1) sb.append(" | ");
                sb.append(rs.getString(i));
            }
            sb.append(System.lineSeparator());
        }
        if (rowsSelected > 0) {
            StringBuilder preBuilder = new StringBuilder();

            preBuilder.append("The database table looks like this: ");
            preBuilder.append(System.lineSeparator());
            preBuilder.append("Total rows in current ResultSet = " + rowsSelected);
            preBuilder.append(System.lineSeparator());
            preBuilder.append(sb);
            System.out.println(preBuilder);
        } else {
            System.out.println("No records returned");
        }
    }

    public List<String> extractListFromResultSet(ResultSet resultSet, int columnIndex) throws SQLException {
        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(resultSet.getString(columnIndex));
        }
        return result;
    }

}
