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
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "";
    private String u;

    public accTransac(String u) {
        this.u=u;
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
             ResultSet rs = stmt.executeQuery("SELECT * FROM transaction_log WHERE user_names='"+u+"'")) {
            while (rs.next()) {
                String date = rs.getString("transaction_date");
                String details = rs.getString("transaction_details");
                transactions.add(new Transaction(date, details));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void showTransactions() {      // display the transactions in the text area
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : transactions) {
            sb.append("Date: ").append(transaction.getDate()).append("\tDetails: ").append(transaction.getDetails()).append("\n");
        }
        textArea.setText(sb.toString());
    }
    }
    class Transaction {
    private String date;
    private String details;
    public Transaction(String date, String details) {
        this.date = date;
        this.details = details;
    }
    public String getDate() {
        return date;
    }
    public String getDetails() {
        return details;
    }
}
