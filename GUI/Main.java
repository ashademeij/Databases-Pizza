package GUI;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    public static JPanel panel = new JPanel();
    public static JFrame frame = new JFrame("Pizza Menu");
    public static void main(String []args){
        window();
    }
    private static void window(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);

        addBasicComponents();

        frame.add(panel);
        panel.setLayout(new BorderLayout());

        frame.setLayout(null);
        frame.setVisible(true);
        frame.revalidate();
    }
    public static void addBasicComponents(){
        JLabel welcome = new JLabel("Pizzeria Masha");
        panel.add(welcome, BorderLayout.NORTH);

        JButton diyPizza = new JButton("Make your own pizza!");
        panel.add(diyPizza, BorderLayout.WEST);

        JButton menuPizza = new JButton("Choose a pizza from our menu!");
        panel.add(menuPizza, BorderLayout.EAST);
        
        panel.setBackground(Color.CYAN);
        panel.validate();

        //JLabel pizzas = new JLabel("Choose your pizza");
        //panel.add(pizzas, BorderLayout.WEST);

    }
    private static void toppings(){
        //JRadioButton radio[] = new JRadioButton();

    }
}
