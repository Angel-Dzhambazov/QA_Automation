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
    private static Connection connection = null;
    private static Statement statement = null;

    /*
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String mysqlJDBC = ConfigFileManager.getInstance().getMysqlJDBC();
    private String jdbcUsername = "root";
    private String mysqlJDBCUsername = ConfigFileManager.getInstance().getMysqlUser();
    private String jdbcPassword = "root";
    private String mysqlJDBCPassword = ConfigFileManager.getInstance().getMysqlPassword();
     */

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
            + " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

    public MySqlDriver() {
        connect();
    }

    public void createTables() {
        for (String tableName : TABLE_NAMES) {
            executeUpdateQueryBoolean(getCreateQuery(tableName));
        }
    }



    public static boolean executeUpdateQueryBoolean(String query) {
        int result = -9999;

        try {
            System.out.println("Update query is: \n" + query);
            result = statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result >= 0;
    }

    @Override
    public void connect() {
        if (connection == null) {
            connection = setConnection(
                    ConfigFileManager.getInstance().getMysqlJDBC(),
                    ConfigFileManager.getInstance().getMysqlUser(),
                    ConfigFileManager.getInstance().getMysqlPassword());
            try {
                statement = connection.createStatement();
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
                preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMERS);
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
                preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCTS);
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
                preparedStatement = connection.prepareStatement(INSERT_INTO_CHECKLISTS);
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
