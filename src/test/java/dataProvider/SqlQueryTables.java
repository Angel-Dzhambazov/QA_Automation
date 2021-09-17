package dataProvider;

public class SqlQueryTables {
    public static final String MYSQL_CREATE_CHECKLISTS = "CREATE TABLE IF NOT EXISTS checklists (\n" +
            "    todo_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    todo_description VARCHAR(255),\n" +
            "    cost DECIMAL (7,2),\n" +
            "    initiated_on DATE,\n" +
            "    is_completed BOOLEAN NOT NULL DEFAULT FALSE\n" +
            ");";

    public static final String MYSQL_CREATE_PRODUCTS = "CREATE TABLE IF NOT EXISTS products (\n" +
            "    product_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    product_name VARCHAR(255) NOT NULL,\n" +
            "    description VARCHAR(2000),\n" +
            "    list_price DECIMAL(9, 2),\n" +
            "    category_id INT NOT NULL\n" +
            "  );";

    public static final String MYSQL_CREATE_CUSTOMERS = "CREATE TABLE IF NOT EXISTS customers (\n" +
            "    customer_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            "    name VARCHAR(255) NOT NULL,\n" +
            "    address VARCHAR(255),\n" +
            "    website VARCHAR(255),\n" +
            "    credit_limit DECIMAL(8, 2) \n" +
            "  );";


    public static final String ORACLE_CREATE_CHECKLISTS = "CREATE TABLE checklists (\n" +
            "    todo_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    todo_description VARCHAR2(255),\n" +
            "    cost NUMBER (7,2),\n" +
            "    initiated_on DATE,\n" +
            "    is_completed NUMBER(1) DEFAULT 0 NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            " );";

    public static final String ORACLE_CREATE_PRODUCTS = "CREATE TABLE products (\n" +
            "    product_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    product_name VARCHAR2(255) NOT NULL,\n" +
            "    description VARCHAR2(2000),\n" +
            "    list_price NUMBER(9, 2),\n" +
            "    category_id NUMBER NOT NULL,\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  );";

    public static final String ORACLE_CREATE_CUSTOMERS = "CREATE TABLE customers (\n" +
            "    customer_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    name VARCHAR2(255) NOT NULL,\n" +
            "    address VARCHAR2(255),\n" +
            "    website VARCHAR2(255),\n" +
            "    credit_limit NUMBER(8, 2),\n" +
            "    MigratedTS Timestamp(3),\n" +
            "    LastUpdatedTS Timestamp(3)\n" +
            "  );";
}
