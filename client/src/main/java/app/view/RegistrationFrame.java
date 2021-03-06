package app.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.forms.RegistrationForm;
import app.utils.HttpManager;
import app.utils.UtilsMethods;

public class RegistrationFrame extends JFrame implements ActionListener{
	
	
	
	
	private JLabel ime; 
    private JLabel prezime;
    private JLabel pasos;
    private JLabel email;
    private JLabel password;
	private JButton cancel;
	private JTextField emailtf;
	
	private Container c; 
    private JLabel title; 
    
    private JTextField tname; 
    private JTextField tmno; 
    private JLabel brojPasosa; 
    private JTextField brojPasosaTF; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel sifra; 
    private JPasswordField sifraTF; 
    private JComboBox month; 
    private JComboBox year; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  
    
    public RegistrationFrame() {
    	setTitle("Registration Form"); 
    	setFont(new Font("Corbel",Font.BOLD,40));
        setBounds(300, 90, 900, 600);
        setPreferredSize(new Dimension(100, 300));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registracija naloga"); 
        title.setFont(new Font("Corbel", Font.PLAIN, 30)); 
        title.setForeground(Color.WHITE);
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        ime = new JLabel("Ime:"); 
        ime.setFont(new Font("Corbel", Font.PLAIN, 20));
        ime.setForeground(Color.WHITE);
        ime.setSize(100, 20); 
        ime.setLocation(250, 100); 
        c.add(ime); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        tname.setSize(239, 20); 
        tname.setLocation(350, 100); 
        c.add(tname); 
  
        prezime = new JLabel("Prezime:"); 
        prezime.setFont(new Font("Corbel", Font.PLAIN, 20)); 
        prezime.setForeground(Color.WHITE);
        prezime.setSize(100, 20); 
        prezime.setLocation(250, 150); 
        c.add(prezime); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        tmno.setSize(239, 20); 
        tmno.setLocation(350, 150); 
        c.add(tmno); 
  
        brojPasosa = new JLabel("Pasos:"); 
        brojPasosa.setFont(new Font("Corbel", Font.PLAIN, 20)); 
        brojPasosa.setForeground(Color.WHITE);
        brojPasosa.setSize(100, 20); 
        brojPasosa.setLocation(250, 200); 
        c.add(brojPasosa); 
  
        brojPasosaTF = new JTextField(); 
        brojPasosaTF.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        brojPasosaTF.setSize(239, 20); 
        brojPasosaTF.setLocation(350, 200); 
        c.add(brojPasosaTF); 
  

        sifra = new JLabel("Sifra:"); 
        sifra.setFont(new Font("Corbel", Font.PLAIN, 20)); 
        sifra.setForeground(Color.WHITE);
        sifra.setSize(100, 20); 
        sifra.setLocation(250, 250); 
        c.add(sifra); 
  
        sifraTF = new JPasswordField(); 
        sifraTF.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        sifraTF.setSize(239, 20); 
        sifraTF.setLocation(350, 250); 
        c.add(sifraTF); 
  
        email = new JLabel("Email:"); 
        email.setFont(new Font("Corbel", Font.PLAIN, 20)); 
        email.setForeground(Color.WHITE);
        email.setSize(100, 20); 
        email.setLocation(250, 300); 
        c.add(email); 
  
        emailtf = new JTextField(); 
        emailtf.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        emailtf.setSize(239, 20); 
        emailtf.setLocation(350, 300); 
        c.add(emailtf); 
        
        
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Corbel", Font.PLAIN, 15));
        sub.setBackground(Color.WHITE);
        sub.setSize(100, 20); 
        sub.setLocation(250, 350); 

        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        reset.setBackground(Color.WHITE);
        reset.setSize(100, 20); 
        reset.setLocation(370, 350); 

        c.add(reset); 
        
        cancel = new JButton("Cancel"); 
        cancel.setFont(new Font("Corbel", Font.PLAIN, 15)); 
        cancel.setBackground(Color.WHITE);
        cancel.setSize(100, 20); 
        cancel.setLocation(490, 350); 

        c.add(cancel); 

        sub.addActionListener(this);
		cancel.addActionListener(this);
		reset.addActionListener(this);
		
		this.getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancel) {
			
			dispose();
			new HomeView();
			
		}
		else if(e.getSource()==sub) {
			try {
				
			RegistrationForm form = new RegistrationForm();
			form.setIme(tname.getText());
			form.setPrezime(tmno.getText());
			form.setEmail(emailtf.getText());
			form.setPassword(sifraTF.getText());
			form.setPasos(Long.parseLong(brojPasosaTF.getText()));
			String path = HttpManager.getSelectedPath("service-registrator");
			ResponseEntity<String> response = UtilsMethods.sendPostStr(path + "register", form);
			if (response.getStatusCode()==HttpStatus.ACCEPTED) {
				dispose();
				new HomeView();
			}
			else {
				new OptionDialog();
			}
			} catch (Exception e2) {
				new OptionDialog();
			}
			
		}
		else {
			String def = ""; 
            tname.setText(def); 
            brojPasosaTF.setText(def); 
            tmno.setText(def); 
            sifraTF.setText(def); 
		}
	}
}
