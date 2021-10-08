package GUI;

import java.util.ArrayList;

public class Calculate {
    public static Menu m = new Menu();
    public static ArrayList<String> orderList = new ArrayList<String>();

    /**
     * This returns the total of the customers order
     * @return total
     */
    public static double calculate(){
        double total = 0.00;

        if(m.margherita.isSelected()){
            total += m.allPizza.selectCost("Magherita");
            orderList.add("Magherita");
        }
        if(m.pepperoni.isSelected()){
            total += m.allPizza.selectCost("Pepperoni");
            orderList.add("Pepperoni");
        }
        if(m.hawaiian.isSelected()){
            total += m.allPizza.selectCost("Hawaiian");
            orderList.add("Hawaiian");
        }
        if(m.veggie.isSelected()){
            total += m.allPizza.selectCost("Veggie");
            orderList.add("Veggie");
        }
        if(m.tonno.isSelected()){
            total += m.allPizza.selectCost("Tonno");
            orderList.add("Tonno");
        }
        if(m.bbq.isSelected()){
            total += m.allPizza.selectCost("BBQ Chicken");
            orderList.add("BBQ Chicken");
        }
        if(m.cheeses.isSelected()){
            total += m.allPizza.selectCost("Four cheese");
            orderList.add("Four cheese");
        }
        if(m.funghi.isSelected()){
            total += m.allPizza.selectCost("Funghi");
            orderList.add("Funghi");
        }
        if(m.mediterranea.isSelected()){
            total += m.allPizza.selectCost("Mediterranea");
            orderList.add("Mediterranea");
        }
        if(m.spinaci.isSelected()){
            total += m.allPizza.selectCost("Spinaci");
            orderList.add("Spinaci");
        }
        if(m.coke.isSelected()){
            total += m.allDrinks.selectCost("Coke");
            orderList.add("Coke");
        }
        if(m.sprite.isSelected()){
            total += m.allDrinks.selectCost("Sprite");
            orderList.add("Sprite");
        }
        if(m.fanta.isSelected()){
            total += m.allDrinks.selectCost("Fanta");
            orderList.add("Fanta");
        }
        if(m.iceTea.isSelected()){
            total += m.allDrinks.selectCost("Ice_Tea");
            orderList.add("Ice_Tea");
        }
        if(m.water.isSelected()){
            total += m.allDrinks.selectCost("Water");
            orderList.add("Water");
        }
        if(m.tiramisu.isSelected()){
            total += m.allDesserts.selectCost("Tiramisu");
            orderList.add("Tiramisu");
        }
        if(m.iceCream.isSelected()){
            total += m.allDesserts.selectCost("Ice Cream");
            orderList.add("Ice Cream");
        }
        
        return total;
        
    }
}
