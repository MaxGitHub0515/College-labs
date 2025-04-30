package myapp;

import java.awt.*;
import javax.swing.*;

public class RozkladGrid extends JFrame{
	JButton b;
	JLabel l;
	JCheckBox e;
	JRadioButton r1, r2;
	ButtonGroup g;
	JTextArea ta;
	JTextField tf;
	
	public RozkladGrid(int szerokosc, int wysokosc, String nazwa) {
		super(nazwa);
		this.setSize(szerokosc, wysokosc);
		this.setLayout(new GridLayout(3, 3));
		
		b = new JButton("przycisk");
		c = new JCheckBox("pole wyboru");
		l = new JLabel("etykieta");
		r1 = new JRadioButton("przycisk radiowy 1");
		r2 = new JRadioButton("przycisk radiowy 2");
		g = new Button();
		g.add(r1);
		g.add(r2);
		
		ta = new JTextArea("obszar tekstowy");
		tf = new JTextField("pole tekstowe");
		
		add(b);
		add(c);
	    add(l);
        add(r1);
        add(r2);
        add(ta);
        add(tf);
	
        this.setVisible(true);
        }

        public static void main(String[] args) {
            new RozkładGrid(500,300,"Rozkład GridLayout");
        }
    }
