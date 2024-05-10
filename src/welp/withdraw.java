package welp;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class withdraw {
    withdraw(){
        JFrame withDrawframe = new JFrame();
        withDrawframe.setTitle("IT Bank");
        withDrawframe.setSize(700,640);
        withDrawframe.setResizable(false);
        
        JLabel labels = new JLabel();
        labels.setText("Enter amount: ");
        labels.setBounds(130, 255, 100, 50);
        
        
        
        ImageIcon imageicon = new ImageIcon("C:\\Users\\Admin\\Pictures\\aaalogobsit\\bsitlogos.png");
        withDrawframe.setIconImage(imageicon.getImage());
        
        ImageIcon icons = new ImageIcon("C:\\Users\\Admin\\Pictures\\aaalogobsit\\erasers.png");
        
       
        ImageIcon icon2 = new ImageIcon("C:\\Users\\Admin\\Pictures\\aaalogobsit\\back.png");
     
        
        
        
        JButton button0 = new JButton("0");
        button0.setBounds(300, 500, 50, 50);
        button0.setBackground(Color.LIGHT_GRAY);
        button0.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button1 = new JButton("1");
        button1.setBounds(230, 440, 50, 50);
        button1.setBackground(Color.LIGHT_GRAY);
        button1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button2 = new JButton("2");
        button2.setBounds(300, 440, 50, 50);
        button2.setBackground(Color.LIGHT_GRAY);
        button2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button3 = new JButton("3");
        button3.setBounds(370, 440, 50, 50);
        button3.setBackground(Color.LIGHT_GRAY);
        button3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button4 = new JButton("4");
        button4.setBounds(230, 380, 50, 50);
        button4.setBackground(Color.LIGHT_GRAY);
        button4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button5 = new JButton("5");
        button5.setBounds(300, 380, 50, 50);
        button5.setBackground(Color.LIGHT_GRAY);
        button5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button6 = new JButton("6");
        button6.setBounds(370, 380, 50, 50);
        button6.setBackground(Color.LIGHT_GRAY);
        button6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button7 = new JButton("7");
        button7.setBounds(230, 320, 50, 50);
        button7.setBackground(Color.LIGHT_GRAY);
        button7.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button8 = new JButton("8");
        button8.setBounds(300, 320, 50, 50);
        button8.setBackground(Color.LIGHT_GRAY);
        button8.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton button9 = new JButton("9");
        button9.setBounds(370, 320, 50, 50);
        button9.setBackground(Color.LIGHT_GRAY);
        button9.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton buttonerase = new JButton();
        buttonerase.setBounds(370, 500, 50, 50);
        buttonerase.setBackground(Color.LIGHT_GRAY);
        buttonerase.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonerase.setIcon(icons);
        
        JButton buttonw = new JButton("WITHDRAW");
        buttonw.setBounds(450, 380, 150, 40);
        buttonw.setBackground(Color.GREEN);
        buttonw.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        
        JButton buttonback = new JButton();
        buttonback.setBounds(50, 500, 50, 50);
        buttonback.setBackground(Color.LIGHT_GRAY);
        buttonback.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        buttonback.setIcon(icon2);
        
        
        JTextField textfield = new JTextField();
        textfield.setBounds(230, 250, 190, 40);
        textfield.setBackground(Color.LIGHT_GRAY);
        
        textfield.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        Font textfont = new Font (textfield.getFont().getName(), Font.PLAIN,35);
        
        
        
        
        textfield.setFont(textfont);
        withDrawframe.add(button0);
        withDrawframe.add(button1);
        withDrawframe.add(button2);
        withDrawframe.add(button3);
        withDrawframe.add(button4);
        withDrawframe.add(button5);
        withDrawframe.add(button6);
        withDrawframe.add(button7);
        withDrawframe.add(button8);
        withDrawframe.add(button9);
        withDrawframe.add(buttonw);
        withDrawframe.add(buttonerase);
        withDrawframe.add(textfield);
        withDrawframe.add(labels);
        withDrawframe.add(buttonback);
        
        withDrawframe.setLayout(null);
        withDrawframe.setVisible(true);
    }
}
