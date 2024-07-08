package welp;

import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class deposit extends JFrame implements ActionListener {

    private JButton rj = new JButton("Deposit Money"); //Submit Button
    private JButton jk1 = new JButton("Cancel"); //Back Button
    private JFrame frame;
    private JLabel dateTimeLabel; //set date&time
    private JTextField nj1; //get function 
    private JTextField jh1; //jtextfield
    private JTextField yg5; //jtextfield
    private int m;
    private String u, p, n;

    deposit(String u, String p, String n) {
        this.u = u;
        this.p = p;
        this.n = n;
        this.m = fetchCurrentBalance(n);//get latest balance from the database
        lov(u, p, n, m);
    }

    private int fetchCurrentBalance(String accountNumber) {
        int balance = 0;
        String dbURL = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "";
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(dbURL, username, password);
            String query = "SELECT bank_Amount FROM bank WHERE user_num=?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getInt("bank_Amount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return balance;
    }

    private void lov(String u, String p, String n, int m) {   //JFrame elements responsible for displaying the User Interface
        System.out.println("Current Balance: " + m);
        JOptionPane.showMessageDialog(null, "Welcome to the Deposit System!", "WELCOME GREETING!", JOptionPane.INFORMATION_MESSAGE);

        JPanel jn = new JPanel();       //main panel
        jn.setLayout(new GridLayout(3, 2, 50, 20));
        jn.setBounds(60, 120, 600, 150);

        JLabel sg = new JLabel("BANK DEPOSIT SYSTEM");  //title page
        sg.setBounds(200, 5, 350, 150);
        sg.setForeground(Color.BLACK);
        sg.setFont(new Font("Georgia", Font.BOLD, 25));

        JLabel nj = new JLabel("Account Name: ");     //Acc Name
        nj.setForeground(Color.BLACK);
        nj.setFont(new Font("Arial Black", Font.BOLD, 15));

        nj1 = new JTextField(u);
        nj1.setEditable(false);

        JLabel jh = new JLabel("Account Number: ");    //Acc Num
        jh.setForeground(Color.BLACK);
        jh.setFont(new Font("Arial Black", Font.BOLD, 15));

        jh1 = new JTextField(n);
        jh1.setEditable(false);

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

        rj.setBounds(550, 15, 150, 28);  //submit button 
        rj.addActionListener(this);
        setTitle("BANK MANAGEMENT SYSTEM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(740, 440);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jk1) {   //cancel button
            dispose();
            new MainMenu(u, p, n, fetchCurrentBalance(n)); // Fetch updated balance
        } else if (e.getSource() == rj) {   //submit button
            //Retrieve data from text fields    
            String depositAmount = yg5.getText();
            int amount = 0;
            try {
                amount = Integer.parseInt(depositAmount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                return;
            }

            String date = dateTimeLabel.getText();
            int currentBalance = fetchCurrentBalance(n);
            int newBalance = currentBalance + amount;

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

                //Deposit bank amount
                String sqlUpdate = "UPDATE bank SET bank_Amount= ? WHERE user_num= ?";
                PreparedStatement nowUpdate = c.prepareStatement(sqlUpdate);
                nowUpdate.setInt(1, newBalance); //Set the new balance
                nowUpdate.setString(2, n); //Set the account num
                nowUpdate.executeUpdate();

                //Insert transaction log
                String sqlInsert = "INSERT INTO transaction_log (user_names, user_Pin, transaction_details, transaction_date) VALUES (?, ?, ?, ?)";
                PreparedStatement nowInsert = c.prepareStatement(sqlInsert);
                nowInsert.setString(1, u);
                nowInsert.setString(2, p); 
                nowInsert.setString(3, "Deposited " + amount);
                nowInsert.setString(4, date);
                nowInsert.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully Deposited!");

                dispose();
                new MainMenu(u, p, n, newBalance); //Pass updated balance to MainMenu

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
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
