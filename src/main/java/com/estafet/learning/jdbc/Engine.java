package com.estafet.learning.jdbc;

import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.dataBase.OracleDriver;
import com.estafet.learning.jdbc.model.Checklist;
import com.estafet.learning.jdbc.model.Customer;
import com.estafet.learning.jdbc.model.Product;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Engine {


    public static void main(String[] args) {
        MySqlDriver sqlDriver = new MySqlDriver();
        OracleDriver oracleDriver = new OracleDriver();

        DAO sqlDao = new DAO(sqlDriver);
        DAO oracleDao = new DAO(oracleDriver);

//        sqlDao.getHelper().dropAllTables();
//        oracleDao.getHelper().dropAllTables();

//        createAndPopulateMySqlSchema(sqlDriver);
//        oracleDriver.createTables();
//
        populateOracleTables(oracleDriver, sqlDao);

    }

    /**
     * Extract all entries from SQL database and import it via oracleDriver
     * @param oracleDriver
     * @param sqlDao
     */
    private static void populateOracleTables(OracleDriver oracleDriver, DAO sqlDao) {
        List<Checklist> allCheckList = sqlDao.getHelper().selectAllChecklists();
        List<Product> allProductsList = sqlDao.getHelper().selectAllProducts();
        List<Customer> allCustomersList = sqlDao.getHelper().selectAllCustomers();
        try {
            for (Checklist checklist : allCheckList) {
                oracleDriver.insertRandomCheckList(checklist);
            }
            for (Product product : allProductsList) {
                oracleDriver.insertRandomProduct(product);
            }
            for (Customer customer : allCustomersList) {
                oracleDriver.insertRandomCustomer(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void createAndPopulateMySqlSchema(MySqlDriver sqlDriver) {
        sqlDriver.createTables();
        for (int i = 0; i < 10; i++) {
            sqlDriver.insertRandomCheckList(new Checklist());
            sqlDriver.insertRandomCustomer(new Customer());
            sqlDriver.insertRandomProduct(new Product());
        }
    }
}
