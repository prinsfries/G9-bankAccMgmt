package welp;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

//Setting parameters
public class createAcc implements ActionListener{
    private static JLabel userLabel, pinLabel, success, reg;
    private static JTextField userField;
    private static JPasswordField pinField;
    private static JButton create, cancel;
    private static JPanel center, title;
    private static JFrame frame;
    
    createAcc(){
        init();
    }
    
    //JFrame elements responsible for displaying the User Interface
    private void init(){
        
        //frame
        frame = new JFrame("REGISTER BANK ACCOUNT");
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        title = new JPanel(new BorderLayout());
        
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
        
        cancel = new JButton ("Cancel");
        cancel.setBounds(113, 100, 125, 25);
        cancel.addActionListener(this);
        center.add(cancel);
        
        //indicator
        success = new JLabel("");
        success.setBounds(10, 150, 300, 25);
        
        //frame.add
        frame.add(title, BorderLayout.NORTH);
        frame.add(center);
        frame.add(success);
        frame.setVisible(true);
        }

    //ActionEvent follows what course of action to do based on what the user has clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //getting and setting input fields
        String name = userField.getText();
        String pass = pinField.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyHHmmss");
        String currentTime = sdf.format(new java.util.Date());
        String date = currentTime;
        
        if(e.getSource()==create){
        //if input fields are not empty
        if(!name.isEmpty() && !pass.isEmpty()){
            Connection c;
                try 
                {
                    //JDBC connection to Database
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
                    System.out.print("Connected: "); //System out for logs to see everytime it accesses the database
                    Statement stmt = c.createStatement();
                    //query for insertion of new user
                    String query = "INSERT INTO bank (user_names, user_Pin, user_num, bank_Amount) VALUES ('"+name+"','"+pass+"','"+date+"',0)";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Successfully Created!\nYour account number: "+date);
                    System.out.println("Acc Num: "+date);//debug purposes
                    frame.dispose();
                    new LogIn();
                } 
                catch (Exception a) 
                {
                    //System out for logs, jdbc error
                    System.out.println("Error");
                }
        }
            //if input fields are empty
            else{
                JOptionPane.showMessageDialog(null, "Unsuccessful!\nFill in all the text fields!");
            }
        }
        else if (e.getSource()==cancel){
            frame.dispose();
            new LogIn();
        }
    }
}
