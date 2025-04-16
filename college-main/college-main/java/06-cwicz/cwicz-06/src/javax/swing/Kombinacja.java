package javax.swing;
import java.awt.*;
import javax.swing.*;

public class Kombinacja extends JFrame{
	JPanel panel;
	JLabel polnoc, poludnie, wschod, zachod;
	JButton b1,b2,b3,b4,b5,b6;
	public Kombinacja(int szerokosc, int wysokosc, String nazwa) {
		super(nazwa);
		this.setSize(szerokosc, wysokosc);
		polnoc= new JLabel("Polnoc");
		poludnie= new JLabel("Poludnie");
		wchod= new JLabel("Wschod");
		zachod= new JLabel("Zachod");
		panel= new JPanel();
		panel= new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		
		b1 = new JButton("przycisk 1");
		b2 = new JButton("przycisk 2");
		b3 = new JButton("przycisk 3");
		b4 = new JButton("przycisk 4");
		b5 = new JButton("przycisk 5");
		b6 = new JButton("przycisk 6");
		
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		
		add(BorderLayout.CENTER,panel);
		add(BorderLayout.NORTH,polnoc);
		add(BorderLayout.SOUTH,poludnie);
		add(BorderLayout.EAST,wschod);
		add(BorderLayout.WEST,zaschod);
		this.show();
		
	}
	
	public static void main(String[] aegs) {
		Kombinacja kombinacja = new Kombinacja(500, 300, "Kombinacja menedzerow rozkladow")
	}
}
