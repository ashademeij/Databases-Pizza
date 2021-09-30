package Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewTableTopping {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/Pizza_Shop.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS toppings ("
                + " topping_id integer PRIMARY KEY NOT NULL,"
                + " name text NOT NULL,"
                + " s integer NOT NULL"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("TOPPINGS TABLE IS CREATED");
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"toppings");
        }
    }

}
