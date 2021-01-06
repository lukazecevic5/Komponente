package app.view.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.forms.CardForm;
import app.forms.KartaForm;
import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.OptionDialog;

public class AddCardDialog extends JDialog {
	
	JLabel broj,kod;
	JTextField brojT,kodT;
	JButton add;
	
	public AddCardDialog(KartaForm kartaForm) {
		broj = new JLabel("Broj");
		kod = new JLabel("Kod");
		brojT = new JTextField();
		kodT = new JTextField();
		add= new JButton("Add");
		
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardForm form = new CardForm();
				form.setBroj(Integer.parseInt(brojT.getText()));
				form.setKod(Integer.parseInt(kodT.getText()));
				String path = HttpManager.getSelectedPath("service-registrator");
				ResponseEntity<String> res = UtilsMethods.sendPostStr(path+"addCard/"+kartaForm.getUser(), form);
				if (res.getStatusCode()==HttpStatus.ACCEPTED) {
					dispose();
					new PickCardDialog(kartaForm);
				}
				else {
					new OptionDialog();
				}
				
			}
		});
		
		add(broj);
		add(brojT);
		add(kod);
		add(kodT);
		add(add);
		setLayout(new GridLayout(3,2));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
