package def;
import OtherPackage.Frame;
import OtherPackage.Button;
public class Okno2  extends Frame{

	public Okno2 () {
		// TODO Auto-generated constructor stub
		Button przycisk = new Button("Przycisk 1"); // creating an object
		przycisk.setBounds(40, 40, 200, 30);  
		przycisk.setVisible(true);
		add(przycisk);
	}	

}
