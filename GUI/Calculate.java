package GUI;

import java.util.ArrayList;
import Insert.InsertOrder;


public class Calculate {
    public static Menu m = new Menu();
    public static ArrayList<String> orderList = new ArrayList<String>();
    public static InsertOrder order = new InsertOrder();
    public static ArrayList<String> pInO = new ArrayList<String>();
    public static ArrayList<String> drInO = new ArrayList<String>();
    public static ArrayList<String> dInO = new ArrayList<String>();

    /**
     * This returns the total of the customers order
     * @return total
     */
    public static double calculate(){
        double total = 0.00;

        if(m.margherita.isSelected()){
            total += m.allPizza.selectCost("Magherita");
            pInO.add("Magherita");
            orderList.add("Magherita");
        }
        if(m.pepperoni.isSelected()){
            total += m.allPizza.selectCost("Pepperoni");
            pInO.add("Pepperoni");
            orderList.add("Pepperoni");
        }
        if(m.hawaiian.isSelected()){
            total += m.allPizza.selectCost("Hawaiian");
            pInO.add("Hawaiian");
            orderList.add("Hawaiian");
        }
        if(m.veggie.isSelected()){
            total += m.allPizza.selectCost("Veggie");
            pInO.add("Veggie");
            orderList.add("Veggie");
        }
        if(m.tonno.isSelected()){
            total += m.allPizza.selectCost("Tonno");
            pInO.add("Tonno");
            orderList.add("Tonno");
        }
        if(m.bbq.isSelected()){
            total += m.allPizza.selectCost("BBQ Chicken");
            pInO.add("BBQ Chicken");
            orderList.add("BBQ Chicken");
        }
        if(m.cheeses.isSelected()){
            total += m.allPizza.selectCost("Four cheese");
            orderList.add("Four cheese");
            pInO.add("Four cheese");
        }
        if(m.funghi.isSelected()){
            total += m.allPizza.selectCost("Funghi");
            orderList.add("Funghi");
            pInO.add("Funghi");
        }
        if(m.mediterranea.isSelected()){
            total += m.allPizza.selectCost("Mediterranea");
            orderList.add("Mediterranea");
            pInO.add("Mediterranea");
        }
        if(m.spinaci.isSelected()){
            total += m.allPizza.selectCost("Spinaci");
            orderList.add("Spinaci");
            pInO.add("Spinaci");
        }
        if(m.coke.isSelected()){
            total += m.allDrinks.selectCost("Coke");
            drInO.add("Coke");
            orderList.add("Coke");
        }
        if(m.sprite.isSelected()){
            total += m.allDrinks.selectCost("Sprite");
            orderList.add("Sprite");
            drInO.add("Sprite");
        }
        if(m.fanta.isSelected()){
            total += m.allDrinks.selectCost("Fanta");
            drInO.add("Fanta");
            orderList.add("Fanta");
        }
        if(m.iceTea.isSelected()){
            total += m.allDrinks.selectCost("Ice_Tea");
            drInO.add("Ice_Tea");
            orderList.add("Ice_Tea");
        }
        if(m.water.isSelected()){
            total += m.allDrinks.selectCost("Water");
            drInO.add("Water");
            orderList.add("Water");
        }
        if(m.tiramisu.isSelected()){
            total += m.allDesserts.selectCost("Tiramisu"); 
            dInO.add("Tiramisu");
            orderList.add("Tiramisu");
        }
        if(m.iceCream.isSelected()){
            total += m.allDesserts.selectCost("Ice Cream");
            dInO.add("Ice Cream");
            orderList.add("Ice Cream");
        }
        
    
        return total;
        
    }
    public void addToOrder(){
        int index = 5;
        order.insert(index++, pInO.toString(), drInO.toString(), dInO.toString(),0.00,calculate());
    }
}
