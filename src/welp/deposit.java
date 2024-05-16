/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;

/**
 *
 * @author Admin
 */
import java.awt.*;
import javax.swing.*;

public class deposit extends JFrame{
 
    deposit(){
        JOptionPane.showMessageDialog(null, "Welcom to the Deposit System!", "WELCOME GREETING!",JOptionPane.INFORMATION_MESSAGE);
        JPanel jm = new JPanel();

        jm.setBackground(new Color(0x123456));
        jm.setLayout(new GridLayout(7,1,50,20));
        jm.setBounds(70,150,600,400);

        JLabel jk = new JLabel("DEPOSIT");
        jk.setBounds(100,10,200,150);
        jk.setForeground(Color.white);
        jk.setFont(new Font("Georgia",Font.BOLD,25));

        JLabel jn1 = new JLabel("UserID: ");
        jn1.setForeground(Color.white);
        jn1.setFont(new Font("Arial Black",Font.BOLD,15));

        JTextField yg1 = new JTextField();
        JButton jh1 = new JButton("Search");

        JLabel jn2 = new JLabel("Name: ");
        jn2.setForeground(Color.white);
        jn2.setFont(new Font("Arial Black",Font.BOLD,15));
        JTextField yg2 = new JTextField();
        JButton jh2 = new JButton("Enter");

        JLabel jn3 = new JLabel("Debit Account: ");
        jn3.setPreferredSize(new Dimension (100,50));
        jn3.setForeground(Color.white);
        jn3.setFont(new Font("Arial Black",Font.BOLD,15));  
        JTextField yg3 = new JTextField();

        JLabel nj3 = new JLabel("             Show       ");
        nj3.setForeground(Color.white);
        nj3.setFont(new Font("Arial Black",Font.BOLD,15));

        JLabel jn4 = new JLabel("Available Balance:");
        jn4.setForeground(Color.white);
        jn4.setFont(new Font("Arial Black",Font.BOLD,15));
        JTextField yg4 = new JTextField();
        JButton jh4 = new JButton("OK");

        JLabel jn5 = new JLabel("Amount");
        jn5.setForeground(Color.white);
        jn5.setFont(new Font("Arial Black",Font.BOLD,15));
        JTextField yg5 = new JTextField();
        JButton jh5 = new JButton("Enter");

        JLabel jn6 = new JLabel("Acredit Account:");
        jn6.setForeground(Color.white);
        jn6.setFont(new Font("Arial Black",Font.BOLD,15));
        JTextField yg6 = new JTextField();
        JButton jh6 = new JButton("Enter");

        JButton sty = new JButton("Exit");
        sty.setBounds(100,510,100,20);

        JButton ytc = new JButton("Next");
        ytc.setBounds(100,540,100,20);

        JFrame moon = new JFrame();
        moon.setTitle("BANK ACCOUNT MANAGEMENT SYSTEM"); // title of frame
        moon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        moon.setResizable(false);
        moon.setSize(750,650);
        moon.setLocationRelativeTo(null);
        moon.getContentPane().setBackground(new Color(0x123456));   
        moon.setLayout(null);  
        moon.setVisible(true);

        jm.add(jn1);
        jm.add(yg1);
        jm.add(jh1);

        jm.add(jn2);
        jm.add(yg2);
        jm.add(jh2);

        jm.add(jn3);
        jm.add(yg3);
        jm.add(nj3);

        jm.add(jn4);
        jm.add(yg4);
        jm.add(jh4);

        jm.add(jn5);
        jm.add(yg5);
        jm.add(jh5);

        jm.add(jn6);
        jm.add(yg6);
        jm.add(jh6); 
        moon.add(jm);
        moon.add(jk);
        moon.add(sty);
        moon.add(ytc);
    }
}
