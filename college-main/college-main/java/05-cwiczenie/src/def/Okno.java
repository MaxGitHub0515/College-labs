
import java.lang.Object;
import OtherPackage.Frame;
import def.windowListener; // interface
import java.awt.event.windowListener;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.WindowListener;
import java.awt.GraphicsConfiguration;

public class Okno extends Frame implements windowListener {

	public Okno() {
		// TODO Auto-generated constructor stub
		super();
		setBounds(10,10,400,400); // window restrictions
		setVisible(true); // make the window visible 
	
	}
	
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setBounds(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}

	public Okno(GraphicsConfiguration arg0) {
		super(arg0);_
		
	}
	
	public Okno(String arg0) throws HeadlessException {
		super(arg0);
	}
	
	public Okno(String arg0, GraphicsConfiguration arg1) throws HeadlessException {
		super(arg0, arg1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Okno newObject = new Okno();
		
	}

}
