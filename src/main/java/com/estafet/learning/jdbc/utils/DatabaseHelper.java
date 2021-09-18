package com.estafet.learning.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public interface DatabaseHelper {


    default void insertRandomCheckList(int countOfChecklists) throws SQLException {}
    default void insertRandomProduct(int countOfProducts) throws SQLException {}
    default void insertRandomCustomer(int countOfCustomers) throws SQLException {}

    /*
      Checklist selectChecklist(int id);
      Product selectProduct(int id);
      Customer selectCustomer(int id);

      List<Checklist> selectAllChecklists();
      List<Product> selectAllProducts();
      List<Customer> selectAllCustomers();

      void getDataById(int id);
      int getTableCount(String schemaName);
      String getName(int id);

       */
    default Connection setConnection(String jdbcURL, String username, String password) {
        try {
            return DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


}
