package app.view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame{
	
	public static void main(String[] args) {
		new RegistrationFrame();
	}
	
	private JLabel ime; 
    private JLabel prezime;
    private JLabel pasos;
    private JLabel email;
    private JLabel password;
	private JButton cancel;
	
	private Container c; 
    private JLabel title; 
    
    private JTextField tname; 
    private JTextField tmno; 
    private JLabel brojPasosa; 
    private JTextField brojPasosaTF; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel sifra; 
    private JTextField sifraTF; 
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
    
    public RegistrationFrame() {
    	setTitle("Registration Form"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registracija naloga"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        ime = new JLabel("Ime:"); 
        ime.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ime.setSize(100, 20); 
        ime.setLocation(250, 100); 
        c.add(ime); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(350, 100); 
        c.add(tname); 
  
        prezime = new JLabel("Prezime:"); 
        prezime.setFont(new Font("Arial", Font.PLAIN, 20)); 
        prezime.setSize(100, 20); 
        prezime.setLocation(250, 150); 
        c.add(prezime); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(190, 20); 
        tmno.setLocation(350, 150); 
        c.add(tmno); 
  
        brojPasosa = new JLabel("Pasos:"); 
        brojPasosa.setFont(new Font("Arial", Font.PLAIN, 20)); 
        brojPasosa.setSize(100, 20); 
        brojPasosa.setLocation(250, 200); 
        c.add(brojPasosa); 
  
        brojPasosaTF = new JTextField(); 
        brojPasosaTF.setFont(new Font("Arial", Font.PLAIN, 15)); 
        brojPasosaTF.setSize(190, 20); 
        brojPasosaTF.setLocation(350, 200); 
        c.add(brojPasosaTF); 
  

        sifra = new JLabel("Sifra:"); 
        sifra.setFont(new Font("Arial", Font.PLAIN, 20)); 
        sifra.setSize(100, 20); 
        sifra.setLocation(250, 250); 
        c.add(sifra); 
  
        sifraTF = new JTextField(); 
        sifraTF.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sifraTF.setSize(190, 20); 
        sifraTF.setLocation(350, 250); 
        c.add(sifraTF); 
  

        sub = new JButton("Submit:"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(250, 350); 
        sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		}); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(370, 350); 
        reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		}); 
        c.add(reset); 
        
        cancel = new JButton("Cancel"); 
        cancel.setFont(new Font("Arial", Font.PLAIN, 15)); 
        cancel.setSize(100, 20); 
        cancel.setLocation(490, 350); 
        cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		}); 
        c.add(cancel); 
  

  
        setVisible(true); 
	}
}
