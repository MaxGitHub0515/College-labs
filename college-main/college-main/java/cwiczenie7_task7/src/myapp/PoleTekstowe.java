package myapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// zadanie 4
public class PoleTekstowe extends JFrame implements ActionListener {
    JTextField t;
    JLabel l;
    JButton b;
    
    public PoleTekstowe() throws HeadlessException {
        this.setSize(400, 400);
        this.setLayout(new GridLayout(5, 1));
        add(new JLabel("Wpisz jakiś tekst"));
        t = new JTextField();
        add(t);
        b = new JButton("OK");
        b.addActionListener(this);
        add(b);
        add(new JLabel("Tekst odwrócony:"));
        l = new JLabel();
        add(l);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        PoleTekstowe tl = new PoleTekstowe();
    }

    public void actionPerformed(ActionEvent e) {
        String s = t.getText();
        if(s.length() == 0) {
            JOptionPane.showMessageDialog(this.getContentPane(), 
                "Nie wpisałeś tekstu", "Błąd", JOptionPane.ERROR_MESSAGE);
        } else {
            String sl = "";
            for(int i = s.length() - 1; i >= 0; i--) {
                sl += s.charAt(i);
            }
            l.setText(sl);
        }
    }
}