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

    public void insert(int topping_id, String name, int cost_price) {  
        String sql = "INSERT INTO toppings(" + topping_id +"," + name + "," + cost_price + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, topping_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertToppings app = new InsertToppings();  
        app.insert(01, "Cheese_1", 1); 
        app.insert(02, "Pepperoni", 8); 
        app.insert(03, "Pineapple", 2);  
        app.insert(04, "Peppers", 2); 
        app.insert(05, "Tuna", 2); 
        app.insert(06, "Chicken", 3); 
        app.insert(07, "Four cheese", 8); 
        app.insert(08, "Mushrooms", 2); 
        app.insert(09, "Scampis", 5); 
        app.insert(10, "Spinach", 2); 
        app.insert(11, "Cheese_2", 2); 
        app.insert(12, "Cheese_3", 2); 
        app.insert(13, "Cheese_4", 2); 
 
    }
    
}
