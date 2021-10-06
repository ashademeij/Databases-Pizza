package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame{
    public static JPanel panel = new JPanel();
    public static JPanel panel2 = new JPanel();
    public static JFrame frame = new JFrame("Pizza Shop");
    public static JFrame frame2 = new JFrame("Pizza Menu");
    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();

    public static void main(String []args){
        window();
    }

    private static void window(){
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.NONE;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        addBasicComponents();
        frame.add(panel);
        frame.setVisible(true);
       
    }
    public static void addBasicComponents(){
        panel.setLayout(new GridBagLayout());
        JLabel welcome = new JLabel("Welcome to Pizzeria Masha", SwingConstants.CENTER);
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 0;
        panel.add(welcome,c);

        JButton menuPizza = new JButton("Choose a pizza from our menu!");
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 1;
        menuPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu();
            }
        });
        panel.add(menuPizza,c);

        JButton diyPizza = new JButton("Make your own pizza!");
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 2;
        panel.add(diyPizza,c);


        
        panel.setBackground(Color.LIGHT_GRAY);

    }
    private static void menu(){
        panel2.setLayout(new GridBagLayout());
        frame.dispose();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,300);
        frame2.setVisible(true);
        panel2.setLayout(gl);

        JLabel pizzas = new JLabel("Pizza's");
        c.gridx = 0;
        c.gridy = 0;
        panel2.add(pizzas, c);

        JCheckBox margherita = new JCheckBox("Margherita");
        c.gridx = 0;
        c.gridy = 1;
        panel2.add(margherita,c);

        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        c.gridx = 0;
        c.gridy = 2;
        panel2.add(pepperoni,c);

        JCheckBox hawaiian = new JCheckBox("Hawaiian");
        c.gridx = 0;
        c.gridy = 3;
        panel2.add(hawaiian,c);

        JCheckBox veggie = new JCheckBox("Veggie");
        c.gridx = 0;
        c.gridy = 4;
        panel2.add(veggie,c);

        JCheckBox tonno = new JCheckBox("Tonno");
        c.gridx = 0;
        c.gridy = 5;
        panel2.add(tonno,c);

        JCheckBox bbq = new JCheckBox("BBQ Chicken");
        c.gridx = 0;
        c.gridy = 6;
        panel2.add(bbq,c);

        JCheckBox cheeses = new JCheckBox("Four Cheese");
        c.gridx = 0;
        c.gridy = 7;
        panel2.add(cheeses,c);

        JCheckBox funghi = new JCheckBox("Funghi");
        c.gridx = 0;
        c.gridy = 8;
        panel2.add(funghi,c);

        JCheckBox mediterranea = new JCheckBox("Mediterranea");
        c.gridx = 0;
        c.gridy = 9;
        panel2.add(mediterranea,c);

        JCheckBox spinaci = new JCheckBox("Spinachi");
        c.gridx = 0;
        c.gridy = 10;
        panel2.add(spinaci,c);


        JLabel drinks = new JLabel("Drinks");
        c.gridx = 5;
        c.gridwidth = 3;
        c.gridy = 0;
        panel2.add(drinks,c);

        JCheckBox coke = new JCheckBox("Coke");
        c.gridx = 5;
        c.gridy = 1;
        panel2.add(coke,c);

        JCheckBox sprite = new JCheckBox("Sprite");
        c.gridx = 5;
        c.gridy = 2;
        panel2.add(sprite,c);

        JCheckBox fanta = new JCheckBox("Fanta");
        c.gridx = 5;
        c.gridy = 3;
        panel2.add(fanta,c);

        JCheckBox iceTea = new JCheckBox("Ice Tea");
        c.gridx = 5;
        c.gridy = 4;
        panel2.add(iceTea,c);

        JCheckBox water = new JCheckBox("Water");
        c.gridx = 5;
        c.gridy = 5;
        panel2.add(water,c);

        frame2.add(panel2);
    }
    private static void toppings(){
        //JRadioButton radio[] = new JRadioButton();

    }
}
