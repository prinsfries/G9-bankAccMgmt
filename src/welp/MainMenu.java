package welp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu implements ActionListener{
    private static JFrame frame;    
    private static JLabel mainMenu;
    private static JButton withdraw, deposit, transac, pay, balance, transfer;
    private static JPanel panel, title;
    private static String u, p;
    private static int m;
    
    MainMenu(String un, String pin, int money){
        u = un; //Setting Parameters
        p = pin;
        m = money;

        //S.out logs for debug
        System.out.println("main menu");
        System.out.println(un);
        System.out.println(pin);
        System.out.println(money);
        
        
        panel = new JPanel();
        //JFrame
        frame = new JFrame("BANK ACCOUNT MANAGEMENT");
        frame.setSize(620,420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Panel elements
        panel.setLayout(new GridLayout(5,1));
        panel.setPreferredSize(new Dimension(250,200));

        //title
        title = new JPanel(new BorderLayout());

        //main menu
        mainMenu = new JLabel("MAIN MENU", SwingConstants.CENTER);
        mainMenu.setFont(new Font("Arial", Font.BOLD, 48));
        mainMenu.setBounds(10, 20, 250, 25);
        title.add(mainMenu);
        
        
        //withdraw button
        withdraw = new JButton ("Withdraw");
        withdraw.setFont(new Font("Arial", Font.BOLD, 24));
        withdraw.setBounds(10, 150, 150, 25);
        withdraw.addActionListener(this);
        panel.add(withdraw);

        //deposit button
        deposit = new JButton ("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 24));
        deposit.setBounds(10, 200, 150, 25);
        deposit.addActionListener(this);
        panel.add(deposit);

        //transactions button
        transac = new JButton ("Transactions");
        transac.setFont(new Font("Arial", Font.BOLD, 24));
        transac.setBounds(10, 200, 150, 25);
        transac.addActionListener(this);
        panel.add(transac);

        //Auto Payments button
        pay = new JButton ("Auto Payments");
        pay.setFont(new Font("Arial", Font.BOLD, 24));
        pay.setBounds(10, 200, 150, 25);
        pay.addActionListener(this);
        panel.add(pay);

        //Balance tracking button
        balance = new JButton ("Balances");
        balance.setFont(new Font("Arial", Font.BOLD, 24));
        balance.setBounds(10, 200, 150, 25);
        balance.addActionListener(this);
        panel.add(balance);

        //Transfer money button
        transfer = new JButton ("Transfer");
        transfer.setFont(new Font("Arial", Font.BOLD, 24));
        transfer.setBounds(10, 200, 150, 25);
        transfer.addActionListener(this);
        panel.add(transfer);

        //add elements to frame
        frame.add(panel);
        frame.add(title,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
//different outcomes of events
          if (e.getSource()==withdraw){
            frame.dispose();
            withdraw wd = new withdraw();
            }
          else if (e.getSource()==deposit){
            frame.dispose();
            deposit dp = new deposit(u,p,m);
            }
          else if (e.getSource()==transac){
            frame.dispose();
            accTransac at = new accTransac(u);
            }
          else if (e.getSource()==pay){
            frame.dispose();
            autoPay ap = new autoPay(u, p);
            }
          else if (e.getSource()==balance){
            frame.dispose();
            tracking t = new tracking();
            }
          else if (e.getSource()==transfer){
            frame.dispose();
            new transfer();
            }
    }
}
