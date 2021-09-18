package com.estafet.learning.jdbc.utils;



import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseHelper {

    void insertChecklist(Checklist checklist) throws SQLException;
    void insertProduct(Product product) throws SQLException;
    void insertCustomer(Customer customer) throws SQLException;

    Checklist selectChecklist(int id);
    Product selectProduct(int id);
    Customer selectCustomer(int id);

    List<Checklist> selectAllChecklists();
    List<Product> selectAllProducts();
    List<Customer> selectAllCustomers();

    void getDataById(int id);
    int getTableCount(String schemaName);
    String getName(int id);
}
