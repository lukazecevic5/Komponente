package app.view;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.dialogs.ParametersDialog;

public class UserView extends JFrame{
	
	JButton buyTicket,boughtTickets,editUser;
	
	public UserView(long idUser) {
		buyTicket = new JButton("Buy Ticket");
		boughtTickets = new JButton("List all bought tickets");
		editUser = new JButton("Edit user");
		String path = HttpManager.getSelectedPath("service-karte");
		
		boughtTickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog ticketsView = new JDialog();
				JList<String> tickets;
				ResponseEntity<List<String>> karte = UtilsMethods.sendGetLstr(path+"tickets/" + idUser);
				DefaultListModel<String> model = new DefaultListModel<String>();
				model.addAll(karte.getBody());
				tickets = new JList<String>(model);
				ticketsView.add(tickets);
				ticketsView.setSize(600, 300);
				ticketsView.setLocationRelativeTo(null);
				ticketsView.setVisible(true);
				
			}
		});
		
		buyTicket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ParametersDialog(idUser);
		
			}
		});
		
		editUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditView(idUser);
				
			}
		});
		
		
		add(buyTicket);
		add(boughtTickets);
		add(editUser);
		setLayout(new GridLayout(3, 1));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
