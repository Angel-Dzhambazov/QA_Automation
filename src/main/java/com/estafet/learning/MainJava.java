package com.estafet.learning;

import java.sql.*;


public class MainJava {
    private static String dynamicText = "";

    public static void main(String[] args) {
        System.out.println("we are here 13");
        try {


//step1 load the driver class


            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName).newInstance();
            String nameForConnect = "sys as sysdba";
            String pass = "secret";


//step2 create  the connection object
            String oracleUsername = "moroncho";
            String oraclePassword = "moroncho";
            String oracleSysAsSYSDBA = "SYS AS SYSDBA";
            String oracleDefaultPass = "secret";
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "SYS AS SYSDBA", "secret");

//            String url = "jdbc:oracle:thin:@192.168.0.1:1521:ORCL";
//            Connection conn = DriverManager.getConnection(url, nameForConnect, pass);

//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query
            ResultSet rs = stmt.executeQuery("select * from INITIAL_TEST_TABLE");
            printResultSet(rs);

            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

//step5 close the connection object
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("we are here 36");

    }

    private static void printResultSet(ResultSet rs) throws SQLException {
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
}
