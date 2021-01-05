package app.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class OptionDialog extends JDialog {

	private JLabel lbl;
	
	public OptionDialog() {
		setPreferredSize(new Dimension(250, 250));
		setTitle("Warning!");
		lbl = new JLabel("Niste uneli validne podatke.");
		add(lbl,BorderLayout.CENTER);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
	public OptionDialog(String text) {
		setPreferredSize(new Dimension(350, 350));
		setTitle("Warning!");
		lbl = new JLabel(text);
		add(lbl,BorderLayout.CENTER);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}
}