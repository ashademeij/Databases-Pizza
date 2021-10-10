package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
    JFrame frame = new JFrame(); //NO NEED FOR THIS BC WE'RE JUST USING THE LABEL
    JButton startB = new JButton("CONFIRM");
    JLabel timerL = new JLabel();
    JLabel overL = new JLabel("");

    public static ConfirmOrder cn = new ConfirmOrder();

    int sec = 0;
    int min = 0;
    int elapsedT = 0;
    
    String displaySec = String.format("%02d", sec);
    String displayMin = String.format("%02d", min); 
    boolean started = false;
    
    //IDK HOW TO ADD THIS SHIT
    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            elapsedT = elapsedT + 1000;
            min = (elapsedT/60000) % 60;
            sec = (elapsedT/1000) % 60;
            displaySec = String.format("%02d", sec);
            displayMin = String.format("%02d", min);
            timerL.setText(displayMin+":"+displaySec);
            
            
            if(displayMin.equals("1")){ //THIS SHIT DOESN'T WORK FOR SUM REASON
                overL.setText("Canecellation no longer possible");
                timer.stop();
            }
        }
    });
 
 
    Stopwatch(){
        // need this
        timerL.setText(displayMin+":"+displaySec);
        timerL.setBounds(100,100,200,100);
        timerL.setHorizontalAlignment(JTextField.CENTER);
        timerL.setFont(new Font("Verdana",Font.PLAIN,40));
        timerL.setOpaque(true);
        
        //WE JUST NEED TO ADD THESE TO OUR PANEL
        cn.orderPanel.add(overL,cn.c);
        cn.c.gridx = 0;
        cn.c.gridy = 16;
        
        
        cn.orderPanel.add(timerL,cn.c);
        cn.c.gridx = 0;
        cn.c.gridy = 14;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
  
        if(e.getSource()==startB) {
            
            //ADD IN CONFIRM ACTION LISTENER
            if(started==false) {
                started=true;
                start();
            }
        }
    }
 
    void start() {
        timer.start();
    }
 
    void stop() {
        timer.stop();
    }
    
}
