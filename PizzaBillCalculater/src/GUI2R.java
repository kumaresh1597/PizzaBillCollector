import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//GUI2R extends the Jframe and action listner.
//This frame will appear after the GUI1 frame if the any of the two pizza is selected , if not selected then this framedoesnt appear
// This frame calls the Pizza class in action listeners
public class GUI2R extends JFrame implements ActionListener {

    //Creating the buttons veg or non veg type , add chees , add toppings,add bags, generate bill and back
     JButton veg = new JButton("Veg Pizza");
     JButton NonVeg = new JButton("NON veg Pizza");

     JButton cheese = new JButton("Add cheese");
     JButton toppings = new JButton("Add Toppings");
     JButton bag = new JButton("Add bag");

     JButton bill = new JButton("Generate Bill");

     JButton back = new JButton("Back");

     boolean typeSelected;
     boolean select;

     GUI2R(){
        // creating the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setTitle("Regular");
        this.setSize(1400, 700);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);

        // creating the required lables
        JLabel head = new JLabel("Regular Pizza Menu"); // Lable name
        head.setFont(new Font("Arial", Font.BOLD, 50)); // Font and font size
        head.setForeground(Color.yellow); // Text Color
        head.setBounds(450, 50, 600, 50); // position and size of the lable
        this.add(head);

        JLabel head2 = new JLabel("Choose ur favourite");
        head2.setFont(new Font("Arial", Font.ITALIC, 30));
        head2.setForeground(Color.RED);
        head2.setBounds(550, 100, 600, 50); 
        this.add(head2);

        // creating the button structures
        veg.setBounds(200,200,300,100);
        veg.setBackground(Color.green);
        veg.setFont(new Font("Arial", Font.BOLD, 30));
        veg.setForeground(Color.darkGray);
        NonVeg.setBounds(800,200,300,100);
        NonVeg.setFont(new Font("Arial", Font.BOLD, 30));
        NonVeg.setForeground(Color.darkGray);
        NonVeg.setBackground(Color.orange);

        cheese.setBounds(200,350,200,50);
        cheese.setBackground(Color.pink);
        cheese.setFont(new Font("Arial", Font.BOLD, 20));
        cheese.setForeground(Color.blue);

        toppings.setBounds(200,450,200,50);
        toppings.setBackground(Color.pink);
        toppings.setFont(new Font("Arial", Font.BOLD, 20));
        toppings.setForeground(Color.blue);

        bag.setBounds(900,450,200,50);
        bag.setBackground(Color.pink);
        bag.setFont(new Font("Arial", Font.BOLD, 20));
        bag.setForeground(Color.blue);

        bill.setBounds(500,500,300,100);
        bill.setBackground(Color.CYAN);
        bill.setFont(new Font("Arial", Font.BOLD, 30));
        bill.setForeground(Color.magenta);

        back.setBounds(1000,600,100,50);
        back.setBackground(Color.RED);
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setForeground(Color.black);

        // Adding the action listeners to the buttons and adding the buttons to the frame
        this.add(veg);
        veg.addActionListener(this);
        this.add(NonVeg);
        NonVeg.addActionListener(this);
        this.add(cheese);
        cheese.addActionListener(this);
        this.add(toppings);
        toppings.addActionListener(this);
        this.add(bag);
        bag.addActionListener(this);
        this.add(bill);
        bill.addActionListener(this);
        this.add(back);
        back.addActionListener(this);

        select = false;
     }

    @Override
    // based on the click of the buttons action listeners are performed
    public void actionPerformed(ActionEvent evt) {
        // if it is veg ,then calls the pizza class with the boolean value true
        if(evt.getSource() == veg){
            try {
             Pizza order = new Pizza(true);
             typeSelected = true;
             select = true;
             // making the variables to false to avoid mis calculations
             Pizza.extraCheese = false;
             Pizza.extraToppings = false;
             Pizza.takeAway = false; 
             // using Joption pane to show the messege
             JOptionPane.showMessageDialog(this,"veg Pizza selected");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
           
        }
        if(evt.getSource() == NonVeg){
            // similaarly for non veg calles the Pizza class with the boolean value false
            try {
                Pizza order = new Pizza(false);
                typeSelected = false;
                select = true;
                Pizza.extraCheese = false;
                Pizza.extraToppings = false;
                Pizza.takeAway = false;  
                JOptionPane.showMessageDialog(this,"Nonveg Pizza selected");
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e.toString());
               }
        }
        if(evt.getSource() == cheese){  
            // if cheese clicked calls the method addcheese in pizza class 
            try {
                if(select){
                Pizza.addExtraCheese();
                JOptionPane.showMessageDialog(this,"Extra Cheese Added");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Please Select Pizza Type");  
                }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e.toString());
               }
        }
        if(evt.getSource() == toppings){ 
            // if toppings clicked calls the method addtoppings in pizza class      
           try {
            if(select){
            Pizza.addToppings();
            JOptionPane.showMessageDialog(this,"Extra Toppings Added");
            } else {
                JOptionPane.showMessageDialog(this,"Please Select Pizza Type"); 
            }
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.toString());
           }    
        }
        if(evt.getSource() == bag){
             // if bag clicked calls the method addbag in pizza class         
            try {
                if(select){
                Pizza.addBag();
                JOptionPane.showMessageDialog(this,"TakeAway Bag Added");
                } else {
                    JOptionPane.showMessageDialog(this,"Please Select Pizza Type");  
                }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e.toString());
               }

        }
        if(evt.getSource() == bill){
             // if generate bill clicked calls the method generate bill in pizza class 
           try {
            // getting the result string
            if(select){
            String finalBil = Pizza.generateBill(typeSelected);
            UIManager.put("OptionPane.minimumSize",new Dimension(500,300)); // changing the option pane size
            JOptionPane.showMessageDialog(this,"REGULAR "+finalBil); 
            UIManager.put("OptionPane.minimumSize",new Dimension(270,50)); // again changing the size to normal 
            select = false;
            } else {
                JOptionPane.showMessageDialog(this,"Please Select Pizza Type");
              }
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.toString());
           }
        }
         
        if(evt.getSource() == back){
            // if back clicked it will call the previous frame which is GUI1
            setVisible(false);
            new GUI1().setVisible(true);
            Pizza.extraCheese = false;
            Pizza.extraToppings = false;
            Pizza.takeAway = false;
        }
        
    }
    
    // public static void main(String[] args) {
    //     GUI2R p1 = new GUI2R();
    // }
    
}
