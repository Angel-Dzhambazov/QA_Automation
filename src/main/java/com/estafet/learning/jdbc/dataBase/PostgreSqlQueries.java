package com.estafet.learning.jdbc.dataBase;

public interface PostgreSqlQueries {
    String SELECT_ALL_TABLES = "SELECT table_name\n" +
            "FROM information_schema.tables\n" +
            "WHERE table_schema = 'public'\n" +
            "ORDER BY table_name;";


}
