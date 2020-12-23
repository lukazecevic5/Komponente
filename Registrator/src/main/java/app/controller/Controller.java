package app.controller;

import static app.security.SecurityConstants.HEADER_STRING;
import static app.security.SecurityConstants.SECRET;
import static app.security.SecurityConstants.TOKEN_PREFIX;

import java.util.Properties;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
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

import app.entities.CreditCard;
import app.entities.User;
import app.forms.CardForm;
import app.forms.RegistrationForm;
import app.repository.CardRepository;
import app.repository.UserRepository;

@RestController
@RequestMapping("")
public class Controller {

	private BCryptPasswordEncoder encoder;
	private UserRepository userRepo;
	private CardRepository cardRepo;

	@Autowired
	public Controller(BCryptPasswordEncoder encoder, UserRepository userRepo, CardRepository cardRepo) {
		this.encoder = encoder;
		this.userRepo = userRepo;
		this.cardRepo = cardRepo;
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
	public ResponseEntity<String> addCard(@RequestBody CardForm cardForm,@RequestHeader(value = HEADER_STRING) String token) {

		try {
			
			String email = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build()
					.verify(token.replace(TOKEN_PREFIX, "")).getSubject();

			User user = userRepo.findByEmail(email);
			
			CreditCard card = new CreditCard(user.getIme(), user.getPrezime(),cardForm.getBroj(),cardForm.getKod());
			
			
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
			
			userRepo.delete(user);
			
			user.setIme(registrationForm.getIme());
			
			user.setPrezime(registrationForm.getPrezime());
			
			
			if (!(user.getEmail().equals(registrationForm.getEmail()))) {
				
			      String to = registrationForm.getEmail();

			      String from = "airline@gmail.com";

			      String host = "localhost";

			      Properties properties = System.getProperties();

			      properties.setProperty("mail.smtp.host", host);

			      Session session = Session.getDefaultInstance(properties);

			      try {
			         MimeMessage message = new MimeMessage(session);

			         message.setFrom(new InternetAddress(from));

			         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			         message.setSubject("Promenjen email");

			         message.setText("Mail je promenjen na vasem nalogu za bukiranje letova.");

			         Transport.send(message);
			         System.out.println("Sent message successfully....");
			      } catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
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

}
