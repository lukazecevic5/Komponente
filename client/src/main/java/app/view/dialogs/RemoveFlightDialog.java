package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.OptionDialog;

public class RemoveFlightDialog extends JDialog{
	
	JList<String> flights;
	JButton remove;
	
	public RemoveFlightDialog(String username,String password) {
		remove = new JButton("Remove");
		DefaultListModel<String> model = new DefaultListModel<String>();
		String path = HttpManager.getSelectedPath("service-letovi");
		ResponseEntity<List<Long>> responseFlights = UtilsMethods.sendGetLs(path+"getFlights");
		for (long a : responseFlights.getBody()) {
			ResponseEntity<String> responsePlane = UtilsMethods.sendGetStr(path+"getFlight/"+ a );
			model.addElement(responsePlane.getBody());
		}
		flights = new JList<String>(model); 
		
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = (String) flights.getSelectedValue();
				String arr[] = selected.split(" ");
				long idSel = Long.parseLong(arr[0]);
				ResponseEntity<String> response = UtilsMethods.sendGetStr(path+"removeFlight/"+idSel+"/"+username+"/"+password);
				if(response.getStatusCode()==HttpStatus.ACCEPTED) {
					dispose();
					new OptionDialog("Uspesno obrisan let");
				}
				else {
					new OptionDialog();
				}
				
				
			}
		});
		
		add(flights,BorderLayout.CENTER);
		add(remove,BorderLayout.SOUTH);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

}
