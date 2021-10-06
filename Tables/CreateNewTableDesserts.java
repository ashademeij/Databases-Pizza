package Tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewTableDesserts {
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost/Pizza_Shop?user=root&password=asha1234";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS dessert ("
                + " desserts_id INTEGER PRIMARY KEY AUTO_INCREMENT,"
                + " name TEXT NOT NULL,"
                + " cost_price INTEGER NOT NULL"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("DESSERTS TABLE IS CREATED");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Desserts");
        }
    }

}
