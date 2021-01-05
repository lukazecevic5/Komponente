package app.view.dialogs;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddFlightDialog extends JDialog{
	
	JLabel plane,start,end,len,price;
	JTextField startT,endT,lenT,priceT;
	JComboBox<String> planes;
	JButton add;
	public AddFlightDialog() {
		plane = new JLabel("Plane");
		start = new JLabel("Start Destination");
		end = new JLabel("End Destination");
		len = new JLabel("Lenght");
		price = new JLabel("Price");
		startT = new JTextField();
		endT = new JTextField();
		lenT = new JTextField();
		priceT = new JTextField();
		add= new JButton("Add");
		planes = new JComboBox<String>();
		//populate planes
		
		add(plane);
		add(planes);
		add(start);
		add(startT);
		add(end);
		add(endT);
		add(len);
		add(lenT);
		add(price);
		add(priceT);
		add(add);
		setLayout(new GridLayout(6,2));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
