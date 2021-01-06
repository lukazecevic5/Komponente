package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import org.springframework.http.ResponseEntity;

import app.utils.HttpManager;
import app.utils.UtilsMethods;

public class ValueDialog extends JDialog {
	
	public ValueDialog(long idUser,String parameter) {
		JTextField txt = new JTextField();
		JComboBox<String> planes;
		JButton ok = new JButton("OK");
		planes = new JComboBox<String>();
		String path = HttpManager.getSelectedPath("service-letovi");
		ResponseEntity<List<Long>> responsePlanes = UtilsMethods.sendGetLs(path+"getPlanes");
		
		for (long a : responsePlanes.getBody()) {
			ResponseEntity<String> responsePlane = UtilsMethods.sendGetStr(path+"getPlane/"+ a );
			planes.addItem(responsePlane.getBody());
		}
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String value = txt.getText();
				List<String> flights = new ArrayList<String>();
				ResponseEntity<List<Long>> flightsRes;

				if(parameter.equals("Plane")) {
					String selected = (String) planes.getSelectedItem();
					String arr[] = selected.split(" ");
					long idSel = Long.parseLong(arr[0]);
					flightsRes = UtilsMethods.sendGetLs(path+"flightsByPlane/"+idSel);
					
				}
				else if(parameter.equals("StartDest")) {
					flightsRes = UtilsMethods.sendGetLs(path+"flightsByStartDest/"+value);
					
				}
				else if(parameter.equals("EndDest")) {
					flightsRes = UtilsMethods.sendGetLs(path+"flightsByEndDest/"+value);
					
				}
				else if(parameter.equals("Len")) {
					int len = Integer.parseInt(value);
					flightsRes = UtilsMethods.sendGetLs(path+"flightsByLen/"+len);
				}
				else{
					float price = Float.parseFloat(value);
					flightsRes = UtilsMethods.sendGetLs(path+"flightsByPrice/"+price);
					
				}
				for (long f : flightsRes.getBody()) {
					ResponseEntity<String> flightRes = UtilsMethods.sendGetStr(path+"getFlight/"+f);
					flights.add(flightRes.getBody());
				}
				new BuyTicketDialog(idUser, flights);
				dispose();
			}
		});
		
		if(parameter.equals("Plane")) {
			add(planes,BorderLayout.CENTER);
		}else {
			add(txt,BorderLayout.CENTER);
		}
		add(ok,BorderLayout.SOUTH);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
