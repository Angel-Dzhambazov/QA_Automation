package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.*;

public class OracleDriver extends DatabaseDriver implements OracleQueries {

    private static Connection oracleConnection = null;
    private static Statement oracleStatement = null;


    public OracleDriver() {
        connect();
    }

    public void executeQuery(String query) {
         query = "CREATE TABLE checklistsssssss (\n" +
                 "    todo_id INT\n" +
                 ")";
        try {
            ResultSet rs = oracleStatement.executeQuery(query);
            System.out.println("printResultSet(rs)");
            //printResultSet(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createTables() {
        for (String tableName : TABLE_NAMES) {
            executeUpdateQueryBoolean(getCreateQuery(tableName));
            break;
        }
    }

    @Override
    public void connect() {
        if (oracleConnection == null) {
            oracleConnection = setConnection(
                    ConfigFileManager.getInstance().getOracleJDBC(),
                    ConfigFileManager.getInstance().getOracleUser(),
                    ConfigFileManager.getInstance().getOraclePassword());
            try {
                oracleStatement = oracleConnection.createStatement();
                System.out.println("Statement created!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void insertRandomCustomer(int numberOfCustomers) {
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = oracleConnection.prepareStatement(INSERT_INTO_CUSTOMERS);
                // "(name, address, website, credit_limit) VALUES (?, ?, ?, ?);";
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getAddress());
                preparedStatement.setString(3, customer.getWebsite());
                preparedStatement.setDouble(4, customer.getCreditLimit());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void insertRandomProduct(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            Product product = new Product();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = oracleConnection.prepareStatement(INSERT_INTO_PRODUCTS);
                // (name, description, list_price, category_id) VALUES (?, ?, ?, ?);"
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2, product.getDescription());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setInt(4, product.getCategoryID());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void insertRandomCheckList(int numberOfChecklists) {
        for (int i = 0; i < numberOfChecklists; i++) {
            Checklist checklist = new Checklist();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = oracleConnection.prepareStatement(INSERT_INTO_CHECKLISTS);
                //         "(name, cost, initiated_on, is_completed) VALUES (?, ?, ?, ?);";
                preparedStatement.setString(1, checklist.getName());
                preparedStatement.setDouble(2, checklist.getCost());
                preparedStatement.setString(3, checklist.getInitiatedOn());
                preparedStatement.setInt(4, checklist.getIsCompleted());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void executeUpdateQueryBoolean(String query) {
        try {
            System.out.println("Update query is: \n" + query);
            oracleStatement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
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
}
