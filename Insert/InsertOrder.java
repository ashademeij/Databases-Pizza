package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException; 
import java.sql.Time;

 
public class InsertOrder{  
   
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
   
  
    public void insert(int order_id, String pizza, String drinks, String dessert, double discount, double total) {  
        String sql = "INSERT INTO order(order_id, pizza, drinks, dessert, discount, total) VALUES(?,?,?,?,?,?);"; 
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, order_id);
            pstmt.setString(2, pizza);
            pstmt.setString(3, drinks);  
            pstmt.setString(4, dessert); 
            pstmt.setDouble(5, discount);
            pstmt.setDouble(6, total);

            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        InsertOrder app = new InsertOrder();  

        app.insert(1, "1", "1", null, 0.00, 14.10);  
        app.insert(2, "4", null, null, 0.00, 16.05);  
        app.insert(3, "7 8", "2", "1", 3.02, 30.20);  
        app.insert(4, "3", null, null, 1.37 ,13.75); 
        app.insert(5, "5 6 10", null, "1 1 1", 4.26, 42.65);

    }  
   
}  

