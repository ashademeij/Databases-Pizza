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

    public void insert(String name, double cost_price, String  vegeterian) {  
        String sql = "INSERT INTO pizza(" + name + "," + cost_price + "," + vegeterian +")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            //pstmt.setDouble(1, pizza_id);  
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
        app.insert("Magherita", 6.50,"V"); 
        app.insert("Pepperoni", 8,"X"); 
        app.insert("Hawaiian", 9,"X");  
        app.insert("Veggie", 8,"V"); 
        app.insert("Tonno", 8,"X"); 
        app.insert("BBQ Chicken", 9,"X"); 
        app.insert("Four cheese", 8,"X"); 
        app.insert("Funghi", 8.50,"V"); 
        app.insert("Mediterranea", 12,"X"); 
        app.insert("Spinaci", 9,"V"); 
 
    }

    
}
