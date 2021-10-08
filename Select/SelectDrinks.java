package Select;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class SelectDrinks {  
   
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
        String sql = "SELECT * FROM drink";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getDouble("drink_id") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getDouble("cost_price")+ "\t");
                                   
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  

    public double selectCost(String name){
        String sql = "SELECT cost_price FROM drink WHERE name='" + name + "';";
        double x = 0.00;

        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                x = rs.getDouble("cost_price");   
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return x;
    }
      
     
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        SelectDrinks app = new SelectDrinks();  
        app.selectAll();  
    }  
   
}  
