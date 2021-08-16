import utils.Helper;
import utils.SqlQueryBuilder;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {


        String tableName = "products";
        LinkedHashMap<String, String> columnNames = new LinkedHashMap<>();
        columnNames.put("product_code", "int");
        columnNames.put("product_name", "varchar(255)");
        columnNames.put("product_description", "varchar(255)");
        columnNames.put("quantity", "int");
        columnNames.put("price", "FLOAT");
        SqlQueryBuilder.createTableQuery(tableName, columnNames);

        String test = "CREATE TABLE `testdatabase`.`products` (\n" +
                "  `product_code` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `productscol` VARCHAR(45) NULL,\n" +
                "  `productscol1` VARCHAR(45) NULL,\n" +
                "  `quantity` INT NULL,\n" +
                "  `price` DECIMAL(10,2) NULL,\n" +
                "  PRIMARY KEY (`product_code`));\n";
        String[] elements = test.split(",");

    }


}
