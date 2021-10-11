package Tables;

public class CreateAllTables{
    public static void main(String[] args){
        CreateCustomerTable.createNewTable(); 
        CreateDeliveryTable.createNewTable(); 
        CreateEmployeeTable.createNewTable();
        CreateNewTableDesserts.createNewTable();
        CreateNewTableDrinks.createNewTable(); 
        CreateNewTablePizza.createNewTable(); 
        CreateNewTableTopping.createNewTable(); 
        CreateOrderTable.createNewTable();

    }
}
