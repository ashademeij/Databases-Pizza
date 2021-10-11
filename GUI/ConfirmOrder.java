package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class ConfirmOrder {
    public static JPanel orderPanel = new JPanel();
    public static JFrame orderFrame = new JFrame();

    public static int width = 800;
    public static int height = 500;
    public static GridBagLayout gl = new GridBagLayout();
    public static GridBagConstraints c = new GridBagConstraints();
    public StringBuilder list = new StringBuilder();

    public static JLabel status = new JLabel();
    private static int updates;
    private static String updateText = "Status of order: ";

    public static Menu m = new Menu();

    public static JLabel timerL;
    public static int sec = 0;
    public static int min = 0;
    public static int elapsedT = 0;
    public static String displaySec = String.format("%02d", sec);
    public static String displayMin = String.format("%02d", min); 
    public static boolean started = false;

    private static JButton cancel;

    public static JLabel passedTime;
    public int index = 15;

    public void order(){
        orderPanel.setLayout(gl);

        orderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        orderFrame.setSize(width,height);
        
        JLabel conf = new JLabel("Your order summary is ");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 10;
        orderPanel.add(conf);

        JLabel order = new JLabel();
        Calculate cal = new Calculate();
        for(String i : cal.orderList){
            
            list.append(i + " ");
        }
        order.setText(list.toString());
        c.gridx = 0;
        c.gridy = 4;
        orderPanel.add(order,c);

        JLabel time = new JLabel("Estimated delivery time is: " + index + "mins");
        c.gridx = 0;
        c.gridy = 6;
        orderPanel.add(time,c);

        JButton updateT = new JButton("Delivery Time Update");
        
        updateT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                index--;
                time.setText("Estimated delivery time is: " + index + "mins");
                orderFrame.setSize(width+1,height+1);
            }
        });
        c.gridx = 0;
        c.gridy = 10;
        orderPanel.add(updateT,c);

        //orderPanel.add(passedTime);
        //orderPanel.add(passedTime);

        cancel = new JButton("Cancel Order");
        orderPanel.add(cancel);
        
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
                Menu s = new Menu();
                if( (s.stopwatch.min) > 1 ){
                    JFrame warn = new JFrame("Warning");
                    JPanel w = new JPanel();
                    w.setLayout(new GridBagLayout());
                    warn.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    warn.setSize(200,150);
                        
                    JLabel warning = new JLabel("5 minutes has passed, cannot cancel order");
                    warn.add(w);
                    w.add(warning);
                    warn.setVisible(true);
                }else {
                    updates = -1;
                    status.setText(updateText + "Cancelled");
                }
                
            }
        });
        c.gridx = 0;
        c.gridy = 12;
        orderPanel.add(cancel,c);

        JButton updateS = new JButton("Check status");
        c.gridx = 0;
        c.gridy = 8;
        orderPanel.add(status,c);

        updateS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                
                if(updates == -1){
                    status.setText(updateText + "Cancelled");
                }
                else if(updates == 0){
                    status.setText(updateText + "In process");
                    updates++;
                }else if(updates == 1){
                    status.setText(updateText + "Out for delivery");
                    updates++;
                }else if(updates == 2){
                    status.setText(updateText + "Delivered");
                    updates++;
                }

                orderFrame.setSize(width-1,height+1);
            }
        });
        c.gridx = 0;
        c.gridy = 12;
        orderPanel.add(updateS,c);

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


