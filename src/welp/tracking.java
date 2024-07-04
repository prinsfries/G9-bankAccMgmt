package welp;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;

public class tracking {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "";
    private static String u;

    tracking(String u) {
        this.u=u;
        fetchData();
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
            String query = "SELECT bank_Amount, user_names FROM bank WHERE user_names='"+u+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

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
}
