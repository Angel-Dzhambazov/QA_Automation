package com.estafet.learning.jdbc.utils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public interface DatabaseHelper {

    List<String> TABLE_NAMES =
            Arrays.asList("checklists", "products", "customers");

    void connect();

    void createTables();

    void insertRandomCheckList(int countOfChecklists) throws SQLException;

    void insertRandomProduct(int countOfProducts) throws SQLException;

    void insertRandomCustomer(int countOfCustomers) throws SQLException;

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

}
