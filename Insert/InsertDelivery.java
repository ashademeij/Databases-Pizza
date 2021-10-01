package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException; 
import java.sql.Time;

 
public class InsertDelivery {  
   
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
   
  
    public void insert(int delivery_id, double customer_id, Time time, String status, int area_code) {  
        String sql = "INSERT INTO delivery(delivery_id, customer_id, time, status, area_code) VALUES(?,?,?,?,?)"; 
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, delivery_id);
            pstmt.setDouble(2, customer_id);
            pstmt.setTime(3, time);  
            pstmt.setString(4, status); 
            pstmt.setDouble(5, area_code);

            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        InsertDelivery app = new InsertDelivery();  
           
        app.insert(1,1, Time.valueOf("14:00:00"), "cooking", 6221);  
        app.insert(2, 2, Time.valueOf("17:12:53"),"out for delivery", 6331);  
        app.insert(3, 3, Time.valueOf("18:05:23"), "delivered", 6444);  
        app.insert(4, 4, Time.valueOf("10:07:55"), "processsing order",6555); 
        app.insert(5, 5, Time.valueOf("08:53:05"),"cooking", 6777);

    }  
   
}  
