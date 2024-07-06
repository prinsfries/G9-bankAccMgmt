package welp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

public class tracking implements ActionListener {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "";
    private int m;
    private String u, p, n;
    private JFrame dataFrame;

    tracking(String u, String p, String n, int m) {
        this.u = u;
        this.m = m;
        this.p = p;
        this.n = n;
        fetchData(u, p, n, m);
    }

    private void fetchData(String u, String p, String n, int m) {
        dataFrame = new JFrame();
        dataFrame.setTitle("Fetched Data");
        dataFrame.setSize(600, 400);
        dataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dataFrame.setLayout(new BorderLayout());

        String[] columnNames = {"Date", "Amount", "Balance"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        dataFrame.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(this);
        dataFrame.add(backButton, BorderLayout.SOUTH);

        // Fetch data from the database
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT bank_Amount, user_names FROM bank WHERE user_names=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, u);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime date = LocalDateTime.now();
                String amount = rs.getString("bank_Amount");
                String balance = rs.getString("user_names");
                tableModel.addRow(new Object[]{date, amount, balance});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error fetching data from database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        dataFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dataFrame.dispose();
        new MainMenu(u, p, n, m);
    }
}
