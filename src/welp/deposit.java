/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;

/**
 *
 * @author Admin
 */

import java.awt.Color;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.Container;

public class Frame {
    
    Frame(){
        
        JOptionPane.showMessageDialog(null, "Welcome to Deposit!", "Greeting",JOptionPane.PLAIN_MESSAGE);
   
        JFrame frame = new JFrame();
        frame.setTitle("BANK MANAGEMENT SYSTEM");
        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    //  frame.setLayout(new GridLayout(7,3,10,100));
        frame.setLocationRelativeTo(null);
      //  frame.getContentPane().setBackground(Color.RED);
        frame.setLayout(null);
      
        
      JLabel mai = new JLabel("DEPOSIT");
      mai.setBounds(150,40,300,100);
      mai.setForeground(new Color(132,50,250));
      mai.setFont(new Font("georgia",Font.BOLD,60));
       
    
      JPanel pan = new JPanel();
      pan.setLayout(new GridLayout(8,5));
      pan.setSize(50,25);
      pan.setBounds(200,120,500,600);
    
    
        JLabel la2 = new JLabel("UserID:");
        JLabel la3 = new JLabel("Name:");
        JLabel la4 = new JLabel("Debit Account:");
        JLabel la7 = new JLabel("Available Balance:");
        JLabel la8 = new JLabel("Show");
        la8.setForeground(new Color(0x123456));
        JLabel la5 = new JLabel("Amount:");
        JLabel la6 = new JLabel("Credit Account:"); 
        
        
        JTextField text1 = new JTextField();
     //   text1.setPreferredSize(new Dimension(5,0));
        JTextField text2 = new JTextField();
     //   text1.setPreferredSize(new Dimension(5,0));
        JTextField text3 = new JTextField();
        JTextField text4 = new JTextField();
        JTextField text5 = new JTextField();
        JTextField text6 = new JTextField();
  
        JButton b1 = new JButton("Search");
      //  b1.setBackground(Color.gray);
        JButton b2 = new JButton("Enter");
      //  b2.setBackground(Color.gray);
        JButton b3 = new JButton("Total");
        JButton b4 = new JButton("Enter");
        JButton b5 = new JButton("OK");
        
        
        JButton b6 = new JButton("NEXT");
         b6.setBounds(250,200,500,600);
        JButton b7 = new JButton("EXIT");
        
    
        // pan.add(la1);
        
        pan.add(la2);
        pan.add(text1);
        pan.add(b1);
        
        pan.add(la3);
        pan.add(text2);
        pan.add(b2);
         
        pan.add(la4);
        pan.add(text3);
        pan.add(la8);
        
        pan.add(la7);
        pan.add(text6);
        pan.add(b5);
        
        
        pan.add(la5);
        pan.add(text4);
        pan.add(b3);
         
        pan.add(la6);
        pan.add(text5);
        pan.add(b4);
        
        pan.add(b7);
        pan.add(b6);
         
         
        frame.add(pan);
        frame.add(mai);
       
    }
}
