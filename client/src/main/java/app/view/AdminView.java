package app.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import app.view.dialogs.AddFlightDialog;
import app.view.dialogs.AddPlaneDialog;
import app.view.dialogs.RemoveFlightDialog;
import app.view.dialogs.RemovePlaneDialog;

public class AdminView extends JFrame {
	
	JButton addPlane;
	JButton removePlane;
	
	JButton addFlight;
	JButton removeFlight;
	
	public AdminView() {
		addPlane = new  JButton("Add Plane");
		removePlane = new JButton("Remove Plane");
		addFlight = new JButton("Add Flight");
		removeFlight = new JButton("Remove Flight");
		
		addPlane.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddPlaneDialog();
				
			}
		});
		
		removePlane.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RemovePlaneDialog();
				
			}
		});
		
		addFlight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFlightDialog();
				
			}
		});
		
		removeFlight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RemoveFlightDialog();
				
			}
		});
		
		add(addPlane);
		add(removePlane);
		add(addFlight);
		add(removeFlight);
		setLayout(new GridLayout(2,2));
		setSize(400,400);
		setLocationRelativeTo(null);
		setTitle("Admin view");
		setVisible(true);
	}
}
