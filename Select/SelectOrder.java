package Select;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class SelectOrder{

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
        String sql = "SELECT * FROM order";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getDouble("order_id") +  "\t" +   
                                   rs.getString("pizza") + "\t" +  
                                   rs.getString("drinks") + "\t" +  
                                   rs.getString("dessert") + "\t" +  
                                   rs.getDouble("discount") + "\t" + 
                                   rs.getDouble("total")+ "\t");
                                   
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
    }     

        public static void main(String[] args) {  
            SelectOrder app = new SelectOrder();  
            app.selectAll();  
        }  
}  

