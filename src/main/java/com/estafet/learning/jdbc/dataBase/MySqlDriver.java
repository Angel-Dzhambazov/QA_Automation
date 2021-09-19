package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void insertRandomCustomer(int numberOfCustomers) {
        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer();
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
    }

    @Override
    public void insertRandomProduct(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            Product product = new Product();
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
    }

    @Override
    public void insertRandomCheckList(int numberOfChecklists) {
        for (int i = 0; i < numberOfChecklists; i++) {
            Checklist checklist = new Checklist();
            PreparedStatement preparedStatement = null;
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
    }
}
