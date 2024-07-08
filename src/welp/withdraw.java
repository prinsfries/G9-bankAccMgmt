package welp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate; 
import java.time.LocalDateTime;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class withdraw extends JFrame implements ActionListener {

    private JButton onek, fivek, tenk, fiftink, withdrawbutton, backbutton;
    private JTextField textfield2;
    private JPanel rightpanel;
    private JLabel label1, label2, dateLabel; 
    private int balance, m; 
    private String u, p, n;
    private Connection c;

    withdraw(String un, String pin, String an, int money) {
        this.u = un; 
        this.p = pin;
        this.m = money; 
        this.n = an; 
        
        //jframe
        setTitle("IT Bank");
        setSize(700, 640);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        onek = new JButton("1000");
        onek.setBounds(50, 100, 190, 50);
        onek.setBackground(Color.LIGHT_GRAY);
        onek.setFont(new Font("Georgia", Font.PLAIN, 30));
        onek.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        onek.addActionListener(this);
        add(onek);

        fivek = new JButton("5000");
        fivek.setBounds(50, 200, 190, 50);
        fivek.setBackground(Color.LIGHT_GRAY);
        fivek.setFont(new Font("Georgia", Font.PLAIN, 30));
        fivek.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        fivek.addActionListener(this);
        add(fivek);

        tenk = new JButton("10,000");
        tenk.setBounds(50, 300, 190, 50);
        tenk.setBackground(Color.LIGHT_GRAY);
        tenk.setFont(new Font("Georgia", Font.PLAIN, 30));
        tenk.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        tenk.addActionListener(this);
        add(tenk);

        fiftink = new JButton("20,000");
        fiftink.setBounds(50, 400, 190, 50);
        fiftink.setBackground(Color.LIGHT_GRAY);
        fiftink.setFont(new Font("Georgia", Font.PLAIN, 30));
        fiftink.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        fiftink.addActionListener(this);
        add(fiftink);

        backbutton = new JButton("BACK");
        backbutton.setBounds(50, 500, 100, 50);
        backbutton.setBackground(Color.LIGHT_GRAY);
        backbutton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backbutton.addActionListener(this);
        add(backbutton);

        textfield2 = new JTextField();
        textfield2.setBounds(380, 200, 230, 50);
        textfield2.setBackground(Color.LIGHT_GRAY);
        textfield2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        textfield2.setFont(new Font(textfield2.getFont().getName(), Font.PLAIN, 25));
        add(textfield2);

        withdrawbutton = new JButton("WITHDRAW");
        withdrawbutton.setBounds(480, 500, 130, 50);
        withdrawbutton.setBackground(Color.GREEN);
        withdrawbutton.setFont(new Font("Georgia", Font.PLAIN, 15));
        withdrawbutton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        withdrawbutton.addActionListener(this);
        add(withdrawbutton);

        label1 = new JLabel("SELECT AMOUNT");
        label1.setBounds(60, 30, 200, 30);
        label1.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 20));
        label1.setForeground(Color.WHITE);
        add(label1);

        label2 = new JLabel("OTHER AMOUNT");
        label2.setBounds(420, 150, 200, 30);
        label2.setFont(new Font(label1.getFont().getName(), Font.PLAIN, 20));
        label2.setForeground(Color.BLACK);
        add(label2);

        dateLabel = new JLabel();
        dateLabel.setBounds(500, 30, 200, 30);
        dateLabel.setFont(new Font(dateLabel.getFont().getName(), Font.PLAIN, 18));
        dateLabel.setForeground(Color.BLACK);
        add(dateLabel);

        rightpanel = new JPanel();
        rightpanel.setBounds(0, 0, 300, 640);
        rightpanel.setBackground(Color.GRAY);
        rightpanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        add(rightpanel);
        
        setVisible(true);

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
            System.out.println("Successfully connected to database");
            throwbalance();
            Date();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == onek) {
            withdrawsystem(1000);
        } else if (source == fivek) {
            withdrawsystem(5000);
        } else if (source == tenk) {
            withdrawsystem(10000);
        } else if (source == fiftink) {
            withdrawsystem(20000);
        } else if (source == withdrawbutton) {
            String amountText = textfield2.getText();
            try {
                int amount = Integer.parseInt(amountText);
                withdrawsystem(amount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
        } else if (source == backbutton) {
            this.dispose();
            new MainMenu(u, p, n, balance);
        }
    }

    private void withdrawsystem(int amount) {
        try {
            if (amount <= balance) {
                balance -= amount;
                updatebalance(balance);
                logTransaction(amount);
                JOptionPane.showMessageDialog(null, "Withdrawal successful. \nNew Balance: " + balance);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient funds.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Unable to perform transaction.");
            e.printStackTrace();
        }
    }

    private void throwbalance() {//kuha balance
        String query = "SELECT bank_Amount FROM bank WHERE user_Pin = ?";
        try {
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1, p);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getInt("bank_Amount");
                System.out.println("Current Balance: " + balance);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }

    private void updatebalance(int newBalance) throws SQLException {// nagaupdte ng balance sa database
        String updateQuery = "UPDATE bank SET bank_Amount=? WHERE user_num = ?";
        PreparedStatement preparedStatement = c.prepareStatement(updateQuery);
        preparedStatement.setInt(1, newBalance);
        preparedStatement.setString(2, n);
        preparedStatement.executeUpdate();
    }

    private void logTransaction(int amount) throws SQLException {
        String logQuery = "INSERT INTO transaction_log (user_names, user_Pin, transaction_details, transaction_date) VALUES (?, ?, ?, ?)";
        PreparedStatement logStatement = c.prepareStatement(logQuery);
        LocalDateTime currentDate = LocalDateTime.now();
        String transactionDate = currentDate.toString();

        String userNameQuery = "SELECT user_names FROM bank WHERE user_Pin = ?";
        PreparedStatement userNameStatement = c.prepareStatement(userNameQuery);
        userNameStatement.setString(1, p);
        ResultSet userNameResult = userNameStatement.executeQuery();
        String userName = "";
        if (userNameResult.next()) {
            userName = userNameResult.getString("user_names");
        }

        logStatement.setString(1, userName);
        logStatement.setString(2, p);
        logStatement.setString(3, "Withdrawn " + amount);
        logStatement.setString(4, transactionDate);
        logStatement.executeUpdate();
    }

    private void Date() {
        LocalDate currentDate = LocalDate.now();
        dateLabel.setText("Date: " + currentDate.toString());
    }
}
