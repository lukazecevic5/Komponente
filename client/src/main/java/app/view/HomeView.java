package app.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;

public class HomeView extends JFrame {
	
	JButton login;
	JButton register;
	JButton loginAdmin;
	
	public static void main(String[] args) {
		new HomeView();
	}
	
	public HomeView() {
		setPreferredSize(new Dimension(400, 400));
		setTitle("Home");
		setLocationRelativeTo(null);
		pack();
		
		login = new JButton("Login");
		register = new JButton("Register");
		loginAdmin = new JButton("Login admin");
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame frame = new LoginFrame();
		        frame.setTitle("Login Form");
		        frame.setLocationRelativeTo(null);
		        frame.setVisible(true);
		        frame.setSize(new Dimension(370,600));
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setResizable(false);

				
			}
		});
		
		register.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				
			}
		});
		
		add(login);
		add(register);
		add(loginAdmin);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		
	}

}
