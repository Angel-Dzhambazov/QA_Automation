package com.estafet.learning.jdbc.dataBase;

import com.estafet.learning.jdbc.service.ConfigFileManager;
import com.estafet.learning.jdbc.utils.DatabaseDriver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDriver extends DatabaseDriver  {

    private static Connection connection = null;
    private static Statement statement = null;


    public OracleDriver() {
        connect();
    }

    @Override
    public void connect() {
        if (connection == null) {
            connection = setConnection(
                    ConfigFileManager.getInstance().getOracleJDBC(),
                    ConfigFileManager.getInstance().getOracleUser(),
                    ConfigFileManager.getInstance().getOraclePassword());
            try {
                statement = connection.createStatement();
                System.out.println("Statement created!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
