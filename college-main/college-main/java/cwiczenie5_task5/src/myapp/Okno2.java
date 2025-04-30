package myapp;

//cwiczenie 3 
// klasy
import java.awt.Button;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // interface
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener; // interface

// Okno z przyciskiem 

public class Okno2 extends Frame implements WindowListener, ActionListener { 
	private Button przycisk;
	
	public Okno2() throws HeadlessException{
		super();
		setBounds(10, 10, 400, 400);
		setLayout(null);
		
		przycisk = new Button("Kliknij mnie");
		przycisk.setBounds(40, 40, 200, 20);
		przycisk.setVisible(true);
		przycisk.addActionListener(this);
		add(przycisk);
		
		setVisible(true);
		addWindowListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new Okno2();
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        setTitle("Przycisk został wciśnięty");
    }
	
	
	  @Override
	    public void windowClosing(WindowEvent e) {
	        System.exit(0);
	    }

	
	 @Override
	    public void windowClosed(WindowEvent e) {}

	    @Override
	    public void windowIconified(WindowEvent e) {}

	    @Override
	    public void windowDeiconified(WindowEvent e) {}

	    @Override
	    public void windowActivated(WindowEvent e) {}

	    @Override
	    public void windowDeactivated(WindowEvent e) {}
	}
	
	

}
