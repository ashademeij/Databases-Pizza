package Select;
import java.sql.*;
import java.util.ArrayList;

public class SelectCustomer {  
    public static String name;
    public static double number;
    public static String address;
    public static double area_code;
    public static double no_of_pizzas;
   
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
   
  
    public void selectAll(double id){  
        String sql = "SELECT * FROM customers WHERE customer_id='" + id + "';";  
        
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                name = rs.getString("name");
                number = rs.getDouble("number");
                address = rs.getString("address");
                area_code = rs.getDouble("area_code");
                no_of_pizzas = rs.getDouble("no_of_pizzas");

                System.out.println(rs.getDouble("customer_id") +  "\t" +   
                                    name + "\t" +  
                                   number + "\t" +
                                   address + "\t" +
                                   area_code + "\t" +
                                   no_of_pizzas + "\t"
                                   );  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }

    }

    /**
     * This method selects the customer_id and name from the database of customers in order
     * to display it on the GUI
     * @return An array list of all customers names and id's
     */
    
    public ArrayList<String> selectName(){
        String sql = "SELECT customer_id, name FROM customers";
        ArrayList<String> result = new ArrayList<String>();
        double customer_id;
        String name;
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                customer_id = rs.getDouble("customer_id");
                name = rs.getString("name");
                result.add(customer_id + " " + name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
    
     
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        SelectCustomer app = new SelectCustomer();  
        //app.selectAll();  
    }  
   
}  
