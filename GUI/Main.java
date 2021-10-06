package GUI;

import Select.SelectCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame{
    public static JPanel logIn = new JPanel();
    public static JFrame logInF = new JFrame("Log in screen");

    public static JPanel select = new JPanel();
    public static JFrame frame = new JFrame("Pizza Shop");

    public static JPanel menuPanel = new JPanel();
    public static JFrame frame2 = new JFrame("Pizza Menu");

    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();

    public static String name;;

    static int width = 500;
    static int height = 300;

    public static void main(String []args){
        window();
    }

    private static void window(){
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.NONE;

        logInF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInF.setSize(width,height);
        customerLogIn();
        logInF.add(logIn);
        logInF.setVisible(true);
       
    }
    /**
     * This method allows a user to log into their profile 
     * Here they can place an order and see their number of past orders
     */
    public static void customerLogIn(){
        logIn.setLayout(new GridBagLayout());

        JLabel user = new JLabel("Select Customer Name");
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 0;
        logIn.add(user,c);

        SelectCustomer sc = new SelectCustomer();
        JComboBox customers = new JComboBox((sc.selectName()).toArray());
        c.gridx = 0;
        c.gridy = 2;
        logIn.add(customers,c);
        

        //TODO: doesn't do the write thing, we wan't it to open another frame
        customers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox customers = (JComboBox) event.getSource();

                Object selected = customers.getSelectedItem();
                for(int i=0; i<sc.selectName().size(); i++){
                    if(selected.toString().equals(sc.selectName().get(i)))
                        name = sc.selectName().get(i);
                }
                welcome();
            }
        });

        JLabel createNew = new JLabel("or create new profile!");
        c.gridx = 0;
        c.gridy = 3;
        logIn.add(createNew,c);

        JButton createProfile = new JButton("Create new profile.");
        c.gridx = 0;
        c.gridy = 4;
        logIn.add(createProfile,c);

        createProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //createNewCustomer();
            }
        });


    }
    
    public static void welcome(){
        select.setLayout(new GridBagLayout());

        JLabel welcome = new JLabel("Welcome" + name + "to Pizzeria Masha", SwingConstants.CENTER);
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 0;
        select.add(welcome,c);

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
        select.add(menuPizza,c);

        JButton diyPizza = new JButton("Make your own pizza!");
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 2;
        select.add(diyPizza,c);

        select.setBackground(Color.LIGHT_GRAY);

    }
    private static void menu(){
        menuPanel.setLayout(new GridBagLayout());
        frame.dispose();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,300);
        frame2.setVisible(true);
        menuPanel.setLayout(gl);

        //adding each pizza
        JLabel pizzas = new JLabel("Pizzas");
        c.gridx = 0;
        c.gridy = 0;
        menuPanel.add(pizzas, c);

        JCheckBox margherita = new JCheckBox("Margherita");
        c.gridx = 0;
        c.gridy = 1;
        menuPanel.add(margherita,c);

        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        c.gridx = 0;
        c.gridy = 2;
        menuPanel.add(pepperoni,c);

        JCheckBox hawaiian = new JCheckBox("Hawaiian");
        c.gridx = 0;
        c.gridy = 3;
        menuPanel.add(hawaiian,c);

        JCheckBox veggie = new JCheckBox("Veggie");
        c.gridx = 0;
        c.gridy = 4;
        menuPanel.add(veggie,c);

        JCheckBox tonno = new JCheckBox("Tonno");
        c.gridx = 0;
        c.gridy = 5;
        menuPanel.add(tonno,c);

        JCheckBox bbq = new JCheckBox("BBQ Chicken");
        c.gridx = 0;
        c.gridy = 6;
        menuPanel.add(bbq,c);

        JCheckBox cheeses = new JCheckBox("Four Cheese");
        c.gridx = 0;
        c.gridy = 7;
        menuPanel.add(cheeses,c);

        JCheckBox funghi = new JCheckBox("Funghi");
        c.gridx = 0;
        c.gridy = 8;
        menuPanel.add(funghi,c);

        JCheckBox mediterranea = new JCheckBox("Mediterranea");
        c.gridx = 0;
        c.gridy = 9;
        menuPanel.add(mediterranea,c);

        JCheckBox spinaci = new JCheckBox("Spinachi");
        c.gridx = 0;
        c.gridy = 10;
        menuPanel.add(spinaci,c);

        //adding each drink
        JLabel drinks = new JLabel("Drinks");
        c.gridx = 5;
        c.gridwidth = 3;
        c.gridy = 0;
        menuPanel.add(drinks,c);

        JCheckBox coke = new JCheckBox("Coke");
        c.gridx = 5;
        c.gridy = 1;
        menuPanel.add(coke,c);

        JCheckBox sprite = new JCheckBox("Sprite");
        c.gridx = 5;
        c.gridy = 2;
        menuPanel.add(sprite,c);

        JCheckBox fanta = new JCheckBox("Fanta");
        c.gridx = 5;
        c.gridy = 3;
        menuPanel.add(fanta,c);

        JCheckBox iceTea = new JCheckBox("Ice Tea");
        c.gridx = 5;
        c.gridy = 4;
        menuPanel.add(iceTea,c);

        JCheckBox water = new JCheckBox("Water");
        c.gridx = 5;
        c.gridy = 5;
        menuPanel.add(water,c);

        //adding each dessert
        JLabel desserts = new JLabel("Desserts");
        c.gridx = 10;
        c.gridwidth = 3;
        c.gridy = 0;
        menuPanel.add(desserts,c);

        JCheckBox tiramisu = new JCheckBox("Tiramisu");
        c.gridx = 10;
        c.gridy = 1;
        menuPanel.add(tiramisu,c);

        JCheckBox iceCream = new JCheckBox("Ice Cream");
        c.gridx = 10;
        c.gridy = 2;
        menuPanel.add(iceCream,c);

        //total cost of order

        frame2.add(menuPanel);
    }
    private static void toppings(){
        //JRadioButton radio[] = new JRadioButton();

    }
}
