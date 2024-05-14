/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package welp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class accTransac extends JFrame {
    private List<Transaction> transactions;

    private JTextArea textArea;
    private JButton viewButton;
    private JTextField dateField;
    private JTextField amountField;
    private JButton addButton;

    public accTransac(List<Transaction> transactions) {
        this.transactions = transactions;

        setTitle("Account Transaction Viewer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponents();

        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    private void initComponents() {
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        viewButton = new JButton("View Transactions");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTransactions();
            }
        });

        dateField = new JTextField(10);
        amountField = new JTextField(10);

        addButton = new JButton("Add Transaction");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
    }

    private void addComponents() {
        JPanel panel = new JPanel();
        panel.add(textArea);

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Date:"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void showTransactions() {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : transactions) {
            sb.append("Date: ").append(transaction.getDate()).append("\tAmount: ").append(transaction.getAmount()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    private void addTransaction() {
        String date = dateField.getText();
        double amount = Double.parseDouble(amountField.getText());
        Transaction newTransaction = new Transaction(date, amount);
        transactions.add(newTransaction);
        showTransactions(); 
        dateField.setText("");
        amountField.setText("");
    }

    accTransac() {
        // Example transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("2024-05-10", 100.0));
        transactions.add(new Transaction("2024-05-09", -50.0));
        transactions.add(new Transaction("2024-05-08", 200.0));
        transactions.add(new Transaction("2024-05-07", -75.0));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new accTransac(transactions);
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
}import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class accTransac extends JFrame {
    private List<Transaction> transactions;

    private JTextArea textArea;
    private JButton viewButton;
    private JTextField dateField;
    private JTextField amountField;
    private JButton addButton;

    public accTransac(List<Transaction> transactions) {
        this.transactions = transactions;

        setTitle("Account Transaction Viewer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponents();

        setLocationRelativeTo(null); // Center the frame on screen
        setVisible(true);
    }

    private void initComponents() {
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        viewButton = new JButton("View Transactions");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTransactions();
            }
        });

        dateField = new JTextField(10);
        amountField = new JTextField(10);

        addButton = new JButton("Add Transaction");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransaction();
            }
        });
    }

    private void addComponents() {
        JPanel panel = new JPanel();
        panel.add(textArea);

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(viewButton);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Date:"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void showTransactions() {
        StringBuilder sb = new StringBuilder();
        for (Transaction transaction : transactions) {
            sb.append("Date: ").append(transaction.getDate()).append("\tAmount: ").append(transaction.getAmount()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    private void addTransaction() {
        String date = dateField.getText();
        double amount = Double.parseDouble(amountField.getText());
        Transaction newTransaction = new Transaction(date, amount);
        transactions.add(newTransaction);
        showTransactions(); 
        dateField.setText("");
        amountField.setText("");
    }

    public static void main(String[] args) {
        // Example transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("2024-05-10", 100.0));
        transactions.add(new Transaction("2024-05-09", -50.0));
        transactions.add(new Transaction("2024-05-08", 200.0));
        transactions.add(new Transaction("2024-05-07", -75.0));

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new accTransac(transactions);
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
