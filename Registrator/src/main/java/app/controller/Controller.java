package app.controller;

import static app.security.SecurityConstants.HEADER_STRING;
import static app.security.SecurityConstants.SECRET;
import static app.security.SecurityConstants.TOKEN_PREFIX;

import java.util.Properties;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.activation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import app.entities.Admin;
import app.entities.CreditCard;
import app.entities.User;
import app.forms.AdminForm;
import app.forms.CardForm;
import app.forms.RegistrationForm;
import app.repository.AdminRepository;
import app.repository.CardRepository;
import app.repository.UserRepository;

@RestController
@RequestMapping("")
public class Controller {

	private AdminRepository adminRepo;
	private BCryptPasswordEncoder encoder;
	private UserRepository userRepo;
	private CardRepository cardRepo;

	@Autowired
	public Controller(BCryptPasswordEncoder encoder, UserRepository userRepo, CardRepository cardRepo,AdminRepository adminRepo) {
		this.encoder = encoder;
		this.userRepo = userRepo;
		this.cardRepo = cardRepo;
		this.adminRepo = adminRepo;
	}

	@PostMapping("/register")
	public ResponseEntity<String> subtractionPost(@RequestBody RegistrationForm registrationForm) {

		try {

			User user = new User(registrationForm.getIme(), registrationForm.getPrezime(), registrationForm.getEmail(),
					encoder.encode(registrationForm.getPassword()),registrationForm.getPasos());

			userRepo.saveAndFlush(user);

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	@PostMapping("/loginAsAdmin")
	public ResponseEntity<String> loginAdm(@RequestBody AdminForm form) {

		try {
			
			
			adminRepo.existsByUsername(form.getUsername());
			adminRepo.existsByPassword(form.getPassword());
			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/whoAmI")
	public ResponseEntity<String> whoAmI(@RequestHeader(value = HEADER_STRING) String token) {
		try {

			String email = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build()
					.verify(token.replace(TOKEN_PREFIX, "")).getSubject();

			User user = userRepo.findByEmail(email);

			return new ResponseEntity<>(user.getIme() + " " + user.getPrezime(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addCard")
	public ResponseEntity<String> addCard(@RequestBody CardForm cardForm) {

		try {
			
			CreditCard card = new CreditCard(cardForm.getIme(), cardForm.getPrezime(),cardForm.getBroj(),cardForm.getKod());
			
			
			cardRepo.saveAndFlush(card);
			

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/editUser")
	public ResponseEntity<String> editUser(@RequestBody RegistrationForm registrationForm,@RequestHeader(value = HEADER_STRING) String token) {

		try {
			
			String email = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build()
					.verify(token.replace(TOKEN_PREFIX, "")).getSubject();

			User user = userRepo.findByEmail(email);
			
			user.setIme(registrationForm.getIme());
			
			user.setPrezime(registrationForm.getPrezime());
			
			
			if (!(user.getEmail().equals(registrationForm.getEmail()))) {
				
				sendEmail("lzecevic3718rn@raf.rs", "itsmytime", registrationForm.getEmail());
			     
			}
			user.setEmail(registrationForm.getEmail());
			
			user.setPassword(encoder.encode(registrationForm.getPassword()));
			
			user.setPasos(registrationForm.getPasos());

			userRepo.saveAndFlush(user);

			return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	public void sendEmail(String username, String password, String recipientEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipientEmail));
            message.setSubject("Promenjen e-mail");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent("Uspesno promenjen e-mail!", "text/plain");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);


            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Message to " + recipientEmail + " sent successfully.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
