package GUI;

import Select.SelectCustomer;
import Select.SelectDesserts;
import Select.SelectDrinks;
import Select.SelectPizza;

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

    

    public static String name;
    public static double total;

    public static int width = 500;
    public static int height = 300;

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
    public static JCheckBox spinaci = new JCheckBox("Spinachi");

    public static SelectDrinks allDrinks = new SelectDrinks();
    public static JCheckBox coke = new JCheckBox("Coke");
    public static JCheckBox sprite = new JCheckBox("Sprite");
    public static JCheckBox fanta = new JCheckBox("Fanta");
    public static JCheckBox iceTea = new JCheckBox("Ice Tea");
    public static JCheckBox water = new JCheckBox("Water");

    public static SelectDesserts allDesserts = new SelectDesserts();
    public static JCheckBox tiramisu = new JCheckBox("Tiramisu");
    public static JCheckBox iceCream = new JCheckBox("Ice Cream");
    public static void main(String []args){
        window();
    }
    /**
     * This method creates the initial customer log-in menu
     */
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
                CreateNewCustomer newC = new CreateNewCustomer();
                newC.fields();

            }
        });


    }
    /**
     * This method create the window that directs the customer to choose from our menu or create their own pizza
     */
    public static void welcome(){
        logInF.dispose();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        
        select.setLayout(new GridBagLayout());

        JLabel welcome = new JLabel("Welcome " + name + " to Pizzeria Masha!", SwingConstants.CENTER);
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

        frame.add(select);
        select.setBackground(Color.LIGHT_GRAY);

    }
    /**
     * This method shows the pizzeria's menu and allows a customer to pick whatever they want 
     * 
     */
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
                total.setText(Double.toString(calculate()) + "€");
                c.gridx = 3;
                c.gridy = 11;
                menuPanel.add(total,c);

                frame2.setSize(width+1,height+1);
            }
        });
         
        frame2.add(menuPanel);
    }
    
    /**
     * This returns the total of the customers order
     * @return total
     */
    private static double calculate(){
        if(margherita.isSelected()){
            total += allPizza.selectCost("Magherita");
        }
        if(pepperoni.isSelected()){
            total += allPizza.selectCost("Pepperoni");
        }
        if(hawaiian.isSelected()){
            total += allPizza.selectCost("Hawaiian");
        }
        if(veggie.isSelected()){
            total += allPizza.selectCost("Veggie");
        }
        if(tonno.isSelected()){
            total += allPizza.selectCost("Tonno");
        }
        if(bbq.isSelected()){
            total += allPizza.selectCost("BBQ Chicken");
        }
        if(cheeses.isSelected()){
            total += allPizza.selectCost("Four cheese");
        }
        if(funghi.isSelected()){
            total += allPizza.selectCost("Funghi");
        }
        if(mediterranea.isSelected()){
            total += allPizza.selectCost("Mediterranea");
        }
        if(spinaci.isSelected()){
            total += allPizza.selectCost("Spinaci");
        }
        if(coke.isSelected()){
            total += allDrinks.selectCost("Coke");
        }
        if(sprite.isSelected()){
            total += allDrinks.selectCost("Sprite");
        }
        if(fanta.isSelected()){
            total += allDrinks.selectCost("Fanta");
        }
        if(iceTea.isSelected()){
            total += allDrinks.selectCost("Ice_Tea");
        }
        if(water.isSelected()){
            total += allDrinks.selectCost("Water");
        }
        if(tiramisu.isSelected()){
            total += allDesserts.selectCost("Tiramisu");
        }
        if(iceCream.isSelected()){
            total += allDesserts.selectCost("Ice Cream");
        }
        
        return total;
        
    }
    private static void toppings(){
    
    }
}
