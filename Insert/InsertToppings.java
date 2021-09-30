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

    public void insert(double topping_id, String name, int cost_price) {  
        String sql = "INSERT INTO toppings(topping_id, name, cost_price) VALUES(?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, topping_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            System.out.println("toppings create toppings");
        }  
    } 

    public static void main(String[] args) {  
   
        InsertToppings app = new InsertToppings();  
        app.insert(1,"Cheese_1", 1); 
        app.insert(2,"Pepperoni", 3); 
        app.insert(3,"Pineapple", 2);  
        app.insert(4,"Peppers", 2); 
        app.insert(5,"Tuna", 2); 
        app.insert(6,"Chicken", 3); 
        app.insert(7,"Mushrooms", 2); 
        app.insert(8,"Scampis", 5); 
        app.insert(9,"Spinach", 2); 
        app.insert(10,"Cheese_2", 2); 
        app.insert(11,"Cheese_3", 2); 
        app.insert(12,"Cheese_4", 2); 
 
    }
    
}
