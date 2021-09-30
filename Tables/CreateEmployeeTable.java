package Tables;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class CreateEmployeeTable {  
   
    public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/Pizza_Shop.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS employee ("  
                + " employee_id integer PRIMARY KEY,"
                + " name text NOT NULL,"
                + " gender text NOT NULL,"  
                + " area_code integer NOT NULL"
                + ");";    
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            Statement stmt = conn.createStatement(); 
            stmt.execute(sql);
            System.out.println("EMPLOYEE TABLE IS CREATED");  
        } catch (SQLException e) {  
            System.out.println(e.getMessage() + " Employees");  
        }  
    }  
    
   
}  
