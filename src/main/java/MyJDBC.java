import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase", "root", "Seenee#1");

        Statement statement = connection.createStatement();


//        ResultSet rs = statement.executeQuery("SELECT * FROM stocks LIMIT 10");

        ResultSet rs = statement.executeQuery("SELECT * FROM subjects\n" +
                "WHERE name = 'cucumber';");

        ResultSetMetaData rsmd = rs.getMetaData();

        /*
        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()){
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }


         */

        PrintColumnTypes.printColTypes(rsmd);
        System.out.println("");

        int numberOfColumns = rsmd.getColumnCount();

        for (int i = 1; i <= numberOfColumns; i++) {
            if (i > 1) System.out.print(",  ");
            String columnName = rsmd.getColumnName(i);
            System.out.print(columnName);
        }
        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue);
            }
            System.out.println("");
        }
    }
}

class PrintColumnTypes  {

    public static void printColTypes(ResultSetMetaData rsmd)
            throws SQLException {
        int columns = rsmd.getColumnCount();
        for (int i = 1; i <= columns; i++) {
            int jdbcType = rsmd.getColumnType(i);
            String name = rsmd.getColumnTypeName(i);
            System.out.print("Column " + i + " is JDBC type " + jdbcType);
            System.out.println(", which the DBMS calls " + name);
        }
    }
}
