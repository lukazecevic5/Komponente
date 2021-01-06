package app.view.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.forms.PlaneForm;
import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.AdminView;
import app.view.OptionDialog;

public class AddPlaneDialog extends JDialog {
	
	JLabel name,capacity;
	JTextField nameT,capacityT;
	JButton add;
	
	public AddPlaneDialog(String username,String password) {
		name = new JLabel("Name");
		capacity = new JLabel("Capacity");
		nameT = new JTextField();
		capacityT = new JTextField();
		add = new JButton("Add");
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				PlaneForm form = new PlaneForm();
				form.setIme(nameT.getText());
				form.setCapacity(Integer.parseInt(capacityT.getText()));
				String path = HttpManager.getSelectedPath("service-letovi");
				ResponseEntity<String> response = UtilsMethods.sendPostStr(path+"addPlane/" + username + "/"+ password, form);
				if (response.getStatusCode()==HttpStatus.ACCEPTED) {
					new OptionDialog("Uspesno dodavanje aviona!");
		            dispose();
		              
		        } else {
		        	new OptionDialog();
		            }
				}
				catch (Exception e1) {
					new OptionDialog();
				}
				
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
