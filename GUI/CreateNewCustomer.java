package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Insert.InsertCustomer;


public class CreateNewCustomer {
    public static JPanel create = new JPanel();
    public static JFrame cFrame = new JFrame();
    static int customer_id;
    static String name;
    static double number;
    static String address;
    static double area_code;
    static double no_of_orders;

    public static int width = 500;
    public static int height = 300;

    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();
    public static int index = 5;
    
    public static void fields(){
        cFrame.setVisible(true);
        cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cFrame.setSize(width,height);
        create.setLayout(new GridBagLayout());
        
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.NONE;
        JLabel l = new JLabel("Enter details below");
        c.gridx = 0;
        c.gridy = 0;
        create.add(l,c);

        JTextField name = new JTextField("Enter name");
        c.gridx = 0;
        c.gridy = 2;
        create.add(name,c);

        JTextField number = new JTextField("Enter phone number");
        c.gridx = 0;
        c.gridy = 3;
        create.add(number,c);

        JTextField address = new JTextField("Enter home address");
        c.gridx = 0;
        c.gridy = 4;
        create.add(address,c);

        JTextField area_code = new JTextField("Enter area code of house");
        c.gridx = 0;
        c.gridy = 5;
        create.add(area_code,c);

        JButton created = new JButton("Create");
        created.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index++;
                create(name.getText(),Integer.parseInt(number.getText()),address.getText(),Integer.parseInt(area_code.getText()),0);
                Main main = new Main();
                main.name = index + " " + name.getText();
                main.welcome();

            }
        });
        c.gridx = 0;
        c.gridy = 6;
        create.add(created,c);

        cFrame.add(create);


    }

    public static void create(String name, int number, String address, int area_code, int no_of_orders){
        InsertCustomer newC = new InsertCustomer();
        newC.insert(index, name, number, address, area_code, no_of_orders);
    }
}
