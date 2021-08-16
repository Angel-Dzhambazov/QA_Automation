package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void printResultSet(ResultSet rs) throws SQLException {
        // Prepare metadata object and get the number of columns.
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        // Print column names (a header).
        for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) System.out.print(" | "); // appending a divider between column names
            System.out.print(rsmd.getColumnName(i)); //printing column name
        }
        System.out.println(""); //new line after finishing all elements in resultSet row. (i.e. system line separator)

        StringBuilder sb = new StringBuilder();
        int rowsSelected = 0; //counting rows in resultSet
        while (rs.next()) {
            rowsSelected++;
            for (int i = 1; i <= columnsNumber; i++) {

                if (i > 1) sb.append(" | ");
                sb.append(rs.getString(i));
                System.out.print(rs.getString(i)); //printing column name
            }
            System.out.println(""); //new line after finishing all elements in resultSet row.
            sb.append(System.lineSeparator());
        }

        System.out.println("Total rows in current ResultSet = " + rowsSelected);
        System.out.println("The database table looks like this: ");
        System.out.println(sb.toString());
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
            result = getStatement().executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result >= 0;
    }

    private static void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "Estafet#1");
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
