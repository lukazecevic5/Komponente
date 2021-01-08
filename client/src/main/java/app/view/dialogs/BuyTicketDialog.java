package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.ListModel;

import org.springframework.http.ResponseEntity;

import app.forms.KartaForm;
import app.utils.HttpManager;
import app.view.OptionDialog;

public class BuyTicketDialog extends JDialog {
	
	public BuyTicketDialog(long idUser, List<String> flights) {
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.addAll(flights);
		JList<String> flightsView = new JList<String>(model);
		JButton buy = new JButton("Buy");
		
		buy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = flightsView.getSelectedValue();
				String arr[] = selected.split(" ");
				long idSel = Long.parseLong(arr[0]);
				KartaForm form = new KartaForm();
				form.setLet(idSel);
				form.setUser(idUser);
				new PickCardDialog(form);
				dispose();
				
			}
		});
		
		add(flightsView,BorderLayout.CENTER);
		add(buy,BorderLayout.SOUTH);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
