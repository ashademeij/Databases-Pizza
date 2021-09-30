package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class InsertToppings {

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

    public void insert(String name, int cost_price) {  
        String sql = "INSERT INTO toppings(" + name + "," + cost_price + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            //pstmt.setDouble(1, topping_id);  
            pstmt.setString(1, name);  
            pstmt.setDouble(2, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertToppings app = new InsertToppings();  
        app.insert("Cheese_1", 1); 
        app.insert("Pepperoni", 3); 
        app.insert("Pineapple", 2);  
        app.insert("Peppers", 2); 
        app.insert("Tuna", 2); 
        app.insert("Chicken", 3); 
        app.insert("Mushrooms", 2); 
        app.insert("Scampis", 5); 
        app.insert("Spinach", 2); 
        app.insert("Cheese_2", 2); 
        app.insert("Cheese_3", 2); 
        app.insert("Cheese_4", 2); 
 
    }
    
}
