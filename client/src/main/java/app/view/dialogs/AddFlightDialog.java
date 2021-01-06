package app.view.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.FlatteningPathIterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.forms.LetForm;
import app.utils.HttpManager;
import app.utils.UtilsMethods;
import app.view.OptionDialog;

public class AddFlightDialog extends JDialog{
	
	JLabel plane,start,end,len,price;
	JTextField startT,endT,lenT,priceT;
	JComboBox<String> planes;
	JButton add;
	public AddFlightDialog(String username, String password) {
		plane = new JLabel("Plane");
		start = new JLabel("Start Destination");
		end = new JLabel("End Destination");
		len = new JLabel("Lenght");
		price = new JLabel("Price");
		startT = new JTextField();
		endT = new JTextField();
		lenT = new JTextField();
		priceT = new JTextField();
		add= new JButton("Add");
		planes = new JComboBox<String>();
		String path = HttpManager.getSelectedPath("service-letovi");
		ResponseEntity<List<Long>> responsePlanes = UtilsMethods.sendGetLs(path+"getPlanes");
		
		for (long a : responsePlanes.getBody()) {
			ResponseEntity<String> responsePlane = UtilsMethods.sendGetStr(path+"getPlane/"+ a );
			planes.addItem(responsePlane.getBody());
		}
		add.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				String selected = (String) planes.getSelectedItem();
				String arr[] = selected.split(" ");
				long idSel = Long.parseLong(arr[0]);
				LetForm form = new LetForm();
				form.setEnd_dest(endT.getText());
				form.setStart_dest(startT.getText());
				form.setFlight_len(Integer.parseInt(lenT.getText()));
				form.setPrice(Float.parseFloat(priceT.getText()));
				form.setAvion(idSel);
				
				ResponseEntity<String> response = UtilsMethods.sendPostStr(path+"addFlight/"+username+"/"+password,form);
				if(response.getStatusCode()==HttpStatus.ACCEPTED) {
					dispose();
					new OptionDialog("Uspesno dodat let");
				}
				else new OptionDialog();
				}
				catch(Exception e1){
					new OptionDialog();
				}
			}
		});
		add(plane);
		add(planes);
		add(start);
		add(startT);
		add(end);
		add(endT);
		add(len);
		add(lenT);
		add(price);
		add(priceT);
		add(add);
		setLayout(new GridLayout(6,2));
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
