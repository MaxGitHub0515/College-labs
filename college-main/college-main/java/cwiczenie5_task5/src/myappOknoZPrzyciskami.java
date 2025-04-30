
import java.awt.*;
import java.awt.event.*;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OknoZPrzyciskami extends Frame implements WindowListener, ActionListener {
    private Button przycisk1, przycisk2, przycisk3, przycisk4, przycisk5;

    public OknoZPrzyciskami() throws HeadlessException {
        super("Okno z wieloma przyciskami");
        setBounds(10, 10, 500, 400);
        setLayout(null);
       addWindowListener(this); // zamykanie 
 
    

  przycisk1 = new Button("Zmień tytuł");
        przycisk1.setBounds(50, 50, 150, 30);
        przycisk1.addActionListener(this);
        add(przycisk1);

        przycisk2 = new Button("Przesuń przycisk 1");
        przycisk2.setBounds(50, 100, 150, 30);
        przycisk2.addActionListener(this);
        add(przycisk2);

        przycisk3 = new Button("Zmień kolor tła");
        przycisk3.setBounds(50, 150, 150, 30);
        przycisk3.addActionListener(this);
        add(przycisk3);

        przycisk4 = new Button("Ukryj przycisk 5");
        przycisk4.setBounds(50, 200, 150, 30);
        przycisk4.addActionListener(this);
        add(przycisk4);

        przycisk5 = new Button("Zamknij");
        przycisk5.setBounds(50, 250, 150, 30);
        przycisk5.addActionListener(this);
        add(przycisk5);

        setVisible(true);
    }


    public static void main(String[] args) {
        new OknoZPrzyciskami();
    }

     public void windowClosing(WindowEvent e) {
        System.exit(0);
    }


    // public void windowOpened(WindowEvent e) {}
    // public void windowClosed(WindowEvent e) {}
    // public void windowIconified(WindowEvent e) {}
    // public void windowDeiconified(WindowEvent e) {}
    // public void windowActivated(WindowEvent e) {}
    // public void windowDeactivated(WindowEvent e) {}
}

  

