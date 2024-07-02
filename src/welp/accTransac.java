/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class accTransac extends JFrame {
    private List<Transaction> transactions;
    private JTextArea textArea;
    private JTextField dateField;
    private JTextField amountField;

    // database connection 
    private static final String DB_URL = "jdbc:mysql://localhost:3306/accounttrans";
    private static final String USER = "root";
    private static final String PASS = "";

    public accTransac() {
        transactions = new ArrayList<>();
        fetchTransactionsFromDatabase();

        setTitle("Account Transaction Viewer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        textArea = new JTextArea(10, 40); // displaying transactions
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        
        JPanel inputPanel = new JPanel();// input panel for adding transactions
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

        dateField = new JTextField(10);
        amountField = new JTextField(10);

        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);

        JButton addButton = new JButton("Add Transaction");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
        inputPanel.add(addButton);

        JButton viewButton = new JButton("View Transactions");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTransactions();
            }
        });
        inputPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

   
    private void fetchTransactionsFromDatabase() {   // catch transactions from the database and store them in the local list
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT date, amount FROM transactions")) {
            while (rs.next()) {
                String date = rs.getString("date");
                double amount = rs.getDouble("amount");
                transactions.add(new Transaction(date, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private void addTransaction() {      // Add a transaction to the local list and database
        String date = dateField.getText();
        double amount = Double.parseDouble(amountField.getText());
        Transaction newTransaction = new Transaction(date, amount);
        transactions.add(newTransaction);
        addTransactionToDatabase(newTransaction);
        showTransactions();
        dateField.setText("");
        amountField.setText("");
    }

    
    private void addTransactionToDatabase(Transaction transaction) {             // Insert a new transaction into the database
        String sql = "INSERT INTO transactions (date, amount) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transaction.getDate());
            pstmt.setDouble(2, transaction.getAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // display the transactions
    private void showTransactions() {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : transactions) {
            sb.append("Date: ").append(transaction.getDate()).append("\tAmount: ").append(transaction.getAmount()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountTransactionViewer();
            }
        });
    }
}

class Transaction {
    private String date;
    private double amount;

    public Transaction(String date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
