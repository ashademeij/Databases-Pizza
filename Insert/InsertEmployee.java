package Insert;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class InsertEmployee {  
   
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
   
  
    public void insert(int employee_id, String name, String gender, int area_code) {  
        String sql = "INSERT INTO employee(employee_id, name, gender,area_code) VALUES(?,?,?,?)"; 
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, employee_id);
            pstmt.setString(2, name);  
            pstmt.setString(3, gender); 
            pstmt.setDouble(4, area_code);

            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            System.out.println("NOT WORKING: EMPLOYEE"); 
        }  
    }  
   
    public static void main(String[] args) {  
   
        InsertEmployee app = new InsertEmployee();  
        // insert three new rows  
        app.insert(1,"Jeffrey", "M", 6221);  
        app.insert(2,"Mary", "F", 6331);  
        app.insert(3,"Elroy", "M", 6444);  
        app.insert(4,"Amber", "F",6555); 
        app.insert(5,"Ryoko", "F", 6777);

    }  
   
}  
