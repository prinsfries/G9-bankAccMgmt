package welp;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class deposit extends JFrame implements ActionListener {

    private JButton rj = new JButton("Deposit Money"); //(Submit Button)
    private JButton jk1 = new JButton("Cancel"); //(Back Button)
    private JFrame frame;
    private JLabel dateTimeLabel; //set date&time
    private JTextField nj1; //get function 
    private JTextField jh1; //jtextfield
    private JTextField yg5; //jtextfield
    private int m;

    deposit(String u, String p, int m) {
        this.m = m;
        lov(u, p, m);
    }

    private void lov(String u, String p, int m) {   //JFrame elements responsible for displaying the User Interface
        System.out.println("deposit");
        System.out.println(u);
        System.out.println(p);
        System.out.println(m);
        JOptionPane.showMessageDialog(null, "Welcome to the Deposit System!", "WELCOME GREETING!", JOptionPane.INFORMATION_MESSAGE);
        //welcome message

        JPanel jn = new JPanel();       //main panel
        jn.setLayout(new GridLayout(3, 2, 50, 20));
        jn.setBounds(60, 120, 600, 150);

        JLabel sg = new JLabel("BANK DEPOSIT SYSTEM");  //title page
        sg.setBounds(200, 5, 350, 150);
        sg.setForeground(Color.BLACK);
        sg.setFont(new Font("Georgia", Font.BOLD, 25));

        JLabel nj = new JLabel("Account Pin: ");     //information
        nj.setForeground(Color.BLACK);
        nj.setFont(new Font("Arial Black", Font.BOLD, 15));

        nj1 = new JTextField(p);
        JLabel jh = new JLabel("Account Name: ");    //Name
        jh.setForeground(Color.BLACK);
        jh.setFont(new Font("Arial Black", Font.BOLD, 15));

        jh1 = new JTextField(u);

        JLabel jk = new JLabel("Deposit Amount:");    //Deposit
        jk.setForeground(Color.BLACK);
        jk.setFont(new Font("Arial Black", Font.BOLD, 15));

        yg5 = new JTextField();

        JLabel t = new JLabel("Date:");                    //Date
        t.setForeground(Color.BLACK);
        t.setFont(new Font("Arial Black", Font.BOLD, 15));
        t.setBounds(60, 230, 500, 150);

        dateTimeLabel = new JLabel("Date & Time");
        dateTimeLabel.setFont(new Font("New Times Roman", Font.BOLD, 15));
        dateTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateTimeLabel.setBounds(260, 230, 500, 150);

        updateDateTime();  //updatetime

        jk1.setBounds(50, 340, 150, 30);  //cancel button 
        jk1.addActionListener(this);

        rj.setBounds(550, 15, 150, 28);  ////submit button 
        rj.addActionListener(this);
        setTitle("BANK MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(740, 440);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jk1) {   //cancel button
            dispose();
        } else if (e.getSource() == rj) {   //submit button

            //Retrieve data from text fields    
            String accountPin = nj1.getText();
            String accountName = jh1.getText();
            String depositAmount = yg5.getText();
            String date = dateTimeLabel.getText();
            int amount = Integer.parseInt(depositAmount);
            int deposit = m + amount;
            String depositS = Integer.toString(deposit);

            //JDBC connection to Database
            String dbURL = "jdbc:mysql://localhost:3306/bank";
            String username = "root";
            String password = "";
            Connection c = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection(dbURL, username, password);
                if (c != null) {
                    System.out.println("Connected");
                }
                System.out.print(c);

                //Deposit bank amount
                String sqlUpdate = "UPDATE bank SET bank_Amount= ? WHERE user_Pin= ?";
                PreparedStatement nowUpdate = c.prepareStatement(sqlUpdate);
                nowUpdate.setString(1, depositS); // Set the deposit amount
                nowUpdate.setString(2, accountPin); // Set the account pin
                nowUpdate.executeUpdate();

                //Insert transaction log
                String sqlInsert = "INSERT INTO transaction_log (user_names, user_Pin, transaction_details, transaction_date) VALUES (?, ?, ?, ?)";
                PreparedStatement nowInsert = c.prepareStatement(sqlInsert);
                nowInsert.setString(1, accountName);
                nowInsert.setString(2, accountPin);
                nowInsert.setString(3, "Deposit");
                nowInsert.setString(4, date);
                nowInsert.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully Deposited!");

                dispose();

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Connection Error!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Unsuccessful Deposit!");
                ex.printStackTrace(); // debug
            } finally {
                if (c != null) {
                    try {
                        c.close();
                    } catch (SQLException ex) {
                    }
                }
            }
        }
    }
}
