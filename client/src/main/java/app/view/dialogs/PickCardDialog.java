package app.view.dialogs;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.forms.KartaForm;
import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.OptionDialog;

public class PickCardDialog extends JDialog {
	
	public PickCardDialog(KartaForm form) {
		String pathGetCard = HttpManager.getSelectedPath("service-registrator");
		ResponseEntity<List<String>> resCards = UtilsMethods.sendGetLstr(pathGetCard+"getCards/"+form.getUser());
		JComboBox<String> cards = new JComboBox<String>();
		for (String c : resCards.getBody()) {
			cards.addItem(c);
		}
		JButton addCard = new JButton("Add Card"),pay = new JButton("Pay");
		
		pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cards.getSelectedItem()==null) {
					new OptionDialog("Izaberi ili dodaj karticu");
				}
				else {
					String payPath = HttpManager.getSelectedPath("service-karte");
					String card = (String) cards.getSelectedItem();
					String arr[] = card.split(" ");
					long idSel = Long.parseLong(arr[0]);
					ResponseEntity<String> resPay = UtilsMethods.sendPostStr(payPath+"buyKarta/"+idSel,form);
					if (resPay.getStatusCode()==HttpStatus.ACCEPTED) {
						dispose();
						new OptionDialog("Uspesno kupljena karta!");
					}
					else {
						new OptionDialog();
					}
					
				}
				
			}
		});
		
		addCard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AddCardDialog(form);
				
				
			}
		});
		
		add(cards);
		add(addCard);
		add(pay);
		setLayout(new GridLayout(3,1));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
