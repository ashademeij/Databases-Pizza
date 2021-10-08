package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmOrder {
    public static JPanel orderPanel = new JPanel();
    public static JFrame orderFrame = new JFrame();
    public static int width = 800;
    public static int height = 500;
    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();
    public StringBuilder list = new StringBuilder();

    //public static JLabel passedTime;
    //public static JLabel timeOver;


    public int index = 15;

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
        c.gridx = 0;
        c.gridy = 2;
        orderPanel.add(order,c);

        JLabel time = new JLabel("Estimated delivery time is: " + index + "mins");
        c.gridx = 0;
        c.gridy = 4;
        orderPanel.add(time,c);

        JButton update = new JButton("Delivery Time Update");
        
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                index--;
                time.setText("Estimated delivery time is: " + index + "mins");
                orderFrame.setSize(width+1,height+1);
            }
        });
        c.gridx = 1;
        c.gridy = 5;
        orderPanel.add(update,c);


        
        JButton cancel = new JButton("Cancel Order");
        orderPanel.add(cancel);
        //orderPanel.add(passedTime);
        //orderPanel.add(passedTime);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
            }
        });
        c.gridx = 0;
        c.gridy = 7;
        orderPanel.add(cancel,c);

        orderFrame.add(orderPanel);
        orderFrame.setVisible(true);
            
    }

        /*public void cancelCountdown() {
            
            try {
                int timeLimit= 5 * 60; // Convert to seconds
                long delay = timeLimit * 1000;

                do {
                    int minutes = timeLimit / 60;
                    int seconds = timeLimit % 60;
                    passedTime.setText(minutes +" minute(s), " + seconds + " second(s)");
                    Thread.sleep(1000);
                    timeLimit = timeLimit - 1;
                    delay = delay - 1000;
                }
                while (delay != 0);
                    timeOver.setText("Order cancellation no longer possible");
        
            } catch (InterruptedException e) {
                
                //error
            }

        }*/
    
}


