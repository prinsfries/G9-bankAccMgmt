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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class deposit extends JFrame implements ActionListener{
       
    private JButton rj = new JButton("Deposit Money"); //(Submit Botton)
    private JButton jk1 = new JButton("Cancel"); //(Back Botton)
    private JFrame frame; 
    private JLabel dateTimeLabel; //setdate&time
    private JTextField nj1; //get function 
    private JTextField jh1; //jtextfield
    private JTextField yg5; //jtextfield
    
    Frame(){
       Lov();
    }
    
        private void lov() {   //JFrame elements responsible for displaying the User Interface
      
       JOptionPane.showMessageDialog(null, "Welcome to the Deposit System!", "WELCOME GREETING!",JOptionPane.INFORMATION_MESSAGE);
        //welcome message
        
       JPanel jn = new JPanel();       //main panel
       jn.setLayout(new GridLayout(3,2,50,20));
       jn.setBounds(60,120,600,150);
    
        JLabel sg = new JLabel("BANK DEPOSIT SYSTEM");  //titlepage
        sg.setBounds(200,5,350,150);
        sg.setForeground(Color.BLACK);
        sg.setFont(new Font("Georgia",Font.BOLD,25));
         
        JLabel nj = new JLabel("Account Pin: ");     //information
        nj.setForeground(Color.BLACK);
        nj.setFont(new Font("Arial Black",Font.BOLD,15));
          
        nj1 = new JTextField();

        JLabel jh = new JLabel("Account Name: ");    //information
        jh.setForeground(Color.BLACK);
        jh.setFont(new Font("Arial Black",Font.BOLD,15));
         
        jh1 = new JTextField(); 
         
        JLabel jk = new JLabel("Deposit Amount:");    //information
        jk.setForeground(Color.BLACK);
        jk.setFont(new Font("Arial Black",Font.BOLD,15));
         
        yg5 = new JTextField();
          
       JLabel t = new JLabel("Date:");                    //dateinfo
       t.setForeground(Color.BLACK);
       t.setFont(new Font("Arial Black",Font.BOLD,15));
       t.setBounds(60,230,500,150);
  
       dateTimeLabel = new JLabel("Date & Time");
       dateTimeLabel.setFont(new Font("New Times Roman", Font.BOLD, 15));
       dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
       dateTimeLabel.setBounds(260,230,500,150);
          
       updateDateTime();  //updatetime during run
        
       jk1.setBounds(50, 340, 150, 30);  //botton cancel
       jk1.addActionListener(this);  
              
       rj.setBounds(550,15,150,28);  ////botton submit
       rj.addActionListener(this);

       setTitle("BANK MANAGEMENT SYSTEM");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(false);
       setSize(740,440);
       // setSize(740, 700);
       setLocationRelativeTo(null);
       setLayout(null);
       setVisible(true);
           
       add(jn);
       jn.add(nj);
       jn.add(nj1);
 
       jn.add(jh);
       jn.add(jh1);
      
       jn.add(jk);
       jn.add(yg5);

       add(jk1);
       add(rj);
       add(sg);
       add(t);
       add(dateTimeLabel);
    
   }        
      private void updateDateTime() {    //to set date&time
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String currentTime = sdf.format(new Date());
      dateTimeLabel.setText(currentTime);
    }

      public static void main(String[] args) {
      SwingUtilities.invokeLater(Frame::new);
    }    
    
    @Override
      public void actionPerformed(ActionEvent e) {
      if (e.getSource() == jk1) {   //cancel botton
         dispose(); 
     } else if (e.getSource() == rj) {   //submit botton
            
            //Retrieve data from text fields    
       String accountPin = nj1.getText();
       String accountName = jh1.getText();
       String depositAmount = yg5.getText();
        
        //JDBC connection to Database
       String dbURL = "jdbc:mysql://localhost:3306/test";
       String username = "root";
       String password = "";
       Connection c = null;
       
         
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");  
          c=DriverManager.getConnection(dbURL, username, password);
            if (c != null) {
            System.out.println("Connected");
             }
            System.out.print(c);
         
           String sql = "INSERT INTO deposit (Account_pin, Account_name, Deposit_amount) VALUES (?, ?, ?)";
                   PreparedStatement now = c.prepareStatement(sql);  //prepared statement
                   now.setString(1, accountName);
                   now.setString(2, accountPin);
                   now.setString(3, depositAmount);
                   now.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Sucessful Inserted The Data!");
  
           dispose();   
      
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(JavaMySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Connection Error!");
        } catch (SQLException ex) {
          //  Logger.getLogger(JavaMySQLConnect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Unsuccessful Inserting Data!");
        }  finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException ex) {
                       // Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
