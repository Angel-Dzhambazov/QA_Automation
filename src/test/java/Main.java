import utils.Helper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        Helper.deleteEntries("subjects");

        ResultSet rsSubjects = Helper.selectFromTable("subjects");
        try {
            Helper.printResultSet(rsSubjects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
