package myapp;

/*
 * // TEMAT - DZIEDZICZENIE + WBUDOWANE KLASY ORAZ INTERFACY

 * cwicz 1
 * public class Test extends Frame {
 * 	public static void main(String[] args) {
 * 		Test a = new Test();
 * 		a.setBounds(10,10,200,200);
 * 		a.setVisible(true);
 * 
 */ 
import java.awt.GraphicsConfiguration; //class
import java.awt.HeadlessException; //class
import java.awt.event.WindowEvent; //class
import java.awt.event.WindowListener; // interface

// cwiczenie 2
// Okno z możliwością zamknięcia

 class Okno extends Frame implemets WindowListener {
	public Okno() throws HeadlessException{
		super();
		setBounds(10, 10, 400, 400);
		setVisible(true);
		this.addWindowListener(this)
	}
	
	public static void main(String[] args) {
		new Okno()
	}
	
    @Override
    public void windowOpened(WindowEvent e) {}

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
 
 
 