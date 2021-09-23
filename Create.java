import java.sql.Connection;  
import java.sql.DatabaseMetaData;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class Create{
    /** 
    * This method creates a database with a given String as it's name
    * @param The name of the database
    */
    public static void createNewDatabase(String fileName) {  
   
        String url = "jdbc:sqlite:/Users/helendemeij/Downloads/Databases-Pizza/" + fileName;  
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created.");  
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
  
    public static void main(String[] args) {  
        createNewDatabase("Pizza_Shop.db");
    }  
}
