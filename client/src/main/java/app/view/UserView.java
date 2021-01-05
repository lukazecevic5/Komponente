package app.view;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

import app.view.dialogs.ParametersDialog;

public class UserView extends JFrame{
	
	JButton buyTicket,boughtTickets;
	
	public UserView(long idUser) {
		buyTicket = new JButton("Buy Ticket");
		boughtTickets = new JButton("List all bought tickets");
		
		boughtTickets.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog ticketsView = new JDialog();
				JList<String> tickets = new JList<String>();
				//uzmem karte i stavim u tickets
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
		
		add(buyTicket);
		add(boughtTickets);
		setLayout(new GridLayout(2, 1));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
