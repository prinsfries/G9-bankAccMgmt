
package welp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu implements ActionListener{
    private static JFrame frame;    
    private static JLabel mainMenu, welcome;
    private static JButton withdraw, deposit, transac, logout, balance, transfer;
    private static JPanel panel, title;
    private static String u, p, n;
    private static int m;
    
    MainMenu(String un, String pin, String an, int money){
        u = un;
        p = pin;
        m = money;
        n = an;
        
        System.out.println("main menu");
        System.out.println(un);
        System.out.println(pin);
        System.out.println(money);
        System.out.println(an);
        panel = new JPanel();
        frame = new JFrame("BANK ACCOUNT MANAGEMENT");
        frame.setSize(620,420);
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
        
        transfer = new JButton ("Transfer");
        transfer.setFont(new Font("Arial", Font.BOLD, 24));
        transfer.setBounds(10, 200, 150, 25);
        transfer.addActionListener(this);
        panel.add(transfer);
        
        balance = new JButton ("Balance");
        balance.setFont(new Font("Arial", Font.BOLD, 24));
        balance.setBounds(10, 200, 150, 25);
        balance.addActionListener(this);
        panel.add(balance);
        
        logout = new JButton ("Log out");
        logout.setFont(new Font("Arial", Font.BOLD, 24));
        logout.setBounds(10, 200, 150, 25);
        logout.addActionListener(this);
        panel.add(logout);
        
        welcome = new JLabel("Welcome, "+u+"!", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 24));
        welcome.setBounds(10, 20, 250, 25);
        panel.add(welcome);
        
        frame.add(panel);
        frame.add(title,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
          if (e.getSource()==withdraw){
            frame.dispose();
            withdraw wd = new withdraw(u,p,n,m);
            }
          else if (e.getSource()==deposit){
            frame.dispose();
            deposit dp = new deposit(u,p,n);
            }
          else if (e.getSource()==transac){
            frame.dispose();
            accTransac at = new accTransac(u,p,n,m);
            }
          else if (e.getSource()==logout){
            frame.dispose();
            new LogIn();
            }
          else if (e.getSource()==balance){
            frame.dispose();
            new tracking(u,p,n,m);
            }
          else if (e.getSource()==transfer){
            frame.dispose();
            new transfer(u,p,n,m);
            }
    }
}
