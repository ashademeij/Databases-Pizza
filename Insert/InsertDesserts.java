package Insert;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  


public class InsertDesserts {

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

    public void insert(int desserts_id, String name, Double cost_price) {  
        String sql = "INSERT INTO dessert (desserts_id, name, cost_price) VALUES(?,?,?)";
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, desserts_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertDesserts app = new InsertDesserts();  
        app.insert(1,"Tiramisu", 4.20); 
        app.insert(2,"Ice Cream", 3.00); 
 
    }
    
}
