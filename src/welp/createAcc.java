/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Admin
 */
public class createAcc implements ActionListener{
    private static JLabel userLabel, pinLabel, success, reg;
    private static JTextField userField;
    private static JPasswordField pinField;
    private static JButton login, create;
    private static JPanel center, title, south;
    private static JFrame frame;
    createAcc(){
        //frame
        frame = new JFrame("REGISTER BANK ACCOUNT");
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JPanel(new BorderLayout());
        //title.setLayout(new FlowLayout());
        
        reg = new JLabel("REGISTER ACCOUNT:");
        reg.setFont(new Font("Arial", Font.BOLD, 24));
        title.add(reg);
        
        //center
        center = new JPanel();
        center.setPreferredSize(new Dimension(200,200));
        center.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        
        //user
        userLabel = new JLabel("Name:");
        userLabel.setFont(new Font("Arial", Font.BOLD, 24));
        userLabel.setBounds(10, 20, 80, 25);
        center.add(userLabel);

        userField = new JTextField(15);
        userField.setBounds(100, 20, 142, 25);
        center.add(userField);
        
        //pin
        pinLabel = new JLabel("Pin:");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pinLabel.setBounds(10, 50, 80, 25);
        center.add(pinLabel);
        
        pinField = new JPasswordField(15);
        pinField.setBounds(100, 50, 142, 25);
        center.add(pinField);
        
        //buttons
        create = new JButton ("Register");
        create.setBounds(113, 100, 125, 25);
        create.addActionListener(this);
        center.add(create);
        
        //shit
        south = new JPanel(new BorderLayout());
        south.setBackground(Color.yellow);
        
        success = new JLabel("");
        success.setBounds(10, 150, 300, 25);
        south.add(success);
        
        //frame.add
        frame.add(title, BorderLayout.NORTH);
        frame.add(center);
        frame.add(south, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = userField.getText();
        String pass = pinField.getText();
        
        if(!name.isEmpty() && !pass.isEmpty()){
            success.setText("TITI");
        }
    }
}
