package cat.botiga.main.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cat.botiga.main.models.Quadre;



@Repository
public interface QuadresDAO extends JpaRepository<Quadre, Integer> {

	void deleteByBotigaId(int id);	
	//long getQuadresByBotiga_Id (Long botiga_id);
	List<Quadre> findQuadreByBotigaId(int botiga_id);
	
	

}
