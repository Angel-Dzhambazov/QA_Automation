package com.estafet.learning.jdbc.dataBase;

public interface MySqlQueries {

    String INSERT_INTO_CHECKLISTS = "INSERT INTO checklists " +
            "(name, cost, initiated_on, is_completed) VALUES (?, ?, ?, ?);";

    String INSERT_INTO_PRODUCTS = "INSERT INTO products " +
            "(name, description, list_price, category_id) VALUES (?, ?, ?, ?);";

    String INSERT_INTO_CUSTOMERS = "INSERT INTO customers " +
            "(name, address, website, credit_limit) VALUES (?, ?, ?, ?);";

    String MYSQL_CREATE_CHECKLISTS = "CREATE TABLE IF NOT EXISTS checklists (\n" +
            "    todo_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255),\n" +
            "    cost DECIMAL (7,2),\n" +
            "    initiated_on VARCHAR(255),\n" +
            "    is_completed BOOLEAN NOT NULL DEFAULT FALSE\n" +
            ");";

    String MYSQL_CREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS products (\n" +
            "    product_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255) NOT NULL,\n" +
            "    description VARCHAR(2000),\n" +
            "    list_price DECIMAL(9, 2),\n" +
            "    category_id INT NOT NULL\n" +
            "  );";

    String MYSQL_CREATE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS customers (\n" +
            "    customer_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255) NOT NULL,\n" +
            "    address VARCHAR(255),\n" +
            "    website VARCHAR(255),\n" +
            "    credit_limit DECIMAL(8, 2) \n" +
            "  );";

    String SELECT_ALL_TABLES = "show tables";


    default String getCreateQuery(String tableName) {
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

    int getTotalEntriesOfTable(String tableName);
}