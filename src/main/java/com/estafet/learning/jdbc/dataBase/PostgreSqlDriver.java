package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.SQLException;
import java.util.List;

public class PostgreSqlDriver extends DatabaseDriver {
    @Override
    public void connect() {

    }

    @Override
    public void insertRandomCheckList(Checklist checklist) throws SQLException {

    }

    @Override
    public void insertRandomProduct(Product product) throws SQLException {

    }

    @Override
    public void insertRandomCustomer(Customer customer) throws SQLException {

    }

    @Override
    public void executeQuery(String query) {

    }

    @Override
    public void dropAllTables() {

    }

    @Override
    public List<String> selectAllTables() {
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
    public int getTotalEntriesOfTable(String tableName) {
        return 0;
    }

    @Override
    public Checklist selectChecklistById(Integer currentId) {
        return null;
    }

    @Override
    public Customer selectCustomerById(Integer currentId) {
        return null;
    }

    @Override
    public Product selectProductById(Integer currentId) {
        return null;
    }
}
