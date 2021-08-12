package utils;

import java.sql.*;

public class Helper {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void printResultSet(ResultSet rs) throws SQLException {
        // Prepare metadata object and get the number of columns.
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();

        // Print column names (a header).
        for (int i = 1; i <= columnsNumber; i++) {
            if (i > 1) System.out.print(" | ");
            System.out.print(rsmd.getColumnName(i));
        }
        System.out.println("");

        StringBuilder sb = new StringBuilder();
        int rowsSelected = 0;
        while (rs.next()) {
            rowsSelected++;
            for (int i = 1; i <= columnsNumber; i++) {

                if (i > 1) sb.append(" | ");
                sb.append(rs.getString(i));
                System.out.print(rs.getString(i));
            }
            System.out.println("");
            sb.append(System.lineSeparator());
        }

        System.out.println(rowsSelected);
        System.out.println(sb.toString());
    }

    public static ResultSet selectFromTable(String tableToSelectFrom) {
        try {
            return statement.executeQuery("SELECT * FROM " + tableToSelectFrom);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet selectFromTable(String tableToSelectFrom, String columnName, String whereClause) {
        ResultSet rs = null;
        try {
            statement.executeQuery("SELECT * FROM " + tableToSelectFrom + "Where");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean isConnectionEstablished() {
        if (connection == null | statement == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "Seenee#1");
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
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

    public static Statement getStatement() {
        return statement;
    }

    public static void deleteEntries(String dataTable){
        try {
            connection.prepareStatement("DELETE FROM dataTable;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
