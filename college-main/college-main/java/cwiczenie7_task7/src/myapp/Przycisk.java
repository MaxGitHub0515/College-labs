package myapp;

import javax.swing.*;
import java.awt.event.*;
import java.awt.HeadlessException;
// zadanie 3

public class Przycisk extends JFrame implements ActionListener {
    private JButton b;
    private int ilosc = 0;
    
    public Przycisk() throws HeadlessException {
        this.setSize(400, 400);
        b = new JButton("<html>Naciśnij<br>mnie</html>");
        b.addActionListener(this);
        add(b);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Przycisk pl = new Przycisk();
    }

    public void actionPerformed(ActionEvent e) {
        b.setText("<html>Naciśnięto<br>" + (++ilosc) + " razy</html>");
    }
}