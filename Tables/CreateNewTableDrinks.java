package Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewTableDrinks {
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/Pizza_Shop.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS drink ("
                + " drink_id integer PRIMARY KEY NOT NULL,"
                + " name text NOT NULL, "
                + " cost_price integer NOT NULL"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("DRINKS TABLE IS CREATED");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Drinks");
        }
    }

}
