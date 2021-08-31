package cat.botiga.main.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cat.botiga.main.models.Botiga;

@Repository
public interface BotiguesDAO extends JpaRepository<Botiga, Long> {
	
	@Query("select new Botiga(id , name, capacity) from Botiga")
	public List<Botiga> getAllStoresNameAndCapacity();
	
	

}
