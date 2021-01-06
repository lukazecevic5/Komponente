package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.OptionDialog;

public class RemovePlaneDialog extends JDialog {
	
	JComboBox<String> planes;
	JButton remove;
	
	public RemovePlaneDialog(String username, String password) {
		
		planes = new JComboBox<String>();
		remove = new JButton("Remove");
		String path = HttpManager.getSelectedPath("service-letovi");
		ResponseEntity<List<Long>> responsePlanes = UtilsMethods.sendGetLs(path+"getPlanes");
		
		for (long a : responsePlanes.getBody()) {
			ResponseEntity<String> responsePlane = UtilsMethods.sendGetStr(path+"getPlane/"+ a );
			planes.addItem(responsePlane.getBody());
		}
		
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selected = (String) planes.getSelectedItem();
				String arr[] = selected.split(" ");
				long idSel = Long.parseLong(arr[0]);
				ResponseEntity<String> response = UtilsMethods.sendGetStr(path+"removePlane/"+idSel+"/"+username+"/"+password);
				if(response.getStatusCode()==HttpStatus.ACCEPTED) {
					dispose();
					new OptionDialog("Uspesno obrisan avion");
				}
				else {
					new OptionDialog();
				}
				
			}
		});
		
		add(planes,BorderLayout.CENTER);
		add(remove,BorderLayout.SOUTH);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
