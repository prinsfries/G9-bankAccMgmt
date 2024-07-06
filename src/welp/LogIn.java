package welp;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LogIn implements ActionListener {
    private static JPanel title, center;
    private static JFrame frame;
    private static JLabel bam, pinLabel, numLabel, word;
    private static JPasswordField pinField, numField;
    private static JButton login, create;

    LogIn() {
        init();
    }

    // JFrame elements responsible for displaying the User Interface
    private void init() {
        // frame
        frame = new JFrame("BANK ACCOUNT MANAGEMENT");
        frame.setSize(420, 420);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center
        center = new JPanel();
        center.setPreferredSize(new Dimension(200, 200));
        center.setLayout(new FlowLayout());

        title = new JPanel(new BorderLayout());

        bam = new JLabel("BANK ACCOUNT MANAGEMENT:");
        bam.setFont(new Font("Arial", Font.BOLD, 24));
        title.add(bam);

        // pin
        pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 16));
        pinLabel.setBounds(10, 50, 80, 25);
        center.add(pinLabel);

        pinField = new JPasswordField(15);
        pinField.setBounds(100, 20, 142, 25);
        center.add(pinField);

        // Account Number
        numLabel = new JLabel("Account Number:");
        numLabel.setFont(new Font("Arial", Font.BOLD, 16));
        numLabel.setBounds(10, 50, 80, 25);
        center.add(numLabel);

        numField = new JPasswordField(15);
        numField.setBounds(100, 20, 142, 25);
        center.add(numField);

        // buttons
        login = new JButton("Login");
        login.setBounds(10, 100, 80, 25);
        login.addActionListener(this);
        center.add(login);

        create = new JButton("Create Account");
        create.setBounds(113, 100, 125, 25);
        create.addActionListener(this);
        center.add(create);

        // word
        word = new JLabel("");
        word.setFont(new Font("Arial", Font.BOLD, 24));
        word.setBounds(10, 150, 300, 25);
        center.add(word);

        // frame.add
        frame.add(bam, BorderLayout.NORTH);
        frame.add(center);
        frame.setVisible(true);
    }

    // ActionEvent follows what course of action to do based on what the user has clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String pass = new String(pinField.getPassword());
        String num = new String(numField.getPassword());

        if (e.getSource() == login) {
            // JDBC connection to Database
            Connection c;
            try {
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
                System.out.print("Connected: ");
                System.out.println(c);
                
                String query = "SELECT * FROM bank WHERE user_Pin=? AND user_num=?";
                PreparedStatement stmt = c.prepareStatement(query);
                stmt.setString(1, pass);
                stmt.setString(2, num);

                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    System.out.println("Login Success");
                    String un = rs.getString("user_names");
                    String pin = rs.getString("user_Pin");
                    String n = rs.getString("user_num");
                    int money = rs.getInt("bank_Amount");
                    System.out.println(un);
                    System.out.println(pin);
                    System.out.println(money);
                    frame.dispose();
                    new MainMenu(un, pin, n, money);
                } else {
                    System.out.println("Login Error");
                    JOptionPane.showMessageDialog(null, "Unsuccessful!");
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Unsuccessful!");
                System.out.println("Error");
                a.printStackTrace();
            }
        } else if (e.getSource() == create) {
            frame.dispose();
            new createAcc();
        } else {
            JOptionPane.showMessageDialog(null, "Unsuccessful!");
        }
    }

    public static void main(String[] args) {
        new LogIn();
    }
}
