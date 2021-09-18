package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public interface MySqlQueries {

    public static List<String> TABLE_NAMES =
            Arrays.asList("checklists", "products", "customers");

    public static String INSERT_INTO_CHECKLISTS = "INSERT INTO checklists " +
            "(name, cost, initiated_on, is_completed) VALUES (?, ?, ?, ?);";

    public static String INSERT_INTO_PRODUCTS = "INSERT INTO products " +
            "(name, description, list_price, category_id) VALUES (?, ?, ?, ?);";

    public static String INSERT_INTO_CUSTOMERS = "INSERT INTO customers " +
            "(name, address, website, credit_limit) VALUES (?, ?, ?, ?);";

    public static String MYSQL_CREATE_CHECKLISTS = "CREATE TABLE IF NOT EXISTS checklists (\n" +
            "    todo_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255),\n" +
            "    cost DECIMAL (7,2),\n" +
            "    initiated_on VARCHAR(255),\n" +
            "    is_completed BOOLEAN NOT NULL DEFAULT FALSE\n" +
            ");";

    public static String MYSQL_CREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS products (\n" +
            "    product_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255) NOT NULL,\n" +
            "    description VARCHAR(2000),\n" +
            "    list_price DECIMAL(9, 2),\n" +
            "    category_id INT NOT NULL\n" +
            "  );";

    public static String MYSQL_CREATE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS customers (\n" +
            "    customer_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255) NOT NULL,\n" +
            "    address VARCHAR(255),\n" +
            "    website VARCHAR(255),\n" +
            "    credit_limit DECIMAL(8, 2) \n" +
            "  );";

    public static String ORACLE_CREATE_CHECKLISTS = "CREATE TABLE checklists (\n" +
            "    todo_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    todo_description VARCHAR2(255),\n" +
            "    cost NUMBER (7,2),\n" +
            "    initiated_on VARCHAR2(255),\n" +
            "    is_completed NUMBER(1) DEFAULT 0 NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            " );";

    public static String ORACLE_CREATE_PRODUCTS = "CREATE TABLE products (\n" +
            "    product_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    product_name VARCHAR2(255) NOT NULL,\n" +
            "    description VARCHAR2(2000),\n" +
            "    list_price NUMBER(9, 2),\n" +
            "    category_id NUMBER NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  );";

    public static String ORACLE_CREATE_CUSTOMERS = "CREATE TABLE customers (\n" +
            "    customer_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255) NOT NULL,\n" +
            "    address VARCHAR2(255),\n" +
            "    website VARCHAR2(255),\n" +
            "    credit_limit NUMBER(8, 2),\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  );";

    default Connection setConnection(String jdbcURL, String username, String password) {
        try {
            return DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public default String getCreateQuery(String tableName) {
        switch (tableName) {
            case "checklists":
                return MYSQL_CREATE_CHECKLISTS;
            case "products":
                return MYSQL_CREATE_PRODUCTS;
            case "customers":
                return MYSQL_CREATE_CUSTOMERS;
            default:
                System.out.println("ERROR!");
                return null;
        }
    }


}