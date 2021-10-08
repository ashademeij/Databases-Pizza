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

    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();

    public static String name;

    public static int width = 500;
    public static int height = 300;

    
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
                frame.dispose();
                Menu menu1 = new Menu();
                menu1.menu();
            }
        });
        select.add(menuPizza,c);

        JButton diyPizza = new JButton("Make your own pizza!");
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 2;

        diyPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Toppings t = new Toppings();
                t.order();
            }
        });
        select.add(diyPizza,c);

        frame.add(select);
        select.setBackground(Color.LIGHT_GRAY);

    }
    
}
