package letovi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import letovi.entities.Avion;

public interface AvionRepository extends JpaRepository<Avion, Long> {
	
	Avion findByIme(String ime);

}
