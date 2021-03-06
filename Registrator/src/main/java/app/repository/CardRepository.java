package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.CreditCard;

public interface CardRepository extends JpaRepository<CreditCard, Long>{
	
	CreditCard findById(long id);
	
	CreditCard findByBroj(long broj);
	
	CreditCard findByIme(String ime);
	
	List<CreditCard> findByUser(long user);
	

}
