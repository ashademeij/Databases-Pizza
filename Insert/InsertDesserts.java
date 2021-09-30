package Insert;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
import java.util.function.DoublePredicate;

public class InsertDesserts {

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

    public void insert(String name, Double cost_price) {  
        String sql = "INSERT INTO desserts(" + name + "," + cost_price + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            //pstmt.setDouble(1, dessert_id);  
            pstmt.setString(1, name);  
            pstmt.setDouble(2, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertDesserts app = new InsertDesserts();  
        app.insert("Tiramisu", 3.50); 
        app.insert("Ice Cream", 3.00); 
 
    }
    
}
