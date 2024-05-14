package tracking;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

  public class tracking {
  public static void main(String[] args) {
 
    JFrame frame = new JFrame();
    frame.setTitle("Account Balance");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1100,900);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.getContentPane().setBackground(new Color(0xFFFFFF));
    
    JLabel labels = new JLabel();
    labels.setText("Bank Account Tracker");
    labels.setBounds(450, 20, 200, 50);
    labels.setForeground(Color.BLACK);
    labels.setVerticalAlignment(JLabel.TOP);
    labels.setHorizontalAlignment(JLabel.CENTER);
    labels.setFont(new Font("Times New Roman",Font.BOLD,20));
    
   
   JButton button1 = new JButton();
   button1.setBounds(200,780,100,50);
   button1.setText("Close");
   button1.setFocusable(false);
   button1.setFont(new Font("Serif",Font.BOLD,14));
   button1.setBackground(Color.LIGHT_GRAY);
   button1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           
   JButton button2 = new JButton();
   button2.setBounds(740,780,100,50);
   button2.setText("Print");
   button2.setFocusable(false);
   button2.setFont(new Font("Serif",Font.BOLD,14));
   button2.setBackground(Color.LIGHT_GRAY);
   button2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
   
   JTextField textfield1 = new JTextField();
   textfield1.setPreferredSize(new Dimension(400,220));
   textfield1.setBounds(210,120,400,100);
   JButton button3 = new JButton("Date");
   button3.setBounds(100,120,100,50);
   button3.setFocusable(false);
   button3.setFont(new Font("Serif",Font.BOLD,14));
   button3.setBackground(Color.LIGHT_GRAY);
   button3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
   
   JTextField textfield2 = new JTextField();
   textfield2.setPreferredSize(new Dimension(400,220));
   textfield2.setBounds(210,250,400,100);
   JButton button4 = new JButton("Amount");
   button4.setBounds(100,250,100,50);
   button4.setFocusable(false);
   button4.setFont(new Font("Serif",Font.BOLD,14));
   button4.setBackground(Color.LIGHT_GRAY);
   button4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
   
   JTextField textfield3 = new JTextField();
   textfield3.setPreferredSize(new Dimension(400,220));
   textfield3.setBounds(210,380,400,100);
   JButton button5 = new JButton("Withdrawal");
   button5.setBounds(100,380,100,50);
   button5.setFocusable(false);
   button5.setFont(new Font("Serif",Font.BOLD,14));
   button5.setBackground(Color.LIGHT_GRAY);
   button5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    
   JTextField textfield4 = new JTextField();
   textfield4.setPreferredSize(new Dimension(400,220));
   textfield4.setBounds(210,510,400,100);
   JButton button6 = new JButton("Deposit");
   button6.setBounds(100,510,100,50);
   button6.setFocusable(false);
   button6.setFont(new Font("Serif",Font.BOLD,14));
   button6.setBackground(Color.LIGHT_GRAY);
   button6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
   
   JTextField textfield5 = new JTextField();
   textfield5.setPreferredSize(new Dimension(400,220));
   textfield5.setBounds(210,640,400,100);
   JButton button7 = new JButton("Balance");
   button7.setBounds(100,640,100,50);
   button7.setFocusable(false);
   button7.setFont(new Font("Serif",Font.BOLD,14));
   button7.setBackground(Color.LIGHT_GRAY);
   button7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

   
    frame.add(labels);
    frame.add(button1);
    frame.add(button2);
    frame.add(textfield1);
    frame.add(textfield2);
    frame.add(textfield3);
    frame.add(textfield4);
    frame.add(textfield5);
    frame.add(button3);
    frame.add(button4);
    frame.add(button5);
    frame.add(button6);
    frame.add(button7);
    
   
    
    
    
        }
    
}
