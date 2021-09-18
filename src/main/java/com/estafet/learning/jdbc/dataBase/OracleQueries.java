package com.estafet.learning.jdbc.dataBase;

public interface OracleQueries {

    public static final String CREATE_TABLE_CHECKLISTS ="CREATE TABLE checklists (\n" +
            "    todo_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255),\n" +
            "    cost NUMBER (7,2),\n" +
            "    initiated_on VARCHAR2(255),\n" +
            "    is_completed NUMBER(1) DEFAULT 0 NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            ");";

    public static final String CREATE_TABLE_PRODUCTS ="CREATE TABLE products (\n" +
            "    product_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255) NOT NULL,\n" +
            "    description VARCHAR2(2000),\n" +
            "    list_price NUMBER(9, 2),\n" +
            "    category_id NUMBER NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  );";


    public static final String CREATE_TABLE_CUSTOMERS ="CREATE TABLE customers (\n" +
            "    customer_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255) NOT NULL,\n" +
            "    address VARCHAR2(255),\n" +
            "    website VARCHAR2(255),\n" +
            "    credit_limit NUMBER(8, 2),\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  );";
}
