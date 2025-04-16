package javax.swing;
import javax.swing.*;

// utworzenie objektu JFrame
public class Desctop {
	public static void main(String[] agrs) {
		JFrame frame = new JFrame("Okno Aplikacji");
		frame.setSize(500, 300);
		frame.show();
	}
}

// dziedziczenie po objekcie JFrame


public class Onko extends JFrame {
	public Okno(int szerokosc, int  wysokosc, String nazwa) {
		super(nazwa);
		this.setSize(szerokosc, wysokosc);
		this.show();
		
	}
	
	public static void main(String[] args) {
		Okno okno = new Okno(500, 300, "Okno aplikacji");
		
	}
}



// 

