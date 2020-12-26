package letovi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import letovi.entities.Let;

@Repository
public interface LetRepository extends JpaRepository<Let, Long> {
	
	List<Let> findByAvion(String avion);
	List<Let> findByStart_dest(String start_dest);
	List<Let> findByEnd_dest(String end_dest);
	List<Let> findByFlight_len(int flight_len);
	List<Let>  findByPrice(float price);
}
