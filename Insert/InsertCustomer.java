package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertCustomer {  
   
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
   
  
    public void insert(String name, int number, String address, int area_code, int no_of_orders) {  
        String sql = "INSERT INTO customers(" + name +"," + number +"," 
                                                + address + "," + area_code + "," + no_of_orders + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setDouble(2, number);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        InsertCustomer app = new InsertCustomer();  
        // insert three new rows  
        app.insert("Michelle", 911, "Alexander Battalaan 24F",6221, 0);  
        app.insert("McLaws", 40000, "Professor Pieter 21C",6224, 0);  
        app.insert("Elme", 50000, "Tongerseweg 139 D07", 6213, 0);  
        app.insert("Francesca", 60000, "Tongerseweg 139 D06",6213, 0); 
        app.insert("Ryan", 7777, "Markt 34", 6226, 0);
    }  
   
}  
