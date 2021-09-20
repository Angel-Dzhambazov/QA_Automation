package com.estafet.learning.jdbc.dataBase;

public interface OracleQueries {

    String INSERT_INTO_CHECKLISTS = "INSERT INTO checklists " +
            "(todo_id, name, cost, initiated_on, is_completed, MigratedTS, LastUpdatedTS) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    String INSERT_INTO_PRODUCTS = "INSERT INTO products " +
            "(product_id, name, description, list_price, category_id, MigratedTS, LastUpdatedTS) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    String INSERT_INTO_CUSTOMERS = "INSERT INTO customers " +
            "(customer_id, name, address, website, credit_limit, MigratedTS, LastUpdatedTS) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

    String CREATE_TABLE_CHECKLISTS = "CREATE TABLE checklists (\n" +
            "    todo_id INT NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR (255),\n" +
            "    cost NUMBER (7,2),\n" +
            "    initiated_on VARCHAR (255),\n" +
            "    is_completed NUMBER(1) DEFAULT 0 NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            ")";

    String CREATE_TABLE_PRODUCTS = "CREATE TABLE products (\n" +
            "    product_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255) NOT NULL,\n" +
            "    description VARCHAR2(2000),\n" +
            "    list_price NUMBER(9, 2),\n" +
            "    category_id NUMBER NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  )";

    String CREATE_TABLE_CUSTOMERS = "CREATE TABLE customers (\n" +
            "    customer_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255) NOT NULL,\n" +
            "    address VARCHAR2(255),\n" +
            "    website VARCHAR2(255),\n" +
            "    credit_limit NUMBER(8, 2),\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  )";

    String SELECT_ALL_TABLES = "select object_name as table_name\n" +
            "from user_objects\n" +
            "where object_type = 'TABLE' \n" +
            "order by object_name";

    default String getCreateQuery(String tableName) {

        switch (tableName) {
            case "checklists":
                return CREATE_TABLE_CHECKLISTS;
            case "products":
                return CREATE_TABLE_PRODUCTS;
            case "customers":
                return CREATE_TABLE_CUSTOMERS;
            default:
                System.out.println("ERROR!");
                return null;

        }
    }
}
