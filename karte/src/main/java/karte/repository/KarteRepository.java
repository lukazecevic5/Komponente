package karte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import karte.entities.Karta;


public interface KarteRepository extends JpaRepository<Karta, Long>  {

	Karta findByEmail(String email);
	
}
