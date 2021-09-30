package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertEmployee {  
   
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
   
  
    public void insert(int name, char gender, int area_code) {  
        String sql = "INSERT INTO customers(" + name +"," + gender + "," + area_code + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            //idk what this stuff is 
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
