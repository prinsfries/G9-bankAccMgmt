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
    private static JFrame frame;    
    private static JLabel mainMenu;
    private static JButton withdraw, deposit, transac, pay, balance;
    private static JPanel panel, title;
    
    MainMenu(){
        panel = new JPanel();
        frame = new JFrame("BANK ACCOUNT MANAGEMENT");
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        panel.setLayout(new GridLayout(5,1));
        panel.setPreferredSize(new Dimension(250,200));
        //panel.setBackground(Color.red);
        
        title = new JPanel(new BorderLayout());
        //title.setPreferredSize(new Dimension(50,200));
        
        mainMenu = new JLabel("MAIN MENU", SwingConstants.CENTER);
        mainMenu.setFont(new Font("Arial", Font.BOLD, 48));
        mainMenu.setBounds(10, 20, 250, 25);
        title.add(mainMenu);
        
        
        
        withdraw = new JButton ("Withdraw");
        withdraw.setFont(new Font("Arial", Font.BOLD, 24));
        withdraw.setBounds(10, 150, 150, 25);
        withdraw.addActionListener(this);
        panel.add(withdraw);
        
        deposit = new JButton ("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 24));
        deposit.setBounds(10, 200, 150, 25);
        deposit.addActionListener(this);
        panel.add(deposit);
        
        transac = new JButton ("Transactions");
        transac.setFont(new Font("Arial", Font.BOLD, 24));
        transac.setBounds(10, 200, 150, 25);
        transac.addActionListener(this);
        panel.add(transac);
        
        pay = new JButton ("Auto Payments");
        pay.setFont(new Font("Arial", Font.BOLD, 24));
        pay.setBounds(10, 200, 150, 25);
        pay.addActionListener(this);
        panel.add(pay);
        
        balance = new JButton ("Balances");
        balance.setFont(new Font("Arial", Font.BOLD, 24));
        balance.setBounds(10, 200, 150, 25);
        balance.addActionListener(this);
        panel.add(balance);
        
        frame.add(panel);
        frame.add(title,BorderLayout.NORTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          if (e.getSource()==withdraw){
            frame.dispose();
            withdraw wd = new withdraw();
            }
          else if (e.getSource()==deposit){
            frame.dispose();
            deposit dp = new deposit();
            }
          else if (e.getSource()==transac){
            frame.dispose();
            accTransac at = new accTransac();
            }
          else if (e.getSource()==pay){
            frame.dispose();
            autoPay ap = new autoPay();
            }
          else if (e.getSource()==balance){
            frame.dispose();
            tracking t = new tracking();
            }
    }
}
