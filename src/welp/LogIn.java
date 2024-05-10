/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class LogIn implements ActionListener{
    private static JPanel title, center;
    private static JFrame frame;
    private static JLabel userLabel, bam, pinLabel, word;
    private static JTextField userField;
    private static JPasswordField pinField;
    private static JButton login, create;
   
    
    LogIn(){
        //frame
        frame = new JFrame("BANK ACCOUNT MANAGEMENT");
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //center
        center = new JPanel();
        center.setPreferredSize(new Dimension(200,200));
        center.setLayout(new FlowLayout());
//        center.setBackground(Color.red);

        title = new JPanel(new BorderLayout());
        //title.setBackground(Color.blue);
        
        bam = new JLabel("BANK ACCOUNT MANAGEMENT:");
        bam.setFont(new Font("Arial", Font.BOLD, 24));
        title.add(bam);

         
        //pin
        pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        pinLabel.setBounds(10, 50, 80, 25);
        center.add(pinLabel);
        
        pinField = new JPasswordField(15);
        pinField.setBounds(100, 20, 142, 25);
        center.add(pinField);
        
        //buttons
        login = new JButton ("Login");
        login.setBounds(10, 100, 80, 25);
        login.addActionListener(this);
        center.add(login);
        
        create = new JButton ("Create Account");
        create.setBounds(113, 100, 125, 25);
        create.addActionListener(this);
        center.add(create);
        
        //word
        word = new JLabel("");
        word.setFont(new Font("Arial", Font.BOLD, 24));
        word.setBounds(10, 150, 300, 25);
        center.add(word);
        
        //frame.add
        frame.add(bam, BorderLayout.NORTH);
        frame.add(center);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass = pinField.getText();
        if (pass.equals("1")){
            if (e.getSource()==login){
                frame.dispose();
                MainMenu mm = new MainMenu();
                
            }
        }
        else if (e.getSource()==create){
            frame.dispose();
            createAcc ca = new createAcc();
        }
        else{
            word.setText("Error");
        }    
    }
    
}
