package com.estafet.learning.jdbc;

import com.estafet.learning.jdbc.utils.DatabaseDriver;
import com.estafet.learning.jdbc.utils.DatabaseHelper;

public class DAO {
    private final DatabaseHelper helper;

    public DAO(DatabaseDriver driver) {
        this.helper = driver;
    }

    public DatabaseHelper getHelper() {
        return helper;
    }
}
