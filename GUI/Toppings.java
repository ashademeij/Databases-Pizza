package GUI;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Select.SelectToppings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class Toppings {
    static Calculate m = new Calculate();
    public static SelectToppings allToppings = new SelectToppings();
    public static JCheckBox cheddar = new JCheckBox("Cheddar");
    public static JCheckBox pepperoni = new JCheckBox("Pepperoni");
    public static JCheckBox pineapple = new JCheckBox("Pineapple");
    public static JCheckBox tuna = new JCheckBox("Tuna");
    public static JCheckBox chicken = new JCheckBox("Chicken");
    public static JCheckBox mushrooms = new JCheckBox("Mushrooms");
    public static JCheckBox scampi = new JCheckBox("Scampi");
    public static JCheckBox emmental = new JCheckBox("Emmental");
    public static JCheckBox mozzarella = new JCheckBox("Mozzarella");
    public static JCheckBox gouda = new JCheckBox("Gouda");

    public static JPanel top = new JPanel();
    public static JFrame topF = new JFrame();

    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();

    public static int width = 500;
    public static int height = 300;
    
    public static void order(){
        top.setLayout(new GridBagLayout());
        topF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topF.setSize(500,300);
        top.setLayout(gl);

        //adding each topping
        JLabel toppings = new JLabel("Toppings");
        c.gridx = 0;
        c.gridy = 0;
        top.add(toppings, c);

        c.gridx = 0;
        c.gridy = 1;
        top.add(cheddar,c);

        c.gridx = 0;
        c.gridy = 2;
        top.add(pepperoni,c);
        
        c.gridx = 0;
        c.gridy = 3;
        top.add(pineapple,c);
        
        c.gridx = 0;
        c.gridy = 4;
        top.add(tuna,c);
        
        c.gridx = 0;
        c.gridy = 5;
        top.add(chicken,c);
        
        c.gridx = 0;
        c.gridy = 6;
        top.add(mushrooms,c);

        c.gridx = 0;
        c.gridy = 7;
        top.add(scampi,c);

        c.gridx = 0;
        c.gridy = 8;
        top.add(emmental,c);

        c.gridx = 0;
        c.gridy = 9;
        top.add(mozzarella,c);
        
        c.gridx = 0;
        c.gridy = 10;
        top.add(gouda,c);

        //total cost of order
        JButton calculate = new JButton("Click to calculate total");
        c.gridx = 0;
        c.gridy = 11;
        top.add(calculate,c);

        calculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JLabel total = new JLabel();
                
                total.setText(Double.toString(calculate()) + "€");
                c.gridx = 3;
                c.gridy = 11;
                top.add(total,c);

                topF.setSize(width+1,height+1);
            }
        });

        JLabel info = new JLabel("Clicking confirm will take you to the menu where you can add drinks and desserts if desired");
        c.gridx = 8;
        c.gridy = 9;
        top.add(info,c);

        JButton confirm = new JButton("Confirm Order");
        c.gridx = 8;
        c.gridy = 11;
        top.add(confirm,c);

        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                topF.dispose();
                Menu menu = new Menu();
                menu.menu();
            }
        });

        topF.add(top);
        topF.setVisible(true);
    }

    public static double calculate(){
        double total = 0.00;

        if(cheddar.isSelected()){
            total += allToppings.selectCost("Magherita");
            m.orderList.add("Magherita");
        }
        if(pepperoni.isSelected()){
            total += allToppings.selectCost("Pepperoni");
            m.orderList.add("Pepperoni");
        }
        if(pineapple.isSelected()){
            total += allToppings.selectCost("Pineapple");
            m.orderList.add("Pineapple");
        }
        if(tuna.isSelected()){
            total += allToppings.selectCost("Tuna");
            m.orderList.add("Tuna");
        }
        if(chicken.isSelected()){
            total += allToppings.selectCost("Chicken");
            m.orderList.add("Chicken");
        }
        if(mushrooms.isSelected()){
            total += allToppings.selectCost("Mushrooms");
            m.orderList.add("Mushrooms");
        }
        if(scampi.isSelected()){
            total += allToppings.selectCost("Scampi");
            m.orderList.add("Scampi");
        }
        if(emmental.isSelected()){
            total += allToppings.selectCost("Emmental");
            m.orderList.add("Emmental");
        }
        if(mozzarella.isSelected()){
            total += allToppings.selectCost("Mozzarella");
            m.orderList.add("Mozzarella");
        }
        if(gouda.isSelected()){
            total += allToppings.selectCost("Gouda");
            m.orderList.add("Gouda");
        }
        return total;
        
    }
}
