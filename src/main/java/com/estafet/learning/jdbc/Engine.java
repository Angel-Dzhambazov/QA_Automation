package com.estafet.learning.jdbc;

import com.estafet.learning.jdbc.dataBase.MySqlDriver;
import com.estafet.learning.jdbc.model.Checklist;


public class Engine {

    public static void main(String[] args) {
        MySqlDriver sqlDriver = new MySqlDriver();
        sqlDriver.createTables();

        sqlDriver.insertRandomCheckList(4);
        sqlDriver.insertRandomCustomer(4);
        sqlDriver.insertRandomProduct(4);

    }
}
