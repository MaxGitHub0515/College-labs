package myapp;

import java.awt.Button;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// cwiczenie 4 - nie skonczone

public class OknoZPrzyciskami extends Frame implements WindowListener, ActionListener {
    private Button przycisk1, przycisk2, przycisk3, przycisk4, przycisk5;

    public OknoZPrzyciskami() throws HeadlessException {
        super("Okno z wieloma przyciskami");
        setBounds(10, 10, 500, 400);
        setLayout(null);
 
    }

    public static void main(String[] args) {
        new OknoZPrzyciskami();
    }

   