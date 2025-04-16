package javax.swing;
import java.awt.*;
import javax.swing.*;




public class RozkladGrid extends JFrame {
	JButton b;
	JLabel l;
	JCheckBox c;
	JRadioButton r1, r2;
	ButtonGroup q;
	JTextArea ta;
	JTextField tr;
	
	
	public RozkladGrid(int szerokosc, int wysokosc, String nazwa) {
		super(nazwa);
		this.setSize(szerokosc, wysokosc);
		this.setLayout(new GridLayout(3,3));
		b = new JButton("przycisk");
		c = new JCheckBox("pole wyboru");
		l = new JLabel("etykieta");
		r1 = new JRadioButton("przycisk radiowy 1");
		r2 = new JRadioButton("przycisk radiowy 2")
		q = new ButtonGroup();
		q.add(r1);
		q.add(r2);
		ta = new JTextArea("obszar tekstowy");
		tf = new JTextField("pole tesktowy");
		add(b);
		add(c);
		add(l);
		add(r1);
		add(r2);
		add(ta);
		add(tf);
		this.show();
		
		
	}
	
	public static void main(String[] args) {
		new RozkladGrid(500, 300, "Rozklady GridLayout")
	}
}
