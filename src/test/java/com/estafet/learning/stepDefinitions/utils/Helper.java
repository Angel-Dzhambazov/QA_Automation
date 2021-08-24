package com.estafet.learning.stepDefinitions.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void printResultSet(ResultSet rs) throws SQLException {
        // Prepare metadata object and get the number of columns.
        ResultSetMetaData rsmd = null;

        rsmd = rs.getMetaData();

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

    public static ResultSet selectFromTable(String tableToSelectFrom) {
        try {
            return getStatement().executeQuery("SELECT * FROM " + tableToSelectFrom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean selectFromTableBoolean(String tableToSelectFrom) {
        try {
            getStatement().executeQuery("SELECT * FROM " + tableToSelectFrom);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet selectFromTable(String tableToSelectFrom, String columnName, String value) {
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM `" + tableToSelectFrom + "` WHERE `" + columnName + "` = '" + value + "';";
            System.out.println("Select Where query = " + query);
            rs = getStatement().executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Could not select any entry!");
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean isConnectionEstablished() {
        if (connection == null | statement == null) {
            connectToDatabase();
        }
        return connection != null;
    }

    public static int getTotalEntriesInTable(String table) {
        int result = 0;
        ResultSet rs = selectFromTable(table);
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            result++;
        }
        return result;
    }

    public static int getTotalEntriesInResultSet(ResultSet rs) {
        int result = 0;
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            result++;
        }
        return result;
    }

    public static Statement getStatement() {
        if (connection == null | statement == null) {
            connectToDatabase();
        }
        return statement;
    }

    public static boolean deleteEntries(String dataTable) {
        try {
            String query = "DELETE FROM " + dataTable;
            int deletedRows = getStatement().executeUpdate(query);
            if (deletedRows > 0) {
                System.out.println("Deleted All Rows In The Table Successfully...");
                return true;
            } else {
                System.out.println("Table already empty.");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean doesTableExist(String tableName) {
        ResultSet resultSet = null;
        try {
            String query = SqlQueryBuilder.doesTableExistQuery(tableName);
            System.out.println("SQL Query: does table exist:\n" + query);
            resultSet = getStatement().executeQuery(query);
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static List<String> generateListFromStringArgs(String... parameter) {
        return new ArrayList<>(Arrays.asList(parameter));
    }

    public static ResultSet executeQuery(String query) {
        try {
            return getStatement().executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static boolean executeUpdateQueryBoolean(String query) {
        int result = -9999;

        try {
            System.out.println("Update query is: " + query);
            result = getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result >= 0;
    }

    private static void connectToDatabase() {
        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "Estafet#1");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "Seenee#1");
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int getRandomUniqueIDFromTable(String tableName) {
        ResultSet rs = Helper.selectFromTable(tableName);
        int countOfTotalEntries = Helper.getTotalEntriesInResultSet(rs);
        //returns a number [0, countOfTotalEntries)
        int randomEntry = (int) ((Math.random() * (countOfTotalEntries)) + 0);
        //System.out.println("randomEntry = " + randomEntry);
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        rs = Helper.selectFromTable(tableName);
        int tempCounter = 0;
        int randomUniqueIDFromTable = -999;
        try {
            while (rs.next()) {
                if (tempCounter == randomEntry) {
                    randomUniqueIDFromTable = rs.getInt(1);
                    System.out.println("randomUniqueIDFromTable " + tableName + " = " + randomUniqueIDFromTable);
                }
                tempCounter++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return randomUniqueIDFromTable;
    }

    public static double getPriceForItem(int product_code) {
        double result = -999.0;
        ResultSet rs = Helper.selectFromTable("products", "product_code", String.valueOf(product_code));
        try {
            rs.next();
            result = rs.getDouble(5);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
