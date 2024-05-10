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
public class MainMenu implements ActionListener{
    private static JFrame mm;    
    private static JLabel mainMenu;
    private static JButton create;
    private static JButton withDraw;
    private static JButton deposit;
    private static JPanel panel;
    
    MainMenu(){
        panel = new JPanel();
        mm = new JFrame();
        mm.setSize(420,420);
        mm.setLocationRelativeTo(null);
        mm.setLayout(new FlowLayout(FlowLayout.CENTER,0,100));
        mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mm.add(panel);
        
        panel.setPreferredSize(new Dimension(250,200));
        panel.setLayout(new FlowLayout());
        //panel.setBackground(Color.red);
        
        mainMenu = new JLabel("BANK ACCOUNT MANAGEMENT");
        mainMenu.setFont(new Font("Arial", Font.BOLD, 14));
        mainMenu.setBounds(10, 20, 250, 25);
        panel.add(mainMenu);
        
        
        
        withDraw = new JButton ("Withdraw");
        withDraw.setBounds(10, 150, 150, 25);
        withDraw.addActionListener(this);
        panel.add(withDraw);
        
        deposit = new JButton ("Deposit");
        deposit.setBounds(10, 200, 150, 25);
        deposit.addActionListener(this);
        panel.add(deposit);
        
        mm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
