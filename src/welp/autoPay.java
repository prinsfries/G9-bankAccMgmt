
package welp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class autoPay extends JFrame {
    public JTextField cardNumber1;
    public JTextField expirationDate2;
    public JTextField postalCode3;
    public JTextField securityCode4;
 
    autoPay(){
       this.setTitle("Auto Payments");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel bry= new JPanel();
        bry.setLayout(new GridLayout(5, 2));

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber1 = new JTextField();
        JLabel expirationDate = new JLabel("Expiration Date:");
        expirationDate2 = new JTextField();
        JLabel postalCode = new JLabel("Billing Postal Code:");
        postalCode3= new JTextField();
        JLabel securityCode = new JLabel("Security Code:");
        securityCode4 = new JTextField();

        JButton process = new JButton("Process Payment");

       bry.add(cardNumber);
        bry.add(cardNumber1);
        bry.add(expirationDate);
        bry.add(expirationDate2);
        bry.add(postalCode);
        bry.add(postalCode3);
        bry.add(securityCode);
        bry.add(securityCode4);
        bry.add(process);

        process.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
        String cardNumber = cardNumber1.getText();
        String expirationDate = expirationDate2.getText();
        String postalCode = postalCode3.getText();
        String securityCode = securityCode4.getText();

       
    }
});
          
       add(bry);
        setVisible(true);
    }
public static void main(String[] args) {
      
               new autopay();
    }
    
}
