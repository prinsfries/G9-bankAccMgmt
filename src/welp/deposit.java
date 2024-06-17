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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class deposit extends JFrame implements ActionListener{

    private JButton rj = new JButton("Transfer Money");
    private JButton ko = new JButton("Next");
    private JButton jk1 = new JButton("Cancel");
    private JButton t2 = new JButton("Exit");
 
    deposit(){
        ImageIcon iconic = new ImageIcon("capture.png");
        JOptionPane.showMessageDialog(null, "Welcome to the Deposit System!", "WELCOME GREETING!",JOptionPane.INFORMATION_MESSAGE,iconic);
         
        JPanel jn = new JPanel();
         jn.setLayout(new GridLayout(5,2,50,20));
         jn.setBounds(70,150,700,300);
        
         JLabel sg = new JLabel("BANK DEPOSIT SYSTEM");
         sg.setBounds(200,5,350,150);
         sg.setForeground(Color.BLACK);
         sg.setFont(new Font("Georgia",Font.BOLD,25));
         
         JLabel nj = new JLabel("Account Number: ");
         nj.setForeground(Color.BLACK);
         nj.setFont(new Font("Arial Black",Font.BOLD,15));
          
         JTextField nj1 = new JTextField();
         JButton shot = new JButton("Search");
        
         JLabel jh = new JLabel("Account Name: ");
         jh.setForeground(Color.BLACK);
         jh.setFont(new Font("Arial Black",Font.BOLD,15));
         
         JTextField jh1 = new JTextField();
         JButton mang = new JButton("Enter");
         
         
         JLabel jm = new JLabel("Credit Balance: ");
         jm.setPreferredSize(new Dimension (100,50));
         jm.setForeground(Color.black);
         jm.setFont(new Font("Arial Black",Font.BOLD,15));  
         JTextField jm1= new JTextField();
         
         JLabel th = new JLabel("             Show       ");
         th.setForeground(Color.BLACK);
         th.setFont(new Font("Arial Black",Font.BOLD,15));
         
         JLabel jk = new JLabel("Deposit Amount");
         jk.setForeground(Color.BLACK);
         jk.setFont(new Font("Arial Black",Font.BOLD,15));
         JTextField yg5 = new JTextField();
         JButton jh5 = new JButton("Deposit");
     
         JLabel chim = new JLabel("Deposit Date:");
         chim.setForeground(Color.BLACK);
         chim.setFont(new Font("Arial Black",Font.BOLD,15));
         JTextField yg6 = new JTextField();
         JButton jh6 = new JButton("Enter");
         
         
         jk1.setBounds(50, 500, 150, 40);
         jk1.addActionListener(this);
        
         t2.setBounds(340,500,160,40);
         t2.addActionListener(this);
         
         rj.setBounds(600,15,150,28);
         rj.addActionListener(this);
         
         ko.setBounds(580,500,170,40);
         ko.addActionListener(this);
        
        setTitle("BANK MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(840,650);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        
        add(jn);
        jn.add(nj);
        jn.add(nj1);
        jn.add(shot);
        jn.add(jh);
        jn.add(jh1);
        jn.add(mang);
        
        jn.add(jm);
        jn.add(jm1);
        jn.add(th);
        
        jn.add(jk);
        jn.add(yg5);
        jn.add(jh5);
        
        jn.add(chim);
        jn.add(yg6);
        jn.add(jh6);
        
        add(jk1);
        add(t2);
        add(rj);
        add(ko);
        add(sg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    dispose();
    if(e.getSource() == rj){
        Transfer nana = new Transfer();
       nana.setVisible(true);
    }   
    else if (e.getSource() == ko){
        Next ne = new Next();
        ne.setVisible(true);
    }
    else if (e.getSource() == jk1){
    
       System.out.println("Cancel The Process");
    }
    else if (e.getSource() == t2){
      Exit lala = new Exit();
      lala.setVisible(true);
    }
    
   }
}
