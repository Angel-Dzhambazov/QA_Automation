package com.estafet.learning.dataBase;

public interface DatabaseHelper {

    default void getDataById(int id) {

    }

    default int getTableCount(String schemaName) {
        int result = -999;

        return result;
    }
}
