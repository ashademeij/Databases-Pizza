package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch extends Menu implements ActionListener{
    JFrame frame = new JFrame(); //NO NEED FOR THIS BC WE'RE JUST USING THE LABEL
    //JButton startB = new JButton("CONFIRM");
    JLabel timerL = new JLabel();
    JLabel overL = new JLabel("");
    JPanel panel = new JPanel();

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
            
            
            if(sec > 1){ 
                overL.setText("Canecellation no longer possible");
            }
        }
    });
 
 
    Stopwatch(){
        
    }

    public void now(){
        start();
    }

 
    @Override
    public void actionPerformed(ActionEvent e) {
  
        if(e.getSource()==confirm) {
            
            //ADD IN CONFIRM ACTION LISTENER
            if(started==false) {
                started=true;
                start();
            }
        }
    }
 
    void start() {
        timer.start();

        panel.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        
        // need this
        timerL.setText(displayMin+":"+displaySec);
        timerL.setBounds(100,100,200,100);
        timerL.setHorizontalAlignment(JTextField.CENTER);
        timerL.setFont(new Font("Verdana",Font.PLAIN,40));
        timerL.setOpaque(true);
        
        
        panel.add(overL);
        panel.add(timerL);
        frame.add(panel);

        frame.setVisible(true);
    }
 
    void stop() {
        timer.stop();
    }
    
}
