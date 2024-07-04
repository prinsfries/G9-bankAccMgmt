package tracking;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class tracking {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tracking";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Bank Account Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0xFFFFFF));
        frame.setLayout(null);
                //Labels
        JLabel titleLabel = new JLabel("Bank Account Tracker");
        titleLabel.setBounds(200, 20, 200, 50);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
            //Buttons
        JButton closeButton = new JButton("Close");
        closeButton.setBounds(150, 400, 100, 50);
        closeButton.setFocusable(false);
        closeButton.setFont(new Font("Serif", Font.BOLD, 14));
        closeButton.setBackground(Color.LIGHT_GRAY);
        closeButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
            }
        });
                //Buttons for continue to fetchData
        JButton continueButton = new JButton("Continue");
        continueButton.setBounds(350, 400, 100, 50);
        continueButton.setFocusable(false);
        continueButton.setFont(new Font("Serif", Font.BOLD, 14));
        continueButton.setBackground(Color.LIGHT_GRAY);
        continueButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData();
            }
        });
                //Labels
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(50, 100, 150, 50);
        dateLabel.setFont(new Font("Serif", Font.BOLD, 14));
        dateLabel.setBackground(Color.LIGHT_GRAY);
        dateLabel.setOpaque(true);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JTextField dateTextField = new JTextField();
        dateTextField.setBounds(250, 100, 300, 50);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 200, 150, 50);
        amountLabel.setFont(new Font("Serif", Font.BOLD, 14));
        amountLabel.setBackground(Color.LIGHT_GRAY);
        amountLabel.setOpaque(true);
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        amountLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JTextField amountTextField = new JTextField();
        amountTextField.setBounds(250, 200, 300, 50);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceLabel.setBounds(50, 300, 150, 50);
        balanceLabel.setFont(new Font("Serif", Font.BOLD, 14));
        balanceLabel.setBackground(Color.LIGHT_GRAY);
        balanceLabel.setOpaque(true);
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        balanceLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        JTextField balanceTextField = new JTextField();
        balanceTextField.setBounds(250, 300, 300, 50);

        frame.add(titleLabel);
        frame.add(closeButton);
        frame.add(continueButton);
        frame.add(dateLabel);
        frame.add(dateTextField);
        frame.add(amountLabel);
        frame.add(amountTextField);
        frame.add(balanceLabel);
        frame.add(balanceTextField);

        frame.setVisible(true);
    }

    private static void fetchData() {
        JFrame dataFrame = new JFrame();
        dataFrame.setTitle("Fetched Data");
        dataFrame.setSize(600, 400);
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataFrame.setLayout(new BorderLayout());

        String[] columnNames = {"Date", "Amount", "Balance"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        dataFrame.add(scrollPane, BorderLayout.CENTER);

        // Fetch data from the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT date, amount, balance FROM account_transactions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String date = rs.getString("date");
                String amount = rs.getString("amount");
                String balance = rs.getString("balance");
                tableModel.addRow(new Object[]{date, amount, balance});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data from database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        dataFrame.setVisible(true);
    }
}
