package welp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class accTransac extends JFrame implements ActionListener{
    private List<Transaction> transactions;
    private JTextArea textArea;
    private JButton viewButton, back;

    // database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "";
    private int m; 
    private String u, p, n;

    public accTransac(String u, String p, String n, int m) {
        this.m = m;
        this.u = u;
        this.p = p;
        this.n = n;
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
        viewButton = new JButton("View Transactions");
        viewButton.addActionListener(this);
        add(viewButton, BorderLayout.NORTH);
        
        // Button to view go back to mainmenu
        back = new JButton("Back");
        back.addActionListener(this);
        add(back, BorderLayout.SOUTH);

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

    @Override
    public void actionPerformed(ActionEvent e) {// go back
        if(e.getSource()==viewButton){
            showTransactions();
        }
        else if(e.getSource()==back){
            dispose();
            new MainMenu(u,p,n,m);
        }
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
