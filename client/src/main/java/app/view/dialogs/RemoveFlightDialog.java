package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;

public class RemoveFlightDialog extends JDialog{
	
	JList<String> flights;
	JButton remove;
	
	public RemoveFlightDialog() {
		flights = new JList<String>();
		remove = new JButton("Remove");
		//populate flights
		
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = (String) flights.getSelectedValue();
				String arr[] = selected.split(" ");
				long idSel = Long.parseLong(arr[0]);
				
				dispose();
				
			}
		});
		
		add(flights,BorderLayout.CENTER);
		add(remove,BorderLayout.SOUTH);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

}
