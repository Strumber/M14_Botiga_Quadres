package cat.botiga.main.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.botiga.main.models.Quadre;



@Repository
public interface QuadresDAO extends JpaRepository<Quadre, Long> {

	long deleteByBotiga_id(Long id);
	
	
	
	long getQuadresByBotiga_Id (Long botiga_id);
		
	
	public List<Quadre> findQuadreByBotiga_Id(int botiga_id);
	
	

}
