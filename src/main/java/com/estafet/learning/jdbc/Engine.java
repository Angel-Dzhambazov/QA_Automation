package com.estafet.learning.jdbc;

import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.dataBase.OracleDriver;

public class Engine {


    public static void main(String[] args) {
        // MySQl manipulation. Connect, create, insert entries


        MySqlDriver sqlDriver = new MySqlDriver();
 /*

        sqlDriver.createTables();
        sqlDriver.insertRandomCheckList(4);
        sqlDriver.insertRandomCustomer(4);
        sqlDriver.insertRandomProduct(4);


         */

        // Oracle manipulation. Connect, create, read entries from mysql, insert into Oracle
        OracleDriver oracleDriver = new OracleDriver();
        DAO sqlDao = new DAO(sqlDriver);
        sqlDao.getHelper().createTables();


//        String query = "CREATE table employee (employee_id(5) NOT NULL, employee_name varchar2(30), employment_length" +
//                " varchar2 (40))";
//        oracleDriver.executeQuery(query);
        oracleDriver.createTables();


        // get list of all IDs in mySql table
        // for each ID extract POJO and add it to list of POJOs.
        // to each POJO add column timestamp with time of extraction
        // insert each POJO into oracle and add timestamp with insertion time

        // once this is done 2/3 is done

        // move to src/test/java
        // create logic for table count, row count  this should be equal
        // implement logic to pick 5 random IDs from a table.
        // create List<Objects read from MySQL>
        // List <Objects read from MySQL>

        // implement compare method - compare first 5 columns, ignore timestamps in @override .compareTo()


    }
}
