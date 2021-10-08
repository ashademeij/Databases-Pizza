package GUI;

import javax.swing.*;

import Select.SelectDesserts;
import Select.SelectDrinks;
import Select.SelectPizza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;

public class Menu {

    public static JPanel menuPanel = new JPanel();
    public static JFrame frame2 = new JFrame("Pizza Menu");

    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();

    public static SelectPizza allPizza = new SelectPizza();
    public static JCheckBox margherita = new JCheckBox("Margherita");
    public static JCheckBox pepperoni = new JCheckBox("Pepperoni");
    public static JCheckBox hawaiian = new JCheckBox("Hawaiian");
    public static JCheckBox veggie = new JCheckBox("Veggie");
    public static JCheckBox tonno = new JCheckBox("Tonno");
    public static JCheckBox bbq = new JCheckBox("BBQ Chicken");
    public static JCheckBox cheeses = new JCheckBox("Four Cheese");
    public static JCheckBox funghi = new JCheckBox("Funghi");
    public static JCheckBox mediterranea = new JCheckBox("Mediterranea");
    public static JCheckBox spinaci = new JCheckBox("Spinaci");

    public static SelectDrinks allDrinks = new SelectDrinks();
    public static JCheckBox coke = new JCheckBox("Coke");
    public static JCheckBox sprite = new JCheckBox("Sprite");
    public static JCheckBox fanta = new JCheckBox("Fanta");
    public static JCheckBox iceTea = new JCheckBox("Ice Tea");
    public static JCheckBox water = new JCheckBox("Water");

    public static SelectDesserts allDesserts = new SelectDesserts();
    public static JCheckBox tiramisu = new JCheckBox("Tiramisu");
    public static JCheckBox iceCream = new JCheckBox("Ice Cream");

    public static JFrame warn = new JFrame("Warning!");

    public static ArrayList<JCheckBox> list = new ArrayList<JCheckBox>();


    public static int width = 500;
    public static int height = 300;
    /**
     * This method adds all the pizza's to an arraylist to iterate through it 
     */
    public static void addPiz(){
        list.add(margherita);
        list.add(pepperoni);
        list.add(hawaiian);
        list.add(veggie);
        list.add(tonno);
        list.add(bbq);
        list.add(cheeses);
        list.add(funghi);
        list.add(mediterranea);
        list.add(spinaci);
    }
    /**
     * This method shows the pizzeria's menu and allows a customer to pick whatever they want 
     * 
     */
    public static void menu(){
        addPiz();
        menuPanel.setLayout(new GridBagLayout());
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,300);
        frame2.setVisible(true);
        menuPanel.setLayout(gl);

        //adding each pizza
        JLabel pizzas = new JLabel("Pizzas");
        c.gridx = 0;
        c.gridy = 0;
        menuPanel.add(pizzas, c);

        c.gridx = 0;
        c.gridy = 1;
        menuPanel.add(margherita,c);

        c.gridx = 0;
        c.gridy = 2;
        menuPanel.add(pepperoni,c);
        
        c.gridx = 0;
        c.gridy = 3;
        menuPanel.add(hawaiian,c);
        
        c.gridx = 0;
        c.gridy = 4;
        menuPanel.add(veggie,c);
        
        c.gridx = 0;
        c.gridy = 5;
        menuPanel.add(tonno,c);
        
        c.gridx = 0;
        c.gridy = 6;
        menuPanel.add(bbq,c);

        c.gridx = 0;
        c.gridy = 7;
        menuPanel.add(cheeses,c);

        c.gridx = 0;
        c.gridy = 8;
        menuPanel.add(funghi,c);

        c.gridx = 0;
        c.gridy = 9;
        menuPanel.add(mediterranea,c);
        
        c.gridx = 0;
        c.gridy = 10;
        menuPanel.add(spinaci,c);

        //adding each drink
        JLabel drinks = new JLabel("Drinks");
        c.gridx = 5;
        c.gridwidth = 3;
        c.gridy = 0;
        menuPanel.add(drinks,c);

        c.gridx = 5;
        c.gridy = 1;
        menuPanel.add(coke,c);

        c.gridx = 5;
        c.gridy = 2;
        menuPanel.add(sprite,c);

        c.gridx = 5;
        c.gridy = 3;
        menuPanel.add(fanta,c);


        c.gridx = 5;
        c.gridy = 4;
        menuPanel.add(iceTea,c);

        
        c.gridx = 5;
        c.gridy = 5;
        menuPanel.add(water,c);

        //adding each dessert
        JLabel desserts = new JLabel("Desserts");
        c.gridx = 10;
        c.gridwidth = 3;
        c.gridy = 0;
        menuPanel.add(desserts,c);

        c.gridx = 10;
        c.gridy = 1;
        menuPanel.add(tiramisu,c);

        
        c.gridx = 10;
        c.gridy = 2;
        menuPanel.add(iceCream,c);

        //total cost of order
        JButton calculate = new JButton("Click to calculate total");
        c.gridx = 0;
        c.gridy = 11;
        menuPanel.add(calculate,c);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JLabel total = new JLabel();
                Calculate calculator = new Calculate();
                total.setText(Double.toString(calculator.calculate()) + "€");
                c.gridx = 3;
                c.gridy = 11;
                menuPanel.add(total,c);

                frame2.setSize(width+1,height+1);
            }
        });

        JButton confirm = new JButton("Confirm Order");
        c.gridx = 8;
        c.gridy = 11;
        menuPanel.add(confirm,c);

        confirm.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent event) {
                
                for(JCheckBox i : list){
                    if(i.isSelected()){
                        frame2.dispose();
                        ConfirmOrder confirmation = new ConfirmOrder();
                        confirmation.order();
                    }else{
                        
                        JPanel w = new JPanel();
                        w.setLayout(new GridBagLayout());
                        warn.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        warn.setSize(200,150);
                        
                        JLabel warning = new JLabel("Please select a pizza!");
                        warn.add(w);
                        w.add(warning);
                        warn.setVisible(true);
                    }
                }
                
            }
        });
        

         
        frame2.add(menuPanel);
    }
}
