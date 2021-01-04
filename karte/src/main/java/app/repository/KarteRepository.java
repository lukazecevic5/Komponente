package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Karta;

@Repository
public interface KarteRepository extends JpaRepository<Karta, Long>  {

	List<Karta> findByUser(String user);
	
	Karta findById(long id);
	
	List<Karta> findAllByUserOrderByDateDesc(String user);
	
}
