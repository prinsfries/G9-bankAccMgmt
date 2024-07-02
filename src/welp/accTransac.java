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

    // database connection details
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

        // Text area for displaying transactions
        textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Button to view transactions
        JButton viewButton = new JButton("View Transactions");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTransactions();
            }
        });
        add(viewButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

  
    private void fetchTransactionsFromDatabase() {     // catch transactions from the database 
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

    
    private void showTransactions() {      // display the transactions in the text area
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
