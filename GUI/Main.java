package GUI;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{
    public static JPanel panel = new JPanel();
    public static JFrame frame = new JFrame("Pizza Menu");
    static int width = 5;
    static int height = 2;
    public static void main(String []args){
        window();
    }
    private static void window(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        addBasicComponents();
        frame.add(panel);
        frame.setVisible(true);
       
    }
    public static void addBasicComponents(){
        panel.setLayout(new GridLayout(4,4,4,4));
        JLabel welcome = new JLabel("Pizzeria Masha");
        
        panel.add(welcome);

        JButton diyPizza = new JButton("Make your own pizza!");
        panel.add(diyPizza);

        JButton menuPizza = new JButton("Choose a pizza from our menu!");
        panel.add(menuPizza);
        
        panel.setBackground(Color.CYAN);

        //JLabel pizzas = new JLabel("Choose your pizza");
        //panel.add(pizzas, BorderLayout.WEST);

    }
    private static void toppings(){
        //JRadioButton radio[] = new JRadioButton();

    }
}
