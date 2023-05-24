package ATMsimulator;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    String pin;
    Deposit(String pin){
        this.pin = pin;
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);*/
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT ");
        //l1.setForeground(Color.BLACK);
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        //l2.setForeground(Color.BLACK);
        l2.setFont(new Font("System",Font.BOLD,35));
        
        
        l3 = new JLabel("Enter Pin:");
        l3.setFont(new Font("System",Font.BOLD,14));
        
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        
        b2 = new JButton("BACK");
        b2.setFont(new Font("System",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System",Font.BOLD,18));
        b3.setBackground(Color.black);
        b3.setForeground(Color.WHITE);
        
       
        
        setLayout(null);
        
        l1.setBounds(150,150,800,60);
        add(l1);
        
        l2.setBounds(290, 210, 800, 60);
        add(l2);
        
        l3.setBounds(620, 10, 80, 30);
        add(l3);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        t2.setBounds(700,10,40,30);
        add(t2);
        
        b1.setBounds(260,380,125,50);
        add(b1);
        
        b2.setBounds(415,380,125,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        //setUndecorated(true);
        setLocation(500,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    conn c1 = new conn();
                    c1.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new Transaction(pin).setVisible(true);
            }else if(ae.getSource()==b3){
            	System.exit(0);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
