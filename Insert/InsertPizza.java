package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

public class InsertPizza {

    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:mysql://localhost/Pizza_Shop?user=root&password=asha1234";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  

    public void insert(int pizza_id, String name, double cost_price, String  vegeterian, String toppings, double profit, double vat, double selling_price) {  
        String sql = "INSERT INTO pizza(pizza_id, name, cost_price, vegeterian) VALUES(?,?,?,?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, pizza_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.setString(4, vegeterian); 
            pstmt.setString(5, toppings);
            pstmt.setDouble(6, profit);
            pstmt.setDouble(7, vat);
            pstmt.setDouble(8, selling_price);
            
            pstmt.executeUpdate();  
            
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
            System.out.println("not inserted");
        }  
    } 

    public static void main(String[] args) {  
   
        InsertPizza app = new InsertPizza();  
        app.insert(1,"Magherita", 6.50,"V","Mozzarella, Cheddar, Tomato",2.60,0.80,9.90); 
        app.insert(2,"Pepperoni", 7.00,"X","Mozzarella, Cheddar, Tomato, Pepperoni",2.80,0.90,10.70); 
        app.insert(3,"Hawaiian", 9.00,"X","Mozzarella, Cheddar, Ham, Pineapple",3.60,1.15,13.75);  
        app.insert(4,"Veggie", 8,"V","Mozzarella, Cheddar, Mushrooms, Spinach, Tomato",4.20,1.35,16.05); 
        app.insert(5,"Tonno", 8,"X","Mozzarella, Cheddar, Tuna",3.40,1.00,13.00); 
        app.insert(6,"BBQ Chicken", 9,"X","Mozzarella, Cheddar, Chickn",3,0.95,11.45); 
        app.insert(7,"Four cheese", 8,"X","Mozzarella, Cheddar, Gouda, Emmental",3.80,1.20,14.50); 
        app.insert(8,"Funghi", 8.50,"V","Mozzarella, Cheddar, Mushrooms",2.80,0.90,10.70); 
        app.insert(9,"Mediterranea", 12,"X","Mozzarella, Cheddar, Tomato, Artichoke, Spinach", 5,1.60,19.10); 
        app.insert(10,"Spinaci", 9,"V","Mozzarella, Cheddar, Spinach",3.20,1.00,12.20); 
 
    }

    
}
