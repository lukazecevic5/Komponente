package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class ParametersDialog extends JDialog {

	
	public ParametersDialog(long idUser) {
		String[] par = { "Plane", "StartDest", "EndDest", "Len", "Price" };
		JComboBox<String> parameters = new JComboBox<String>(par);
		JButton okPar = new JButton("OK");
		
		okPar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ValueDialog(idUser, (String) parameters.getSelectedItem());
				dispose();
				
			}
		});
		
		add(parameters,BorderLayout.CENTER);
		add(okPar,BorderLayout.SOUTH);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
