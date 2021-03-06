package com.estafet.learning.jdbc.utils;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public interface DatabaseHelper {

    List<String> TABLE_NAMES =
            Arrays.asList("checklists", "products", "customers");

    int columnNameIndex = 1;
    String SELECT_ALL_FROM_CHECKLISTS = "SELECT * FROM checklists";
    String SELECT_ALL_FROM_PRODUCTS = "SELECT * FROM products";
    String SELECT_ALL_FROM_CUSTOMERS = "SELECT * FROM customers";
    String DROP_TABLE = "DROP TABLE ";
    String SELECT_COUNT_FROM_TABLE = "SELECT COUNT(*) FROM ";

    String SELECT_CHECKLIST_BY_ID = "SELECT * FROM `checklists` where `todo_id` = ";
    String SELECT_CUSTOMER_BY_ID = "SELECT * FROM `customers` WHERE `customer_id` = ";
    String SELECT_PRODUCT_BY_ID = "SELECT * FROM `products` WHERE `product_id` = ";

    void connect();

    void createTables();

    void insertRandomCheckList(Checklist checklist) throws SQLException;

    void insertRandomProduct(Product product) throws SQLException;

    void insertRandomCustomer(Customer customer) throws SQLException;

    void executeQuery(String query);

    void dropAllTables();

    List<String> selectAllTables();


    List<Checklist> selectAllChecklists();

    List<Product> selectAllProducts();

    List<Customer> selectAllCustomers();

    int getTotalEntriesOfTable(String tableName);

    Checklist selectChecklistById(Integer currentId);

    Customer selectCustomerById(Integer currentId);

    Product selectProductById(Integer currentId);
}
