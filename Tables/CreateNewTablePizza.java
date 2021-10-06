package Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewTablePizza {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost/Pizza_Shop?user=root&password=asha1234";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pizza ("
                + " pizza_id INTEGER PRIMARY KEY NOT NULL,"
                + " name TEXT NOT NULL,"
                + " cost_price INTEGER NOT NULL,"
                + " vegeterian TEXT NOT NULL,"
                + " toppings TEXT NOT NULL,"
                + " profit INTEGER NOT NULL,"
                + " VAT INTEGER NOT NULL,"
                + " selling_price INTEGER NOT NULL"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("PIZZA TABLE IS CREATED");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " Pizza");
        }
    }

}
