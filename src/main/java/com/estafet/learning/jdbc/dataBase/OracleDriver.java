package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleDriver extends DatabaseDriver implements OracleQueries {

    private static Connection oracleConnection = null;
    private static Statement oracleStatement = null;


    public OracleDriver() {
        connect();
    }

    public void executeQuery(String query) {
        try {
            ResultSet rs = oracleStatement.executeQuery(query);
            System.out.println("printResultSet(rs)");
            //printResultSet(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public void insertRandomCheckList(Checklist checklist) throws SQLException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = oracleConnection.prepareStatement(INSERT_INTO_CHECKLISTS);
            //         "(name, cost, initiated_on, is_completed) VALUES (?, ?, ?, ?);";
            preparedStatement.setInt(1, checklist.getId());
            preparedStatement.setString(2, checklist.getName());
            preparedStatement.setDouble(3, checklist.getCost());
            preparedStatement.setString(4, checklist.getInitiatedOn());
            preparedStatement.setInt(5, checklist.getIsCompleted());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(checklist.getCreatedAt()));
            preparedStatement.setTimestamp(7, Timestamp.valueOf(checklist.getLastEditedAt()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertRandomProduct(Product product) throws SQLException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = oracleConnection.prepareStatement(INSERT_INTO_PRODUCTS);
//            "(product_id, name, description, list_price, category_id, MigratedTS, LastUpdatedTS) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getCategoryID());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(product.getCreatedAt()));
            preparedStatement.setTimestamp(7, Timestamp.valueOf(product.getLastEditedAt()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertRandomCustomer(Customer customer) throws SQLException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = oracleConnection.prepareStatement(INSERT_INTO_CUSTOMERS);
//            "(id, name, address, website, credit_limit, MigratedTS, LastUpdatedTS) VALUES (?, ?, ?, ?, ?, ?, ?);";
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getWebsite());
            preparedStatement.setDouble(5, customer.getCreditLimit());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(customer.getCreatedAt()));
            preparedStatement.setTimestamp(7, Timestamp.valueOf(customer.getLastEditedAt()));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void dropAllTables() {
        try {
            for (String tableName : TABLE_NAMES) {
                oracleStatement.execute(DROP_TABLE + tableName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
    public List<String> selectAllTables() {
        List<String> listWithTables = new ArrayList<>();
        try {
            ResultSet resultset = oracleStatement.executeQuery(SELECT_ALL_TABLES);
            return extractListFromResultSet(resultset, columnNameIndex);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listWithTables;
    }

    @Override
    public List<Checklist> selectAllChecklists() {
        return null;
    }

    @Override
    public List<Product> selectAllProducts() {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public int getTotalEntriesOfTable(String tableName) {
        ResultSet rs;
        try {
            rs = oracleStatement.executeQuery(SELECT_COUNT_FROM_TABLE + tableName);
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public void createTables() {
        for (String tableName : TABLE_NAMES) {
            executeUpdateQueryBoolean(getCreateQuery(tableName));
        }
    }

    private void executeUpdateQueryBoolean(String query) {
        try {
            oracleStatement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
