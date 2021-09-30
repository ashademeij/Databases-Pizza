package Tables;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateOrderTable {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/Pizza_Shop.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS orders ("  
                + " order_id integer PRIMARY KEY NOT NULL"
                + " pizza text NOT NULL"
                + " drinks text NOT NULL"  
                + " dessert text NOT NULL"
                + " discount integer NOT NULL"
                + " total integer NOT NULL"
                + ");";    
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage() +"ORDERS");  
        }  
    }  
   
   
}  
