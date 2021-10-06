import java.sql.*;

public class Create{
    /** 
    * This method creates a database with a given String as it's name
    * @param The name of the database
    */
    public static void createNewDatabase(String name) {  
   
        String url = "jdbc:mysql://localhost/?user=root&password=asha1234";  
   
        try {  

            String create = "CREATE DATABASE " + name + ";";
            
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                Statement s = conn.createStatement();
                s.executeUpdate(create);

                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
  
    public static void main(String[] args) {  
        createNewDatabase("Pizza_Shop");
    }  
}
