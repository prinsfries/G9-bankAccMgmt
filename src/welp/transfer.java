package welp;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class transfer implements ActionListener {
    private static JFrame frame;
    private static JLabel title, name1, name2, pin1, pin2, amount;
    private static JTextField one, two, pinField1, pinField2, amountf;
    private static JButton transfer;
    
    transfer() {
        init();
    }
    
    void init() {
        // frame
        frame = new JFrame("BANK ACCOUNT MANAGEMENT");
        frame.setSize(420, 420);
        frame.setLayout(null);
        
        title = new JLabel("Transfer");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.black);
        title.setBounds(140, -180, 420, 420);
        frame.add(title);
        
        name1 = new JLabel("User 1");
        name1.setFont(new Font("Arial", Font.BOLD, 24));
        name1.setForeground(Color.black);
        name1.setBounds(20, -120, 420, 420);
        frame.add(name1);
        
        one = new JTextField();
        one.setFont(new Font("Arial", Font.PLAIN, 16));
        one.setBounds(20, 120, 125, 30);
        frame.add(one);
        
        pin1 = new JLabel("Pin:");
        pin1.setFont(new Font("Arial", Font.BOLD, 24));
        pin1.setForeground(Color.black);
        pin1.setBounds(20, -30, 420, 420);
        frame.add(pin1);
        
        pinField1 = new JTextField();
        pinField1.setFont(new Font("Arial", Font.PLAIN, 16));
        pinField1.setBounds(20, 200, 125, 30);
        frame.add(pinField1);
        
        name2 = new JLabel("User 2");
        name2.setFont(new Font("Arial", Font.BOLD, 24));
        name2.setForeground(Color.black);
        name2.setBounds(260, -120, 420, 420);
        frame.add(name2);
        
        two = new JTextField();
        two.setFont(new Font("Arial", Font.PLAIN, 16));
        two.setBounds(260, 120, 125, 30);
        frame.add(two);
        
        pin2 = new JLabel("Pin:");
        pin2.setFont(new Font("Arial", Font.BOLD, 24));
        pin2.setForeground(Color.black);
        pin2.setBounds(260, -30, 420, 420);
        frame.add(pin2);
        
        pinField2 = new JTextField();
        pinField2.setFont(new Font("Arial", Font.PLAIN, 16));
        pinField2.setBounds(260, 200, 125, 30);
        frame.add(pinField2);
        
        //middle = transaction
        //amount
        amount = new JLabel("Amount:");
        amount.setFont(new Font("Arial", Font.BOLD, 24));
        amount.setBounds(150, 250, 125, 30);
        frame.add(amount);
        
        amountf = new JTextField();
        amountf.setFont(new Font("Arial", Font.PLAIN, 16));
        amountf.setBounds(140, 290, 125, 30);
        frame.add(amountf);
        
        //transfer button
        transfer = new JButton("Transfer");
        transfer.setBounds(140, 340, 125, 30);
        transfer.addActionListener(this);
        frame.add(transfer);
        
        //frame 
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String u1 = one.getText();
        String u2 = two.getText();
        String p1 = pinField1.getText();
        String p2 = pinField2.getText();
        String monkey = amountf.getText();
        int money = Integer.parseInt(monkey);
        
        if (e.getSource() == transfer) {
            Connection c = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            try {
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
                c.setAutoCommit(false); // Disable auto-commit for transaction
                
                //verify user 1
                String validateUser1 = "SELECT * FROM bank WHERE user_names=? AND user_Pin=?";
                pstmt = c.prepareStatement(validateUser1);
                pstmt.setString(1, u1);
                pstmt.setString(2, p1);
                rs = pstmt.executeQuery();
                
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials for User 1");
                    return;
                }
                
                int balance1 = rs.getInt("bank_Amount");
                
                //verify user 2
                String validateUser2 = "SELECT * FROM bank WHERE user_names=? AND user_Pin=?";
                pstmt = c.prepareStatement(validateUser2);
                pstmt.setString(1, u2);
                pstmt.setString(2, p2);
                rs = pstmt.executeQuery();
                
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials for User 2");
                    return;
                }
                
                int balance2 = rs.getInt("bank_Amount");
                
                //check if afford ba ni user 1
                if (balance1 < money) {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance for User 1");
                    return;
                }
                
                //user 1 bawas
                String updateUser1 = "UPDATE bank SET bank_Amount=? WHERE user_names=? AND user_Pin=?";
                pstmt = c.prepareStatement(updateUser1);
                pstmt.setInt(1, balance1 - money);
                pstmt.setString(2, u1);
                pstmt.setString(3, p1);
                pstmt.executeUpdate();
                
                //user 2 receive
                String updateUser2 = "UPDATE bank SET bank_Amount=? WHERE user_names=? AND user_Pin=?";
                pstmt = c.prepareStatement(updateUser2);
                pstmt.setInt(1, balance2 + money);
                pstmt.setString(2, u2);
                pstmt.setString(3, p2);
                pstmt.executeUpdate();
                
                //log the transaction
                String sqlInsert = "INSERT INTO transaction_log (user_names, user_Pin, transaction_details, transaction_date) VALUES (?, ?, ?, ?)";
                PreparedStatement nowInsert = c.prepareStatement(sqlInsert);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(new Date());
                
                //transaction log of user 1
                nowInsert.setString(1, u1);
                nowInsert.setString(2, p1);
                nowInsert.setString(3, "Transferred " + money + " to " + u2);
                nowInsert.setString(4, date);
                nowInsert.executeUpdate();
                
                //transaction log of user 2
                nowInsert.setString(1, u2);
                nowInsert.setString(2, p2);
                nowInsert.setString(3, "Received " + money + " from " + u1);
                nowInsert.setString(4, date);
                nowInsert.executeUpdate();
                
                //Commit 
                c.commit();
                JOptionPane.showMessageDialog(frame, "Transfer successful");
                
            } catch (SQLException ex) {
                if (c != null) {
                    try {
                        c.rollback(); // Rollback transaction on error
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Transfer failed");
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if (pstmt != null) {
                    try {
                        pstmt.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
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
