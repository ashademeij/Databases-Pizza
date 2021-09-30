package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class InsertPizza {

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

    public void insert(int pizza_id, String name, int cost_price, String  vegeterian) {  
        String sql = "INSERT INTO pizza(" + pizza_id +"," + name + "," + cost_price + "," + vegeterian +")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, pizza_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.setString(4, vegeterian); 
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertPizza app = new InsertPizza();  
        app.insert(01, "Magherita", 6.50,"V"); 
        app.insert(02, "Pepperoni", 8,"X"); 
        app.insert(03, "Hawaiian", 9,"X");  
        app.insert(04, "Veggie", 8,"V"); 
        app.insert(05, "Tonno", 8,"X"); 
        app.insert(06, "BBQ Chicken", 9,"X"); 
        app.insert(07, "Four cheese", 8,"X"); 
        app.insert(08, "Funghi", 8.50,"V"); 
        app.insert(09, "Mediterranea", 12,"X"); 
        app.insert(10, "Spinaci", 9,"V"); 
 
    }

    
}
