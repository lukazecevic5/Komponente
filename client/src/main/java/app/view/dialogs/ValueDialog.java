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

public class ValueDialog extends JDialog {
	
	public ValueDialog(long idUser,String parameter) {
		JTextField txt = new JTextField();
		JComboBox<String> planes;
		JButton ok = new JButton("OK");
		planes = new JComboBox<String>();
		//populate planes
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String value = txt.getText();
				List<String> flights = new ArrayList<String>();
				List<Long> resp = new ArrayList<Long>();

				if(parameter.equals("Plane")) {
					long idPlane = Long.parseLong(value);
					
				}
				else if(parameter.equals("StartDest")) {
					//value
					
				}
				else if(parameter.equals("EndDest")) {
					//value
					
				}
				else if(parameter.equals("Len")) {
					int len = Integer.parseInt(value);
				}
				else if(parameter.equals("Price")) {
					float price = Float.parseFloat(value);
					
				}
				for (long long1 : resp) {
					//pravimoStringove i stavljamo u flights
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
