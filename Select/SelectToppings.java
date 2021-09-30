package Select;

public class SelectToppings {
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
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM toppings";  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getDouble("topping_id") +  "\t" +   
                                   rs.getString("name") + "\t" +  
                                   rs.getDouble("cost_price")+ "\t");
                                   
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
      
     
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        SelectToppings app = new SelectToppings();  
        app.selectAll();  
    } 
    
}
