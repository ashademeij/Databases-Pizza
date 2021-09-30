package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class InsertDrink {

    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/Pizza_Shop.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    } 

    public void insert(int drink_id, String name, double cost_price) {  
        String sql = "INSERT INTO drink ("+ drink_id + "," + name + "," + cost_price + ");";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, drink_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertDrink app = new InsertDrink();  
        app.insert(1,"Coke", 2.50); 
        app.insert(2,"Sprite", 2.50); 
        app.insert(3,"Fanta", 2.50);  
        app.insert(4,"Ice_Tea", 2.50); 
        app.insert(5,"Water", 2.50); 
     
 
    }
}
