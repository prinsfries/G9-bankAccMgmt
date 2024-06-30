package welp;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

//Setting parameters
public class LogIn implements ActionListener{
    private static JPanel title, center;
    private static JFrame frame;
    private static JLabel bam, pinLabel, word;
    private static JPasswordField pinField;
    private static JButton login, create;
   
    
    LogIn(){
        init();
    }
    
    //JFrame elements responsible for displaying the User Interface
    private void init(){
        
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

        title = new JPanel(new BorderLayout());
        
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
    
    //ActionEvent follows what course of action to do based on what the user has clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass = pinField.getText();
            //if user has clicked Login
            if (e.getSource()==login){
                //JDBC connection to Database
                Connection c;
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
                    System.out.print("Connected: "); //System out for logs to see everytime it accesses the database
                    Statement stmt = c.createStatement();
                    
                    //SQL Query that verifies the input from the pinField,
                    String query = "SELECT * FROM bank WHERE user_Pin='"+pass+"'";
                    ResultSet rs =stmt.executeQuery(query); 
                    
                    //if the input has been found in the database, it proceeds to the Main Menu
                    if(rs.next()){
                        System.out.println("Login Success");//System out for logs to see login success
                        frame.dispose();
                        new MainMenu();
                    }
                    //else if the inputted was not found, the system closes
                    else{
                        System.out.println("Login Error");//System out for logs to see login error
                        word.setText("Error");
                    }
                } catch (Exception a) {
                    System.out.println("Error");
                }
        }
            
            //else if the user has clicked Create
            else if (e.getSource()==create){
            frame.dispose();
            createAcc ca = new createAcc();
        }
            
            else{
            word.setText("Error");
        }    
    }
}
