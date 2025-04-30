package myapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// zadanie 6

public class Kalkulator extends JFrame implements ActionListener {
    JTextField t1, t2;
    JButton b;
    JLabel l;
    JRadioButton r1, r2, r3, r4, r5;
    JPanel poludniowy, centralny;
    int operacja;
    
    ActionListener radioSluch = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String tekst = ((JRadioButton)e.getSource()).getText();
            if(tekst.equals("+")) {
                b.setText("Dodaj");
                operacja = 1;
            }
            if(tekst.equals("-")) {
                b.setText("Odejmij");
                operacja = 2;
            }
            if(tekst.equals("*")) {
                b.setText("Pomnoz");
                operacja = 3;
            }
            if(tekst.equals("/")) {
                b.setText("Podziel");
                operacja = 4;
            }
            if(tekst.equals("^")) {
                b.setText("Poteguj");
                operacja = 5;
            }
    };

    public Kalkulator() throws HeadlessException {
        this.setSize(400, 400);
        operacja = 1;
        setLayout(new BorderLayout());
        
        poludniowy = new JPanel();
        poludniowy.setLayout(new GridLayout(1, 5));
        ButtonGroup bg = new ButtonGroup();
        
        r1 = new JRadioButton("+");
        r1.setSelected(true);
        r1.addActionListener(radioSluch);
        bg.add(r1);
        poludniowy.add(r1);
        
        r2 = new JRadioButton("-");
        r2.addActionListener(radioSluch);
        bg.add(r2);
        poludniowy.add(r2);
        
        r3 = new JRadioButton("*");
        r3.addActionListener(radioSluch);
        bg.add(r3);
        poludniowy.add(r3);
        
        r4 = new JRadioButton("/");
        r4.addActionListener(radioSluch);
        bg.add(r4);
        poludniowy.add(r4);
        
        // zadanie 7
        r5 = new JRadioButton("^");
        r5.addActionListener(radioSluch);
        bg.add(r5);
        poludniowy.add(r5);
        
        
        add(poludniowy, BorderLayout.SOUTH);
        
        centralny = new JPanel();
        centralny.setLayout(new GridLayout(3, 2));
        centralny.add(new JLabel("a = "));
        t1 = new JTextField();
        centralny.add(t1);
        centralny.add(new JLabel("b = "));
        t2 = new JTextField();
        centralny.add(t2);
        b = new JButton("Dodaj");
        b.addActionListener(this);
        centralny.add(b);
        l = new JLabel();
        centralny.add(l);
        
        add(centralny, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Kalkulator kl = new Kalkulator();
    }

    public void actionPerformed(ActionEvent e) {
        float a = 0, b = 0;
        boolean sukces = true;
        
        try {
            String s = t1.getText();
            a = Float.parseFloat(s);
        } catch(Exception exc) {
            t1.setText("");
            sukces = false;
            JOptionPane.showMessageDialog(centralny, 
                "a powinna być liczbą", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        try {
            String s = t2.getText();
            b = Float.parseFloat(s);
        } catch(Exception exc) {
            t2.setText("");
            sukces = false;
            JOptionPane.showMessageDialog(centralny, 
                "b powinna być liczbą", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

        if(sukces) {
            switch(operacja) {
                case 1:
                    l.setText("wynik = " + (a + b));
                    break;
                case 2:
                    l.setText("wynik = " + (a - b));
                    break;
                case 3:
                    l.setText("wynik = " + (a * b));
                    break;
                case 4:
                    if(b == 0) {
                        JOptionPane.showMessageDialog(this.getContentPane(),
                            "Dzielenie przez 0", "Błąd", JOptionPane.ERROR_MESSAGE);
                    } else {
                        l.setText("wynik = " + (a / b));
                    }
                case 5: // Potegowanie
                    l.setText("wynik = " + Math.pow(a, b));
                    break;
                    break;
            }
        }
    }
}