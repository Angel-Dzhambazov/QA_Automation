package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDriver extends DatabaseDriver implements MySqlQueries {
    private static Connection mySqlConnection = null;
    private static Statement mySqlStatement = null;

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
            + " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public MySqlDriver() {
        connect();
    }

    @Override
    public void createTables() {
        for (String tableName : TABLE_NAMES) {
            executeUpdateQueryBoolean(getCreateQuery(tableName));
        }
    }

    private void executeUpdateQueryBoolean(String query) {
        try {
            System.out.println("Update query is: \n" + query);
            mySqlStatement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void connect() {
        if (mySqlConnection == null) {
            mySqlConnection = setConnection(
                    ConfigFileManager.getInstance().getMysqlJDBC(),
                    ConfigFileManager.getInstance().getMysqlUser(),
                    ConfigFileManager.getInstance().getMysqlPassword());
            try {
                mySqlStatement = mySqlConnection.createStatement();
                System.out.println("Statement created!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void insertRandomCustomer(Customer customer) {


        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = mySqlConnection.prepareStatement(INSERT_INTO_CUSTOMERS);
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

    @Override
    public void executeQuery(String query) {
        try {
            ResultSet rs = mySqlStatement.executeQuery(query);
            System.out.println("printResultSet(rs)");
            printResultSet(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void insertRandomProduct(Product product) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = mySqlConnection.prepareStatement(INSERT_INTO_PRODUCTS);
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

    @Override
    public void insertRandomCheckList(Checklist checklist) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mySqlConnection.prepareStatement(INSERT_INTO_CHECKLISTS);
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

    /**
     * Returns List with the names of all tables in the schema
     *
     * @return
     */
    @Override
    public List<String> selectAllTables() {
        List<String> listWithTables = new ArrayList<>();
        try {
            ResultSet resultset = mySqlStatement.executeQuery(SELECT_ALL_TABLES);
            return extractListFromResultSet(resultset, columnNameIndex);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listWithTables;
    }

    /**
     * Returns List with all entries in Checklist table as POJOs.
     *
     * @return
     */
    @Override
    public List<Checklist> selectAllChecklists() {
        ResultSet rs;
        try {
            rs = mySqlStatement.executeQuery(SELECT_ALL_FROM_CHECKLISTS);
            return generateList(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Maps rs to List of Checklists
     *
     * @param rs ResultSet containing all entries from Checklist table
     * @return
     * @throws SQLException
     */
    private List<Checklist> generateList(ResultSet rs) throws SQLException {
        List<Checklist> result = new ArrayList<>();
        while (rs.next()) {
            int todo_id = rs.getInt(1);
            String name = rs.getString(2);
            Double cost = rs.getDouble(3);
            String initiated_on = rs.getString(4);
            int is_completed = rs.getInt(5);
            Checklist temp = new Checklist(todo_id, name, cost, initiated_on, is_completed);
            result.add(temp);
        }
        return result;
    }

    @Override
    public List<Product> selectAllProducts() {
        ResultSet rs;
        try {
            rs = mySqlStatement.executeQuery(SELECT_ALL_FROM_PRODUCTS);
            return mapRsToProducts(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Maps rs to List of Products
     *
     * @param rs ResultSet containing all entries from Product table
     * @return
     * @throws SQLException
     */
    private List<Product> mapRsToProducts(ResultSet rs) throws SQLException {
        List<Product> result = new ArrayList<>();
        while (rs.next()) {
            //String name, String description, Double price, int categoryID)
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String description = rs.getString(3);
            Double cost = rs.getDouble(4);
            int foreignKey = rs.getInt(5);
            Product temp = new Product(id, name, description, cost, foreignKey);
            result.add(temp);
        }
        return result;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        ResultSet rs;
        try {
            rs = mySqlStatement.executeQuery(SELECT_ALL_FROM_CUSTOMERS);
            return mapRsToCustomers(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Maps rs to List of Customers
     *
     * @param rs ResultSet containing all entries from Customer table
     * @return
     * @throws SQLException
     */
    private List<Customer> mapRsToCustomers(ResultSet rs) throws SQLException {
        List<Customer> result = new ArrayList<>();
        while (rs.next()) {
            //(int id, String name, String address, String website, Double creditLimit)
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String address = rs.getString(3);
            String website = rs.getString(4);
            Double creditLimit = rs.getDouble(5);
            Customer temp = new Customer(id, name, address, website, creditLimit);
            result.add(temp);
        }
        return result;
    }

    @Override
    public void dropAllTables() {
        PreparedStatement preparedStatement;
        try {
            for (String tableName : TABLE_NAMES) {
                preparedStatement = mySqlConnection.prepareStatement(DROP_TABLE + tableName);
                preparedStatement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public int getTotalEntriesOfTable(String tableName) {
        ResultSet rs;
        try {
            rs = mySqlStatement.executeQuery(SELECT_COUNT_FROM_TABLE + tableName);
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
