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

//This frame is similar to GUI2R except that it will not have addcheese and addtoppings buttons 
//and also it calls the Deux pizza class in actionListener
public class GUI2D extends JFrame implements ActionListener {
    JButton veg = new JButton("Veg Pizza");
    JButton NonVeg = new JButton("NON veg Pizza");

     JButton bag = new JButton("Add bag");

     JButton bill = new JButton("Generate Bill");

     JButton back = new JButton("Back");

     boolean typeSelected;
     boolean select;

     GUI2D(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setTitle("Delux");
        this.setSize(1400, 700);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);

        JLabel head = new JLabel("Delux Pizza Menu"); // Lable name
        head.setFont(new Font("Arial", Font.BOLD, 50)); // Font and font size
        head.setForeground(Color.yellow); // Text Color
        head.setBounds(450, 50, 600, 50); // position and size of the lable
        this.add(head);

        JLabel head2 = new JLabel("Choose ur favourite");
        head2.setFont(new Font("Arial", Font.ITALIC, 30));
        head2.setForeground(Color.RED);
        head2.setBounds(550, 100, 600, 50); 
        this.add(head2);

        veg.setBounds(200,250,300,100);
        veg.setBackground(Color.green);
        veg.setFont(new Font("Arial", Font.BOLD, 30));
        veg.setForeground(Color.darkGray);
        NonVeg.setBounds(800,250,300,100);
        NonVeg.setFont(new Font("Arial", Font.BOLD, 30));
        NonVeg.setForeground(Color.darkGray);
        NonVeg.setBackground(Color.orange);

        bag.setBounds(900,450,200,50);
        bag.setBackground(Color.pink);
        bag.setFont(new Font("Arial", Font.BOLD, 20));
        bag.setForeground(Color.blue);

        bill.setBounds(500,500,300,100);
        bill.setBackground(Color.cyan);
        bill.setFont(new Font("Arial", Font.BOLD, 30));
        bill.setForeground(Color.MAGENTA);

        back.setBounds(1000,600,100,50);
        back.setBackground(Color.RED);
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.setForeground(Color.black);

        this.add(veg);
        veg.addActionListener(this);
        this.add(NonVeg);
        NonVeg.addActionListener(this);
        this.add(bag);
        bag.addActionListener(this);
        this.add(bill);
        bill.addActionListener(this);
        this.add(back);
        back.addActionListener(this);

        select = false;
     }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == veg){
            try {
             DeluxPizza order = new DeluxPizza(true);
             typeSelected = true;
             select = true;
             Pizza.extraCheese = false;
             Pizza.extraToppings = false;
             Pizza.takeAway = false;  
             JOptionPane.showMessageDialog(this,"veg Pizza selected");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
           
        }
        if(evt.getSource() == NonVeg){
            try {
                DeluxPizza order = new DeluxPizza(false); 
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
        if(evt.getSource() == bag){         
            try {
                if(select){
                Pizza.addBag();
                JOptionPane.showMessageDialog(this,"TakeAway Bag Added");
                } else {
                    JOptionPane.showMessageDialog(this,"Please Select Pizza type");
                }
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e.toString());
               }

        }
        if(evt.getSource() == bill){ 
           try {
            if(select){
            String finalBil = Pizza.generateBill(typeSelected);
            UIManager.put("OptionPane.minimumSize",new Dimension(500,300));
            JOptionPane.showMessageDialog(this,"DELUX "+finalBil); 
            UIManager.put("OptionPane.minimumSize",new Dimension(270,50));
            select = false; 
         }  else {
            JOptionPane.showMessageDialog(this,"Please Select Pizza type");
         }
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.toString());
           }
        }
        if(evt.getSource() == back){
            setVisible(false);
            new GUI1().setVisible(true);
            Pizza.extraCheese = false;
            Pizza.extraToppings = false;
            Pizza.takeAway = false;
        }
    }
    
    // public static void main(String[] args) {
    //     GUI2D p2 = new GUI2D();
    // }
}
