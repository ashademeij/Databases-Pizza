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
   
  
    public void insert(String name, String gender, int area_code) {  
        String sql = "INSERT INTO customers(" + name +"," + gender + "," + area_code + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            //idk what this stuff is 
            pstmt.setString(1, name);  
            pstmt.setString(2, gender);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        InsertEmployee app = new InsertEmployee();  
        // insert three new rows  
        app.insert("Jeffrey", "M", 6221);  
        app.insert("Mary", "F", 6331);  
        app.insert("Elroy", "M", 6444);  
        app.insert("Amber", "F",6555); 
        app.insert("Ryoko", "F", 6777);

    }  
   
}  
