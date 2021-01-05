package app.view.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app.forms.PlaneForm;

public class AddPlaneDialog extends JDialog {
	
	JLabel name,capacity;
	JTextField nameT,capacityT;
	JButton add;
	
	public AddPlaneDialog() {
		name = new JLabel("Name");
		capacity = new JLabel("Capacity");
		nameT = new JTextField();
		capacityT = new JTextField();
		add = new JButton("Add");
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlaneForm form = new PlaneForm();
				form.setIme(nameT.getText());
				form.setCapacity(Integer.parseInt(capacityT.getText()));
				
				dispose();
				
			}
		});
		
		add(name);
		add(nameT);
		add(capacity);
		add(capacityT);
		add(add);
		setLayout(new GridLayout(3,2));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
