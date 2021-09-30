package Insert;

public class InsertDrink {

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

    public void insert(int drink_id, String name, double cost_price) {  
        String sql = "INSERT INTO drink(" + drink_id +"," + name + "," + cost_price + ")";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setDouble(1, drink_id);  
            pstmt.setString(2, name);  
            pstmt.setDouble(3, cost_price);  
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    } 

    public static void main(String[] args) {  
   
        InsertDrink app = new InsertDrink();  
        app.insert(01, "Coke", 2.50); 
        app.insert(02, "Sprite", 2.50); 
        app.insert(03, "Fanta", 2.50);  
        app.insert(04, "Ice Tea", 2.50); 
        app.insert(05, "Water", 2.50); 
     
 
    }
}
