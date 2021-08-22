
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) throws SQLException {


        for (int i = 0; i < 26; i++) {
            System.out.print((int) ((Math.random() * (10)) + 1) + " ");
        }


    }
}
