package Tables;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class CreateAllTables{
    public static void main(String[] args){
        CreateCustomerTable.createNewTable(); //THIS WORKS YAYYY
        CreateDeliveryTable.createNewTable();
        CreateEmployeeTable.createNewTable();
        CreateNewTableDesserts.createNewTable();
        CreateNewTableDrinks.createNewTable();  //THIS WORKS YAYYY
        CreateNewTablePizza.createNewTable();
        CreateNewTableTopping.createNewTable();

    }
}