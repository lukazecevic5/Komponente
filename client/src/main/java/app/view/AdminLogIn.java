package app.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.forms.AdminForm;
import app.forms.Login_Form;
import app.utils.HttpManager;
import app.utils.UtilsMethods;

public class AdminLogIn extends JFrame implements ActionListener {
	Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("< BACK");
    JCheckBox showPassword = new JCheckBox("Show Password");


    AdminLogIn() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(200, 300, 100, 30);
        resetButton.setBounds(50, 300, 100, 30);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(resetButton);
        container.add(loginButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
        	try {
	        	String userText;
	            String pwdText;
	            userText = userTextField.getText();
	            pwdText = passwordField.getText();
	            AdminForm form = new AdminForm();
	            form.setUsername(userText);
	            form.setPassword(pwdText);
	            String path = HttpManager.getSelectedPath("service-registrator");
	            ResponseEntity<String> response = UtilsMethods.sendPostStr(path+"loginAsAdmin", form);
	            if (response.getStatusCode()==HttpStatus.ACCEPTED) {
	            	dispose();
	                new AdminView(userText,pwdText);
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
	            }
			} catch (Exception e2) {
				 JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}
           

        }
        if (e.getSource() == resetButton) {
            dispose();
            new HomeView();
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
