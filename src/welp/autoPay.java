package welp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class autoPay extends JFrame {
    public JTextField cardNumber1;
    public JTextField expirationDate2;
    public JTextField postalCode3;
    public JTextField securityCode4;

    autoPay() {
        this.setTitle("Auto Payments");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel bry = new JPanel();
        bry.setLayout(new GridLayout(5, 2));

        JLabel cardNumber = new JLabel("User Name:");
        cardNumber1 = new JTextField();
        JLabel expirationDate = new JLabel("Pin:");
        expirationDate2 = new JTextField();
        JLabel postalCode = new JLabel("Date:");
        postalCode3 = new JTextField("YYYY-MM-DD");
        JLabel securityCode = new JLabel("Transaction Details:");
        securityCode4 = new JTextField("AutoPay");
        securityCode4.setEditable(false);

        JButton process = new JButton("Process Payment");

        bry.add(cardNumber);
        bry.add(cardNumber1);
        bry.add(expirationDate);
        bry.add(expirationDate2);
        bry.add(postalCode);
        bry.add(postalCode3);
        bry.add(securityCode);
        bry.add(securityCode4);
        bry.add(process);
        process.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumber1.getText();
                String expirationDate = expirationDate2.getText();
                String postalCode = postalCode3.getText();
                String securityCode = securityCode4.getText();

                // Database connection variables
                String url = "jdbc:mysql://localhost:3306/bank"; // Update with  database URL
                String user = "root"; // Update with the database username
                String password = ""; // Update with the database password

                // Insert data into the database
                String query = "INSERT INTO bank (user_names, user_Pin, transaction_date, transaction_details) VALUES (?, ?, ?, ?)";

                try (Connection conn = DriverManager.getConnection(url, user, password);
                     PreparedStatement ps = conn.prepareStatement(query)) {

                    ps.setString(1, cardNumber);
                    ps.setString(2, expirationDate);
                    ps.setString(3, postalCode);
                    ps.setString(4, securityCode);

                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Payment processed successfully!");
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        add(bry);
        setVisible(true);
    }

}
