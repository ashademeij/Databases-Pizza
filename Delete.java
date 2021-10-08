import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * A Java MySQL DELETE example.
 * Demonstrates the use of a SQL DELETE statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 * Created by Alvin Alexander, http://devdaily.com
 */
public class Delete
{

  public static void main(String[] args)
  {
    try
    {
      // create the mysql database connection
      //String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/Pizza_Shop?user=root&password=asha1234";
      //Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl);
      
      // create the mysql delete statement.
      // i'm deleting the row where the id is "3", which corresponds to my
      // "Barney Rubble" record.
      String query = "DROP TABLE pizza;";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      //preparedStmt.setInt(1, 3);

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }

  }
}
