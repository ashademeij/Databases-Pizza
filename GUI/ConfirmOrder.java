package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class ConfirmOrder {
    public static JPanel orderPanel = new JPanel();
    public static JFrame orderFrame = new JFrame();
    public static int width = 500;
    public static int height = 300;
    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();
    public StringBuilder list = new StringBuilder();

    public void order(){
        orderPanel.setLayout(gl);

        orderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderFrame.setSize(width,height);
        
        JLabel conf = new JLabel("Your order summary is ");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 10;
        orderPanel.add(conf);

        JLabel order = new JLabel();
        Calculate cal = new Calculate();
        for(String i : cal.orderList){
            
            list.append(i + " ");
        }
        order.setText(list.toString());

        JButton confirm = new JButton("Confirm Order");

        c.gridx = 0;
        c.gridy = 3;
        orderPanel.add(order,c);

        orderFrame.add(orderPanel);
        orderFrame.setVisible(true);
    }
}
