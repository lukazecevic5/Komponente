package letovi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import letovi.entities.Let;

@Repository
public interface LetRepository extends JpaRepository<Let, Long> {
	
	List<Let> findByAvion(long avion);
	List<Let> findByStartdest(String start_dest);
	List<Let> findByEnddest(String end_dest);
	List<Let> findByFlightlen(int flight_len);
	List<Let>  findByPrice(float price);
	Let findById(long id);
}
