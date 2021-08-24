package com.estafet.learning.stepDefinitions.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SqlQueryBuilder {

    public static String doesTableExistQuery(String tableName) {
        return "SELECT TABLE_NAME\n" +
                "FROM INFORMATION_SCHEMA.TABLES\n" +
                "WHERE TABLE_SCHEMA = 'testdatabase'\n" +
                "AND TABLE_NAME = '" + tableName + "';";
    }

    public static String createTableQuery(String tableName, LinkedHashMap<String, String> columnNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE " + tableName + " (").append(System.lineSeparator());
        int counter = columnNames.size();
        for (Map.Entry<String, String> entry : columnNames.entrySet()) {
            counter--;
            if (counter != 0) {
                sb.append(entry.getKey() + " " + entry.getValue() + ",").append(System.lineSeparator());
            } else {
                sb.append(entry.getKey() + " " + entry.getValue()).append(System.lineSeparator()).append(");");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }


}
