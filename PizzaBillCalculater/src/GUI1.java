import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI for the billGenerater is created using JFrame
// where GUI1 class extends the JFrame and ActionListener interface

public class GUI1 extends JFrame implements ActionListener {

    // Creating two button for regular and delux type
    JButton Regular = new JButton("Regular Pizza");
    JButton Delux = new JButton("Delux Pizza");
     
    // Constructor
     GUI1(){
        // creating the frame with following structure
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setTitle("Pizza Bill Calculator");
        this.setSize(1400, 700);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        
        //Creating the lables with following structures
        JLabel head = new JLabel("PIZZA CORNER"); // Lable name
        head.setFont(new Font("Arial", Font.BOLD, 50)); // Font and font size
        head.setForeground(Color.yellow); // Text Color
        head.setBounds(500, 50, 600, 50); // position and size of the lable
        this.add(head);

        JLabel head2 = new JLabel("The Taste u need...");
        head2.setFont(new Font("Arial", Font.ITALIC, 30));
        head2.setForeground(Color.RED);
        head2.setBounds(550, 100, 600, 50); 
        this.add(head2);

        JLabel head3 = new JLabel("Choose Your Favourite Pizza");
        head3.setFont(new Font("Arial", Font.BOLD, 30));
        head3.setForeground(Color.GREEN);
        head3.setBounds(500, 450, 600, 50); 
        this.add(head3);

        JLabel head4 = new JLabel(" 12/1 ABC street, Y Landmark, X city 2587, ph: 998877445566");
        head4.setFont(new Font("Arial", Font.PLAIN, 20));
        head4.setForeground(Color.white);
        head4.setBounds(100, 600, 800, 20); 
        this.add(head4);

        JLabel head5 = new JLabel("© Copyright 2023, All Rights Reserved");
        head5.setFont(new Font("Arial", Font.PLAIN, 20));
        head5.setForeground(Color.white);
        head5.setBounds(1000, 600, 600, 20); 
        this.add(head5);

        //creating the sytucture for regular and Delux buttons adding colors,font size,background color
        Regular.setBounds(200,300,400,100);
        Regular.setBackground(Color.CYAN);
        Regular.setFont(new Font("Arial", Font.BOLD, 30));
        Regular.setForeground(Color.darkGray);
        Delux.setBounds(800,300,400,100);
        Delux.setFont(new Font("Arial", Font.BOLD, 30));
        Delux.setForeground(Color.darkGray);
        Delux.setBackground(Color.CYAN);

        // adding the buttons to the frame
        this.add(Regular);
        // adding the action listeners to the button
        Regular.addActionListener(this);
        this.add(Delux);
        Delux.addActionListener(this);
     }

     //recieving the actions based on the click and caling the class accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
        //if regular is choosen calling the GUI2R class
        //if delux is choosen calling the GUI2D class
        if(e.getSource() == Regular){
            setVisible(false);
            new GUI2R().setVisible(true);
        }
        if(e.getSource() == Delux){
            setVisible(false);
            new GUI2D().setVisible(true);
      }
        
    }
    
}
