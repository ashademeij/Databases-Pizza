package CreateTables;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateCustomerTable {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/Pizza_Shop.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS customers (\n"  
                + " id integer PRIMARY KEY AUTO_INCREMENT,\n"  
                + " name text NOT NULL,\n"  
                + " number integer NOT NULL, \n"
                + " address text NOT NULL, \n"
                + " no_of_orders integer NOT NULL, \n"
                + ");";    
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        createNewTable();  
    }  
   
}  