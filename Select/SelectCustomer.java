package Select;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class SelectCustomer {  
   
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
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM customers";  
        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getDouble("customer_id") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getDouble("number")+ "\t" +
                                   rs.getString("address")+ "\t" +
                                   rs.getDouble("area_code")+ "\t" +
                                   rs.getDouble("no_of_orders")+ "\t");  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
     
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        SelectCustomer app = new SelectCustomer();  
        app.selectAll();  
    }  
   
}  
