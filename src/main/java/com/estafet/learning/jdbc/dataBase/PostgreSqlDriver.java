package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.*;
import java.util.List;

public class PostgreSqlDriver extends DatabaseDriver {

    private static Connection postgreConnection = null;
    private static Statement postgreStatement = null;


    public PostgreSqlDriver() {
        connect();
    }

    @Override
    public void connect() {
        if (postgreConnection == null) {
            postgreConnection = setConnection(
                    ConfigFileManager.getInstance().getOracleJDBC(),
                    ConfigFileManager.getInstance().getOracleUser(),
                    ConfigFileManager.getInstance().getOraclePassword());
            try {
                postgreStatement = postgreConnection.createStatement();
                System.out.println("Statement created!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void insertRandomCheckList(Checklist checklist) throws SQLException {

    }

    @Override
    public void insertRandomProduct(Product product) throws SQLException {

    }

    @Override
    public void insertRandomCustomer(Customer customer) throws SQLException {

    }

    @Override
    public void executeQuery(String query) {
        try {
            ResultSet rs = postgreStatement.executeQuery(query);
            System.out.println("printResultSet(rs)");
            printResultSet(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void dropAllTables() {
        PreparedStatement preparedStatement;
        try {
            for (String tableName : TABLE_NAMES) {
                preparedStatement = postgreConnection.prepareStatement(DROP_TABLE + tableName);
                System.out.println("preparedStatement.toString()");
                System.out.println(preparedStatement.toString());
                preparedStatement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<String> selectAllTables() {
        return null;
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
        return 0;
    }

    @Override
    public Checklist selectChecklistById(Integer currentId) {
        return null;
    }

    @Override
    public Customer selectCustomerById(Integer currentId) {
        return null;
    }

    @Override
    public Product selectProductById(Integer currentId) {
        return null;
    }
}
