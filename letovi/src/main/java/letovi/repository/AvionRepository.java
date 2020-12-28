package letovi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import letovi.entities.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
	
	Avion findByIme(String ime);

}
