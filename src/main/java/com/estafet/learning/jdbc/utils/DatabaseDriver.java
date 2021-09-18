package com.estafet.learning.jdbc.utils;


import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;

import java.sql.SQLException;
import java.util.List;

public abstract class DatabaseDriver implements DatabaseHelper {
    @Override
    public void insertChecklist(Checklist checklist) throws SQLException {

    }

    @Override
    public void insertProduct(Product product) throws SQLException {

    }

    @Override
    public void insertCustomer(Customer customer) throws SQLException {

    }

    @Override
    public Checklist selectChecklist(int id) {
        return null;
    }

    @Override
    public Product selectProduct(int id) {
        return null;
    }

    @Override
    public Customer selectCustomer(int id) {
        return null;
    }

    @Override
    public List<Checklist> selectAllChecklists() {
        return null;
    }

    @Override
    public List<Product> selectAllProducts() {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public void getDataById(int id) {

    }

    @Override
    public int getTableCount(String schemaName) {
        return 0;
    }

    @Override
    public String getName(int id) {
        return null;
    }
}
