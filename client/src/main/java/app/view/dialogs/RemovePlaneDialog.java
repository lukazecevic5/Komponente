package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class RemovePlaneDialog extends JDialog {
	
	JComboBox<String> planes;
	JButton remove;
	
	public RemovePlaneDialog() {
		planes = new JComboBox<String>();
		remove = new JButton("Remove");
		//populate planes
		
		remove.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = (String) planes.getSelectedItem();
				String arr[] = selected.split(" ");
				long idSel = Long.parseLong(arr[0]);
				
				dispose();
				
			}
		});
		
		add(planes,BorderLayout.CENTER);
		add(remove,BorderLayout.SOUTH);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
