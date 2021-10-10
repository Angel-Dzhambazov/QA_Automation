package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlDriver extends DatabaseDriver implements PostgreSqlQueries {

    private static Connection postgreConnection = null;
    private static Statement postgreStatement = null;

    String SELECT_CHECKLIST_BY_ID = "SELECT * FROM checklists where todo_id = ";
    String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE customer_id = ";
    String SELECT_PRODUCT_BY_ID = "SELECT * FROM products WHERE product_id = ";

    public PostgreSqlDriver() {
        connect();
    }

    @Override
    public void connect() {
        if (postgreConnection == null) {
            postgreConnection = setConnection(
                    ConfigFileManager.getInstance().getPostgreJDBC(),
                    ConfigFileManager.getInstance().getPostgreUser(),
                    ConfigFileManager.getInstance().getPostgrePassword());
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
        List<String> listWithTables = new ArrayList<>();
        try {
            ResultSet resultset = postgreStatement.executeQuery(SELECT_ALL_TABLES);
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
            String query = SELECT_COUNT_FROM_TABLE + tableName;
            System.out.println("get total count of entries query  = \n" + query);
            rs = postgreStatement.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public Checklist selectChecklistById(Integer currentId) {
        return null;
    }

    @Override
    public Customer selectCustomerById(Integer currentId) {
        ResultSet rs;
        try {
            String query = SELECT_CUSTOMER_BY_ID + currentId;
            System.out.println("Select query  = \n" + query);
            rs = postgreStatement.executeQuery(query);
            rs.next();

            //int id, String name, String address, String website, Double creditLimit
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String address = rs.getString(3);
            String website = rs.getString(4);
            Double creditLimit = rs.getDouble(5);

            return new Customer(id, name, address, website, creditLimit);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Product selectProductById(Integer currentId) {
        ResultSet rs;
        try {
            String query = SELECT_PRODUCT_BY_ID + currentId;
            System.out.println("Select query  = \n" + query);
            rs = postgreStatement.executeQuery(query);
            rs.next();

            //int id, String name, String description, Double price, int categoryID
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String description = rs.getString(3);
            Double price = rs.getDouble(4);
            int categoryID = rs.getInt(4);

            return new Product(id, name, description, price, categoryID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
